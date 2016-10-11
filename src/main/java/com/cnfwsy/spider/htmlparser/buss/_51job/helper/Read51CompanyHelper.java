package com.cnfwsy.spider.htmlparser.buss._51job.helper;

import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.htmlparser.queue._51job._51jobComUpdateQueue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.math.BigInteger;

public enum Read51CompanyHelper {

    SINGLETONE;
    Logger logger = Logger.getLogger(Read51CompanyHelper.class.getName());

    /**
     * @param cominfo
     * @param step
     * @param url
     */
    public void readComUrl(Ent_company cominfo, int step, String url) {
        if (step == AppConstant.step_1) {// 职位概述阶段才解析职位详细信息，避免重复解析
            String companyName = "";
            cominfo.setThird_kind(AppConstant._51job);
            try {
                Document doc = Jsoup.connect(url).get();
                BigInteger companyId = cominfo.getCompany_id();
                Elements comNames = doc.select("div .tCompany_center .tHeader .in h1");
                companyName = comNames.get(0).text();
                // 公司简介部分
                Elements comdescs = doc.select("div .tCompany_center .tHeader .in .ltype");
                if (null != comdescs && comdescs.size() > 0) {
                    String val = comdescs.get(0).text();
                    if (StringUtils.isNotBlank(val)) {
                        String[] descArr = val.split("\\|");
                        for (int i = 0; i < descArr.length; i++) {
                            String field = descArr[i];
//                            field = String.repleace("\\s","");
                            if (i == 0) {
                                String company_type_name = field;
                                cominfo.setCompany_type_name(company_type_name);
                            } else if (i == 1) {
                                String company_size_name = field;
                                cominfo.setCompany_size_name(company_size_name);
                            } else if (i == 2) {
                                String industry_name = field;
                                String industry_name1 = industry_name;
                                if(industry_name.contains(" ")){
                                    int idxKG = industry_name.indexOf(" ");
                                    industry_name1 =  industry_name.substring(0,idxKG);
                                    String industry_name2 =  industry_name.substring(idxKG+1);
                                    cominfo.setIndustry_name2(industry_name2);
                                }
                                cominfo.setIndustry_name(industry_name1.trim());
                            }
                        }
                    }
                }

                // 公司介绍
                Elements comDetailDesc = doc.select("div .tCompany_full .tBorderTop_box .tmsg .con_msg .in p");
                if (null != comDetailDesc && comDetailDesc.size() > 0) {
                    String summary = comDetailDesc.get(0).html();
                    if (StringUtils.isNotBlank(summary)) {
                        cominfo.setSummary(summary);
                    }
                }
                // 公司地址 && 公司官网

                Elements comAddressAndWebSite = doc.select("div .tCompany_full .tBorderTop_box .bmsg p");
                if (null != comAddressAndWebSite && comAddressAndWebSite.size() > 0) {
                    String valStr = comAddressAndWebSite.get(0).text();
                    String val = valStr.substring(valStr.indexOf("：") + 1);
                    if (valStr.contains("公司地址")) {
                        String company_address = val;
                        cominfo.setCompany_address(company_address);
                    } else {
                        String comWebsite = val;
                        cominfo.setUrl(comWebsite);
                    }
                }
                cominfo.setStep(AppConstant.step_2);

                _51jobComUpdateQueue.put(cominfo);

                Elements jobs = doc.select("div .table_list .dw_table .el");
                String comUrl = cominfo.getCom_url();

                if (!comUrl.contains("=")) {// 非官网公司地址时，改为系统地址
                    comUrl = "/entCompanyDetail/" + companyId;
                    cominfo.setCom_url(comUrl);
                }

                // 公司详细页的查询
                Read51JobHelper.SINGLETONE.model(jobs, 1, url, companyName);

            } catch (Exception e) {
                logger.error("解析职位异常，当前职位url：" + url, e);
            }

        }
    }
}
