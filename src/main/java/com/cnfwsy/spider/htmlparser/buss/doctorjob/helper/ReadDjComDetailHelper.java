package com.cnfwsy.spider.htmlparser.buss.doctorjob.helper;

import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.htmlparser.queue.DataSaveQueue;
import com.cnfwsy.spider.htmlparser.queue.doctorjob.DoctorjobJobUrlQueue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * 说明:
 * Created by zhangjh on 2016-08-03.
 */
public enum ReadDjComDetailHelper {

    SINGLETONE;
    public final static String PREFIX_COM = "http://www.doctorjob.com.cn/logo/speciality/index/";
    public final static String SUFFIX_COM = "/index.jsp";

    Logger logger = Logger.getLogger(ReadDjComDetailHelper.class.getName());

    /**
     * 公司页面没有固定模板，但是所有公司页面的title格式是相同的，都是"某医院——中国医疗人才网"或者”某医院--中国医疗人才网“，或者”麦盖提县人民医院-欢迎您！”采用以下形式解析：
     * 1，公司名从title中获取
     * 1，找到@所在的所有兄弟节点
     * 2，找到公司名所在所有兄弟节点
     * 3，找到所有的a节点，是否有job.jsp,如果有跳转到job.jsp，获取所有职位url存放到职位url队列中。如果当前页面就有职位信息，获取所有职位url信息存放到职位url队列中
     *
     * @param url
     */
    public void parse(String url, String comNo) {

        try {
            BigInteger companId = new BigInteger(comNo).add(AppConstant.Addend);
            Document doc = Jsoup.connect(url).get();
            String titleStr = doc.title();// doc.select("title");
            Ent_company company = new Ent_company();
            company.setCompany_id(companId);
            company.setThird_id(companId);
            String companyName = "";
            int idx = 0;
            if ((idx = titleStr.indexOf("---")) != -1) {
            } else if ((idx = titleStr.indexOf("———")) != -1) {
            } else if ((idx = titleStr.indexOf("——")) != -1) {
            } else if ((idx = titleStr.indexOf("--")) != -1) {

            } else if ((idx = titleStr.indexOf("—")) != -1) {

            } else if ((idx = titleStr.indexOf("-")) != -1) {

            }
            companyName = titleStr.substring(0, idx);
            if (companyName.contains("医院")) {
                company.setIndustry_id(AppConstant.yiyuan_industryid);
                company.setIndustry_name(AppConstant.yiyuan_industryname);
            }
            if (StringUtils.isNotBlank(companyName)) {
                company.setCompany_name(companyName);
                Elements allEs = doc.getAllElements();
                String allCon = "";
                String allConHtml = "";
                List<String> allDesc = new ArrayList<>();
                String summary = "";
                for (Element el : allEs) {

                    String txt = el.text();
                    String html = el.html();
                    Matcher emailM = AppConstant.EMAiL_PATTERN.matcher(txt);
                    Matcher mobileM = AppConstant.MOBILE_PATTERN.matcher(txt);
                    Matcher telM = AppConstant.TEL_PATTERN.matcher(txt);
                    String ids = el.attr("id");
                    String id = "";
                    if (StringUtils.isNotBlank(ids)) {

                    }
                    String className = el.className();
                    if (className.equals("ny") || className.equals("title_ny") || txt.contains("简介") || (StringUtils.isNotBlank(ids) && ids.trim().equals("a"))) {
                        summary = html;
                    }
                    if (txt.contains(companyName)) {
                        if (txt.length() > 200) {//字符数大于30，并且集合最后的元素为企业描述
//                            logger.info("txt>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//                            logger.info("txt>>>" + txt);
//                            logger.info("html>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//                            logger.info(html);
//                            allDesc.add(html);
                        }
                    }

                    if (txt.contains("@")) {
                        //邮箱
                        StringBuilder stringBuilder = new StringBuilder();

                        while (emailM.find()) {
                            String email = emailM.group();
                            stringBuilder.append(email);
                            stringBuilder.append(";");
                        }


                        String emails = stringBuilder.toString();


                        if (StringUtils.isNotBlank(emails)) {
                            company.setEmail(emails);
                        }
                        if (txt.contains("邮编") || txt.contains("人") || txt.contains("地址")) {
                            allCon = txt;
                            allConHtml = html;
                        }
                    }

                    if (txt.contains("邮编") || txt.contains("人") || txt.contains("地址")) {
                        if (StringUtils.isBlank(allCon)) {
                            allCon = txt;
                            allConHtml = html;
                        }

                    }

                    if (mobileM.find()) {
//                        allCon = txt;
                        //手机
                        StringBuilder stringBuilder = new StringBuilder();
                        String mobile = mobileM.group();
                        stringBuilder.append(mobile);
                        stringBuilder.append(";");
                        while (mobileM.find()) {
                            mobile = mobileM.group();
                            stringBuilder.append(mobile);
                            stringBuilder.append(";");
                        }
                        String mobiles = stringBuilder.toString();
                        if (StringUtils.isNotBlank(mobiles)) {
                            company.setMobile(mobiles);
                        }
                    }


                    if (telM.find()) {
//                        allCon = txt;
                        //座机
                        StringBuilder stringBuilder = new StringBuilder();
                        String tel = telM.group();
                        stringBuilder.append(tel);
                        stringBuilder.append(";");
                        while (telM.find()) {
                            tel = telM.group();
                            stringBuilder.append(tel);
                            stringBuilder.append(";");
                        }
                        String tels = stringBuilder.toString();
                        if (StringUtils.isNotBlank(tels)) {
                            company.setTelephone(tels);
                        }
                    }
                    if (allCon.length() < 300) {
                        company.setAll_con(allCon);
                    } else {
//                        company.setSummary(allConHtml);
                        company.setSummary(allCon);
                    }

                }
                if (StringUtils.isNotBlank(summary)) {
                    company.setSummary(summary);
                }
                if (!allDesc.isEmpty()) {
                    summary = allDesc.get(allDesc.size() - 1);
                    company.setSummary(summary);
                }

                company.setCom_url(url);
                company.setThird_kind(AppConstant.doctorjob);
                company.setStep(AppConstant.step_0);
                company.setStatus(AppConstant.status_0);
            }
            DataSaveQueue.put(company);
            logger.info(company);

        } catch (Exception e) {
            logger.error("解析企业url出错：" + url);
        }
    }

