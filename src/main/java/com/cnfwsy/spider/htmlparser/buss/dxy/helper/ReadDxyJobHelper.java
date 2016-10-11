package com.cnfwsy.spider.htmlparser.buss.dxy.helper;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.htmlparser.queue.dxy.DxyJobUpdateQueue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 说明:
 * Created by zhangjh on 2016-07-26.
 */
public enum ReadDxyJobHelper {
    SINGLETONE;
    Logger logger = Logger.getLogger(ReadDxyJobHelper.class.getName());

    /**
     * @param jobinfo
     */
    public void readJobUrl(Ent_jobinfo jobinfo) {

        int step = jobinfo.getStep();
        String url = jobinfo.getJob_url();
        logger.info("职位url:" + url);

        if (step == AppConstant.step_1) {// 职位概述阶段才解析职位详细信息，避免重复解析

            jobinfo.setStep(AppConstant.step_2);
            Ent_company company = new Ent_company();
            company.setCompany_id(jobinfo.getCompany_id());

            company.setThird_kind(AppConstant.dxy);
            company.setStep(AppConstant.step_2);

            try {

                Document doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2729.4 Safari/537.36").get();
                //职位要求
                Elements lis = doc.select("div .jobs_apply .apply_cnt .pos_request  li");
                if (null != lis && lis.size() > 0) {
                    for (Element li : lis) {
                        String txt = li.text().trim();
                        int colonIndex = txt.indexOf("：");
                        String val = txt.substring(colonIndex + 1).trim();
                        if (txt.contains("学历要求：")) {
                            jobinfo.setEducation_name(val);
                        } else if (txt.contains("专业要求：")) {
                            jobinfo.setPro_requr(val);
                        } else if (txt.contains("工作年限：")) {
                            jobinfo.setExperience_name(val);
                        } else if (txt.contains("月薪范围：")) {
                            jobinfo.setPayroll(val);
                        } else if (txt.contains("职位性质：")) {
                            jobinfo.setJob_nature_name(val);
                        } else if (txt.contains("工作地点：")) {
                            jobinfo.setAddress(val);
                        } else if (txt.contains("职称要求：")) {
                            jobinfo.setTitle_requr(val);
                        } else if (txt.contains("招聘人数：")) {
                            int renIndex = val.indexOf("人");
                            int quantity = 0;
                            if (-1 != renIndex) {
                                val = val.substring(0, renIndex);
                                if (StringUtils.isNumeric(val)) {
                                    quantity = Integer.parseInt(val);
                                }
                            }
                            jobinfo.setQuantity(quantity);

                        } else if (txt.contains("职称要求：")) {
                            jobinfo.setTitle_requr(val);
                        }
                    }


                }

                //职位描述
                Elements about_poss = doc.select("div .jobs_apply .apply_cnt .about_pos  .about_pos_cnt");
                if (null != about_poss && about_poss.size() > 0) {
                    jobinfo.setJob_desc(about_poss.get(0).html());
                }

                //联系人
                Elements contacts = doc.select("div .jobs_apply .apply_hosp .about_pos_cnt p");
                if (null != contacts && contacts.size() > 0) {
                    Elements as = contacts.get(0).select("a");
                    if (null != as && as.size() > 0) {
                        String emailAll = as.get(0).attr("href");
                        String name = as.get(0).text();
                        String email = emailAll.substring(emailAll.indexOf(":") + 1);
                        company.setEmail(email.trim());
                        company.setContact_man(name.trim());
                    }
                    String allContactInfos = contacts.get(0).html();
                    String[] allContactInfoArr = allContactInfos.split("<br>");
                    for (String contact : allContactInfoArr) {
                        int index = contact.indexOf("：");
                        String val = contact.substring(index + 1);
                        if (contact.contains("话：")) {//电话
                            String tel = val;
                            company.setTelephone(tel);
                        } else if (contact.contains("址：")) {//地址
                            String address = val;
                            company.setCompany_address(address);
                        } else if (contact.contains("机：")) {//手机
                            String mobile = val;
                            company.setMobile(mobile);
                        }
                    }
                }

                //公司介绍
                Elements companyDescs = doc.select("div .jobs_apply .apply_hosp .about_pos_cnt #art_description-full");
                if (null != companyDescs && companyDescs.size() > 0) {
                    company.setSummary(companyDescs.get(0).html());
                }
                DxyJobUpdateQueue.put(jobinfo);
//                DxyComUpdateQueue.put(company);
                DbUtils.updateComDxy2(company);
            } catch (Exception e) {
                logger.error("解析职位报错", e);
            }

        }
    }

    public static void main(String[] args) {
        ReadDxyJobHelper h = ReadDxyJobHelper.SINGLETONE;
        Ent_jobinfo jobinfo = new Ent_jobinfo();
        jobinfo.setStep(AppConstant.step_1);
        jobinfo.setJob_url("http://www.jobmd.cn/work/437149.htm");
        h.readJobUrl(jobinfo);
    }
}
