package com.cnfwsy.spider.htmlparser.buss.doctorjob.helper;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.htmlparser.queue.DataSaveQueue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigInteger;

/**
 * 说明:
 * Created by zhangjh on 2016-08-04.
 */
public enum ReadDjJobHelper {
    SINGLETONE;
    public final static String PREFIX_JOB = "http://doctorjob.com.cn/resume/util/p";
    public final static String domain = "http://doctorjob.com.cn";
    public final static String SUFFIX_JOB = ".html";
    Logger logger = Logger.getLogger(ReadDjJobHelper.class.getName());

    public void readurl(String url) {
        try {
            Ent_company company = new Ent_company();
            Ent_jobinfo job = new Ent_jobinfo();
            job.setJob_url(url);
            String jobidStr = url.substring(url.indexOf("/p") + 2, url.lastIndexOf("."));
            BigInteger jobId = new BigInteger(jobidStr.trim()).add(AppConstant.Addend);
            Document doc = Jsoup.connect(url).get();
            //职位部分
            String posName = doc.select("#posName").first().attr("value") == null ? "" : doc.select("#posName").first().attr("value");
            if (StringUtils.isBlank(posName)) {
                posName = doc.select(".process_title .fl").first() == null ? "" : doc.select("#posName").first().text();
            }

            String request = doc.select(".process_engineer_fontstop").first().text();
            String[] requestArr = request.split("丨"); // <p>面议</p>丨<span><i>广州市 </i></span>丨<span>经验不限</span>丨<span>大专</span>


            for (int index = 0, len = requestArr.length; index < len; index++) {
                String val = requestArr[index].trim();
                if (index == 0) {
                    job.setPayroll(val);
                } else if (index == 1) {
                    job.setCity_name(val);
                } else if (index == 2) {
                    job.setExperience_name(val);
                } else if (index == 3) {
                    job.setEducation_name(val);
                }
            }


            String job_desc = doc.select(".description .description_listind").first().text();
            job.setJob_desc(job_desc);
            String publishDateStr = doc.select(".process_engineerfonts .process_titlein").text();
            String publishDate = publishDateStr.substring(0, publishDateStr.indexOf("发"));
            job.setPublish_date(publishDate);


            //公司部分
            BigInteger companyId;
            String companyName = "";
            String comUrl = "";
            Element companyIdE = doc.select(".Process_Engineer_right  .Process_engineer_top h5 a").first();
            String comUrlHref = companyIdE.attr("href");
            company.setUrl(comUrlHref);
            companyName = companyIdE.text();
            BigInteger thirdComId = new BigInteger(comUrlHref.substring(comUrlHref.lastIndexOf("/") + 1, comUrlHref.indexOf(".")));
            companyId = thirdComId.add(AppConstant.Addend);


            try {
                comUrl = ReadDjComDetailHelper.PREFIX_COM + thirdComId + ReadDjComDetailHelper.SUFFIX_COM;
                Jsoup.connect(comUrl).get();
            } catch (Exception e) {
                logger.error("企业url不存在" + comUrl);
                comUrl = domain + comUrlHref.trim();
            }

            job.setCompany_id(companyId);
            job.setCom_url(comUrl);
            job.setCompany_name(companyName);


            company.setCompany_id(companyId);
            company.setCompany_name(companyName);
            company.setCom_url(comUrl);


            Elements comDetailStr = doc.select(".Process_Engineer_right  .postion_title_r p");
            for (Element e : comDetailStr) {
                String href = e.select("img").attr("src");
                String txt = e.text();
                if (href.contains("icom_home")) {
                    company.setUrl(txt);
                } else if (href.contains("icom_leftin")) {
                    company.setHosp_type_name(txt);
                } else if (href.contains("icom_li")) {
                    company.setCompany_size_name(txt);
                } else if (href.contains("icom_map")) {
                    company.setCompany_address(txt);
                }
            }

            job.setJob_name(posName);
            job.setJob_id(jobId);
            job.setThird_id(jobId);
            job.setThird_kind(AppConstant.doctorjob);
            job.setStatus(AppConstant.status_0);
            job.setStep(AppConstant.step_2);
            job.setJob_url(url);

            DataSaveQueue.put(job);

            comUrl = domain + comUrlHref.trim();

            Document comDoc = Jsoup.connect(comUrl).get();
            String desc = comDoc.select(".bagrond_infee .contatn_magesser").first().html();
            company.setThird_id(jobId);
            company.setThird_kind(AppConstant.doctorjob);
            company.setStatus(AppConstant.status_0);
            company.setStep(AppConstant.step_2);
            company.setSummary(desc);
            DbUtils.insert(company);
            DbUtils.updateDjCom(company);

        } catch (Exception e) {
            logger.error("解析职位的url过程出错：" + url);
        }

    }


    public static void main(String[] args) {
        String url = "http://www.doctorjob.com.cn/resume/util/p444484.html";
        ReadDjJobHelper.SINGLETONE.readurl(url);
    }

    public void readJobUrl(String jobUrl) {

    }
}
