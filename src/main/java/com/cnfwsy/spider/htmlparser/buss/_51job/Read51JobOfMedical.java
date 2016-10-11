package com.cnfwsy.spider.htmlparser.buss._51job;

import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.buss._51job.helper.Read51JobHelper;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.time.LocalDate;
import java.util.List;

/**
 * zai
 * <p>
 * 读取职位列表信息
 *
 * @author zhangjh
 */
public class Read51JobOfMedical implements Runnable {
    private String httpAll = "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=030200%2C00&district=000000&funtype=1300&industrytype=46&issuedate=9&providesalary=99&keywordtype=2&curr_page=";

    private String http = "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=000000%2C00&district=000000&funtype=1300&industrytype=46&issuedate=9&providesalary=99&keywordtype=2&curr_page=";
    private String suffix = "&lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&list_type=0&fromType=14&dibiaoid=0&confirmdate=9";
    private int noStart, noEnd;
    private int count=0;
    Logger logger = Logger.getLogger(Read51JobOfMedical.class.getName());

    public Read51JobOfMedical() {
        super();
    }

    public Read51JobOfMedical(int noStart, int noEnd) {
        this.noEnd = noEnd;
        this.noStart = noStart;
    }

    public Read51JobOfMedical(int noStart, int noEnd, String http, String suffix) {
        this.noEnd = noEnd;
        this.noStart = noStart;
        this.http = http;
        this.suffix = suffix;
    }

    public void parese(int noStart, int noEnd) {
        for (int no = noStart; no <= noEnd; no++) {
            logger.info("===========================分割线===========================no=" + no);
            parse(no);
        }
    }

    public void parse(int pageNo) {
        String page_no = String.valueOf(pageNo);
        try {
            String url = http + page_no + suffix;
            // logger.info("爬虫程序开始，当前网址==>" + url);
            Document doc = Jsoup.connect(url).get();
            Elements jobs = doc.select("div .dw_table .el");
            List<Ent_jobinfo> Ent_jobinfos = Read51JobHelper.SINGLETONE.model(jobs, pageNo, url, "");
            if (null != Ent_jobinfos) {

            }
            doc = null;
        } catch (Exception e) {
            logger.error("异常情况,no=" + pageNo);
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    public void run() {

        LocalDate today = LocalDate.now();
        logger.info("开始解析今天【" + today + "】的职位数据>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//			String querySql = "select publish_date from t_ent_jobinfo order by publish_date desc limit 1";
//			List<Ent_jobinfo> jobinfos = DbUtils.queryList(querySql, Ent_jobinfo.class);
//			if (null == jobinfos || jobinfos.size() == 0) {
//				parese(noStart, noEnd);
//			}
        if(count == 0){//暂时这样写：执行完一次不再执行
            parese(noStart, noEnd);
            count++;
        }


        logger.info("今天【" + today + "】的职位结束<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


    }


}