    public static void main(String[] args) {

//        int[] comNos = new int[]{217366};
//        for (int comNo : comNos) {
//            String url = "http://www.doctorjob.com.cn/logo/speciality/index/" + comNo + "/index.jsp";
//            ReadDjComDetailHelper.SINGLETONE.parseCompany(url, comNo + "");
//        }


    }

    public void readComUrl(Ent_company cominfo) {


        String comUrl = cominfo.getCom_url();
        BigInteger comId = cominfo.getCompany_id();
        String comName = cominfo.getCompany_name();
        BigInteger comIdReal = comId.subtract(AppConstant.Addend);
        String url = "";

        String prefix = PREFIX_COM;
        Document doc = null;
        //有无job页面
        try {
            url = prefix + comIdReal + "/job.jsp";
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            logger.error("解析企业url的职位过程出错：" + url);
            //匹配所有的 a标签
            try {
                doc = Jsoup.connect(url).get();
            } catch (IOException ex) {
                logger.error("解析企业url的职位过程出错：" + url);
            }
        }

        if (null != doc) {
            Elements els = doc.select("a");
            for (Element el : els) {
                Element hrefEl = el.tagName("href");
                if (null != hrefEl) {
                    String href = hrefEl.text();
                    if (StringUtils.isNotBlank(href)) {
                        if (href.contains(ReadDjJobHelper.PREFIX_JOB)) {
                            logger.info("发现" + comName + "的职位url：" + url);
                            DoctorjobJobUrlQueue.put(url);
                        }

                    }

                }


            }

        }


    }
}
