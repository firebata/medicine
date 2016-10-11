package com.cnfwsy.spider.htmlparser.buss.ecaihr;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.buss._51job.helper.Read51CompanyHelper;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.htmlparser.queue.ecaihr.EcaihrJobUrlQueue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigInteger;

/**
 * 说明:
 * Created by zhangjh on 2016-08-22.
 */
public class ReadEcaihrComDetail implements Runnable {
    static Logger logger = Logger.getLogger(Read51CompanyHelper.class.getName());
    private int noStart, noEnd;
    private int no = 0;
    private static String domain = "http://www.ecaihr.com";
    private static String http = "http://www.ecaihr.com/company/";
    private static String suffix = "/index.html";

    public ReadEcaihrComDetail() {
        super();
    }

    public ReadEcaihrComDetail(int noStart, int noEnd) {
        this.noEnd = noEnd;
        this.noStart = noStart;
    }


    public void parse(int noStart, int noEnd) {
        for (no = noStart; no <= noEnd; no++) {
//            logger.info("===========================ecaihr===========================>no=" + no);
            String url = http + no + suffix;
            parse(url, String.valueOf(no));
        }
    }

    /**
     * @param url
     * @param companyId
     */
    public static void parse(String url, String companyId) {
        try {

            Document doc = Jsoup.connect(url).get();
            String html = doc.select("html").text();
            if (StringUtils.isBlank(html)) {
//                logger.info("这个url不存在:" + url);
                return;
            }

            Ent_company company = new Ent_company();
            company.setCompany_id(new BigInteger(companyId).add(AppConstant.Addend));
            //企业描述
            String desc = doc.select(".Pcominfo .gbg22 p").html();
            company.setSummary(desc);
            //公司信息描述
            Elements gsxxs = doc.select("ul#showgsxx li");
            for (Element element : gsxxs) {
                String val = element.text();
                int beginidxOfColon = val.indexOf("：") + 1;
                String realVal = "";
                if (val.length() > beginidxOfColon) {
                    realVal = val.substring(beginidxOfColon);
                }
                String className = element.className();
                if (StringUtils.isNotBlank(className) && className.equals("comname")) {
                    String comname = val;
                    company.setCompany_name(comname);
                } else if (val.contains("所在地区")) {
                    company.setCompany_address(realVal);
                    company.setCity_name(realVal);
                } else if (val.contains("企业规模")) {
                    company.setCompany_size_name(realVal);
                } else if (val.contains("企业性质")) {
                    company.setCompany_type_name(realVal);
                }

            }

            //联系方式
            Elements lxfs = doc.select("span#spLsfs li");
            ReadEcaihrJobHelper.SINGLETONE.parseCompany(company, lxfs);

            company.setThird_id(new BigInteger(companyId).add(AppConstant.Addend));
            company.setThird_kind(AppConstant.ecaihr);
            company.setStatus(AppConstant.status_0);
            company.setStep(AppConstant.step_0);

//            logger.info(company);

            DbUtils.insert(company);

            //职位url

            Elements joburls = doc.select("div.joblist2 ul li a");
            for (Element ahref : joburls) {
                String href = ahref.attr("href");
                String joburl = domain + href;
                EcaihrJobUrlQueue.put(joburl);
            }


        } catch (Exception e) {
            logger.error("解析公司详细页面出错,url>>" + url);
        }
    }

    public static void main(String[] args) {
        String url = "http://www.ecaihr.com/company/43848/index.html";
        parse(url, "43848");

    }

    @Override
    public void run() {
        parse(noStart, noEnd);
    }
}
