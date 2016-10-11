package com.cnfwsy.spider.htmlparser.buss.dxy;

import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.htmlparser.queue.DataSaveQueue;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 说明:读取职位列表的信息
 * Created by zhangjh on 2016-07-26.
 */
public class ReadDxyJobThread implements Runnable {
    private String typeUrl;
    private String job_type_name;
    private int maxPageNo = 1;
    static Logger logger = Logger.getLogger(ReadDxyJobThread.class.getName());
    static String[] provinceArr = new String[]{"全国", "北京", "上海", "天津", "重庆", "河北", "山西", "内蒙古", "辽宁", "吉林", "黑龙江", "江苏", "浙江", "安徽", "福建", "江西", "山东", "河南", "湖北", "湖南", "广东", "广西", "海南", "四川", "贵州", "云南", "西藏", "陕西", "甘肃", "新疆", "青海", "宁夏", "香港", "澳门", "台湾"};

    public ReadDxyJobThread(String typeUrl, String job_type_name) {
        this.typeUrl = typeUrl;
        this.job_type_name = job_type_name;
    }

    @Override
    public void run() {
        String now = LocalDate.now().toString();
        int pageNo = 1;
        boolean isNoCalcMaxPageNo = true;
        boolean isToday = true;
        Set<Ent_jobinfo> ent_jobinfos = new HashSet<>();
        Set<Ent_company> ent_companies = new HashSet<>();
        while (pageNo <= maxPageNo && isToday) {
            String url = typeUrl;
            if (pageNo > 1) {
                url = typeUrl + "?location=&pge=" + pageNo;
            }
            try {

                //增加userAgent，防止返回手机页面
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2729.4 Safari/537.36").get();

                isNoCalcMaxPageNo = isNoCalcMaxPageNo(now, isNoCalcMaxPageNo, ent_jobinfos, ent_companies, doc);

            } catch (IOException e) {
                logger.error("读取jobtype url异常：" + url);
                logger.error(e.getMessage(), e);
            }
            pageNo++;
        }

        DataSaveQueue.put(ent_jobinfos);
        DataSaveQueue.put(ent_companies);
    }

    private boolean isNoCalcMaxPageNo(String now, boolean isNoCalcMaxPageNo, Set<Ent_jobinfo> ent_jobinfos, Set<Ent_company> ent_companies, Document doc) {
        Elements uls = doc.select("div .rm-box .rm-dd ul");
        for (Element ul : uls) {//所有职位
            Ent_jobinfo jobinfo = new Ent_jobinfo();
            Ent_company company = new Ent_company();
            jobinfo.setJob_type_name(job_type_name);
            jobinfo.setThird_kind(AppConstant.dxy);
            jobinfo.setStep(AppConstant.step_0);
            jobinfo.setStatus(AppConstant.status_0);
            company.setThird_kind(AppConstant.dxy);
            company.setStep(AppConstant.step_0);
            company.setStatus(AppConstant.status_0);
            Elements lis = ul.select("li");
            int index = 0;
            for (Element li : lis) {//每一个职位解析
                if (index == 0) {//公司名和职位名
                    Elements as = li.getElementsByTag("a");
                    String jobName = (as.get(0).attr("title")).trim();
                    String jobUrl = (as.get(0).attr("href")).trim();
                    int lastBackSlash = jobUrl.lastIndexOf("/");
                    int lashDecimal = jobUrl.lastIndexOf(".");
                    BigInteger jobId = null;
                    try {
                        jobId = new BigInteger(jobUrl.substring(lastBackSlash + 1, lashDecimal));
                        if (null != jobId) {
                            jobId = jobId.add(AppConstant.Addend);
                        }
                    } catch (Exception e) {
                        logger.error(e.getMessage(), e);
                    }

                    String companyName = (as.get(1).attr("title")).trim();
                    String comUrl = (as.get(1).attr("href")).trim();
                    BigInteger companyId = null;

                    lastBackSlash = comUrl.lastIndexOf("/");
                    lashDecimal = comUrl.lastIndexOf(".");
                    companyId = new BigInteger(comUrl.substring(lastBackSlash + 1, lashDecimal));
                    if (null != companyId) {
                        companyId = companyId.add(AppConstant.Addend);
                    }

                    jobinfo.setJob_name(jobName);
                    jobinfo.setJob_url(jobUrl);
                    jobinfo.setJob_id(jobId);
                    jobinfo.setCompany_name(companyName);
                    jobinfo.setCom_url(comUrl);
                    jobinfo.setCompany_id(companyId);
                    jobinfo.setThird_id(jobId);

                    company.setCompany_name(companyName);
                    company.setCom_url(comUrl);
                    company.setCompany_id(companyId);
                    company.setThird_id(jobId);


                } else if (index == 1) { //地点
                    String address = li.text();
                    for (String province : provinceArr) {
                        if (address.contains(province)) {
                            int len = province.length();
                            String province_name = address.substring(0, len);
                            String city_name = address.substring(len);
                            jobinfo.setProvince_name(province_name);
                            jobinfo.setCity_name(city_name);
                            break;
                        }
                    }
                    jobinfo.setAddress(address);
                } else if (index == 2) {//
//                            String publishDate = li.text();
//                            if (!publishDate.equals("今天")) {//只找出今天发布的职位
//                                isToday = false;
//                            } else {
                    jobinfo.setPublish_date(now);
                    ent_jobinfos.add(jobinfo);
                    ent_companies.add(company);
//                            }
                }
                index++;
            }
        }

        if (isNoCalcMaxPageNo) {
//            Elements lis = doc.select("div .list-pager .pager li");//找到总页码所在的li下标：倒数第一个li的下标
//            if (null != lis && lis.size() > 0) {
//                int liCount = lis.size();
//                int maxPageNoIndx = liCount - 4;
//                int maxPageNo = Integer.parseInt(lis.get(maxPageNoIndx).text().trim());
//                this.maxPageNo = maxPageNo;
//                isNoCalcMaxPageNo = false;
//            }
            Elements lis = doc.select("div .list-pager .pager li.pager-next ");//找到“下一页”的li
            if (null != lis && lis.size() > 0) {
                this.maxPageNo = Integer.parseInt(lis.get(0).previousElementSibling().text());//“下一页”之前的lis为总页数
                isNoCalcMaxPageNo = false;
            }

        }
        return isNoCalcMaxPageNo;
    }
}
