package com.cnfwsy.spider.htmlparser.buss.ecaihr;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigInteger;

/**
 * 说明:
 * Created by zhangjh on 2016-08-30.
 */
public enum ReadEcaihrJobHelper {
    SINGLETONE;
    static Logger logger = Logger.getLogger(ReadEcaihrJobHelper.class.getName());

    //http://www.ecaihr.com/company/43848/job-190605.html
    public void readJobUrl(String url) {

        try {

            int dsdexx = url.indexOf("y/");
            int dsdyxx = url.indexOf("/j");

            int HORIZONTAL_LINE = url.indexOf("-");

            int POINT_HTML = url.indexOf(".html");

            String companyidStr = url.substring(dsdexx + 2, dsdyxx);
            String jobidStr = url.substring(HORIZONTAL_LINE + 1, POINT_HTML);

            BigInteger companyId = new BigInteger(companyidStr).add(AppConstant.Addend);

            BigInteger jobId = new BigInteger(jobidStr).add(AppConstant.Addend);


            Document doc = Jsoup.connect(url).get();
            String comname = doc.select(".comname").first().text();
            String nowjobname = doc.select(".nowjobname").first().text();
            String jobname = nowjobname;


            //公司更新部分
            Ent_company company = new Ent_company();
            company.setCompany_id(companyId);
            Elements lxfs = doc.select("span#spLsfs li");

            parseCompany(company, lxfs);

            company.setThird_id(companyId);
            company.setThird_kind(AppConstant.ecaihr);
            company.setStatus(AppConstant.status_0);
            company.setStep(AppConstant.step_2);
            company.setCompany_name(comname);
            DbUtils.updateComEcaihr(company);

            //职位部分
            Ent_jobinfo jobinfo = new Ent_jobinfo();
            if (nowjobname.contains("(")) {
                jobname = nowjobname.substring(0, nowjobname.indexOf("("));
            }
            jobinfo.setJob_name(jobname);
            jobinfo.setJob_id(jobId);
            jobinfo.setThird_id(jobId);
            jobinfo.setThird_kind(AppConstant.ecaihr);
            jobinfo.setStatus(AppConstant.status_0);
            jobinfo.setStep(AppConstant.step_2);
            jobinfo.setCompany_id(companyId);
            jobinfo.setCompany_name(comname);
            Elements jobsjcxx = doc.select("div.jobsjcxx ul li");
            parseJobInfo(jobinfo, jobsjcxx);

            String msbdy = doc.select("div.msbdy").first().html();
            jobinfo.setJob_desc(msbdy);

            DbUtils.insert(jobinfo);

        } catch (Exception e) {
            logger.error("解析公司详细页面出错,url>>" + url);
        }
    }

    private void parseJobInfo(Ent_jobinfo jobinfo, Elements jobsjcxx) {
        for (Element element : jobsjcxx) {
            String val = element.text();
            int beginidxOfColon = val.indexOf("：") + 1;
            String realVal = "";
            if (val.length() > beginidxOfColon) {
                realVal = val.substring(beginidxOfColon);
            }
            logger.info(val);
            if (val.contains("工作地点")) {
                jobinfo.setAddress(realVal);
            } else if (val.contains("招聘人数")) {
                logger.info("招聘人数：" + realVal);
                int quantity = 0;
                if (realVal.contains("人")) {
                    quantity = Integer.parseInt(realVal.substring(0, realVal.indexOf("人")));
                }

                jobinfo.setQuantity(quantity);
            } else if (val.contains("薪资待遇")) {
                jobinfo.setPayroll(realVal);
            } else if (val.contains("工作年限")) {
                jobinfo.setExperience_name(realVal);
            } else if (val.contains("学历要求")) {
                jobinfo.setEducation_name(realVal);
            }
        }

    }

    /**
     * @param company
     * @param lxfs
     */
    public void parseCompany(Ent_company company, Elements lxfs) {
        for (Element element : lxfs) {
            String val = element.text();
            int beginidxOfColon = val.indexOf("：") + 1;
            String realVal = "";
            if (val.length() > beginidxOfColon) {
                realVal = val.substring(beginidxOfColon);
            }
//            logger.info(val);
            if (val.contains("联系人")) {
                company.setContact_man(realVal);
            } else if (val.contains("联系电话")) {
                company.setTelephone(realVal);
            } else if (val.contains("传真")) {
//                    company.setCompany_type_name(realVal);
            } else if (val.contains("电子邮箱")) {
                if (realVal.contains("@")) {
                    company.setEmail(realVal);
                }
            } else if (val.contains("企业地址")) {
                company.setCompany_address(realVal);
            } else if (val.contains("企业网址")) {
                company.setUrl(realVal);
            }
        }
    }


    public static void main(String[] args) {
        String url = "http://www.ecaihr.com/company/43848/job-190605.html";
        ReadEcaihrJobHelper.SINGLETONE.readJobUrl(url);
    }

}
