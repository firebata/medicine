package com.cnfwsy.spider.htmlparser.thread;


import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.htmlparser.queue._51job._51jobJobUrlQueue;
import com.cnfwsy.spider.htmlparser.queue.dxy.DxyJobUrlQueue;
import com.cnfwsy.spider.htmlparser.queue.liepin.LiepinJobUrlQueue;
import com.cnfwsy.spider.htmlparser.queue.zhaopin._zhaopinJobUrlQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 查询职位和公司地址
 *
 * @author Administrator
 */
public class QueryJobUrlThread implements Runnable {
    int begin = 0, length = 10;

    String querySql = "";
    Logger logger = LoggerFactory.getLogger(QueryJobUrlThread.class);

    public QueryJobUrlThread() {
        super();
    }

    /**
     * @param begin
     * @param length
     * @param querySql
     */
    public QueryJobUrlThread(int begin, int length, String querySql) {
        this.begin = begin;
        this.length = length;
        this.querySql = querySql;
    }

    /**
     *
     */
    @Override
    public void run() {
        String querySql = "select job_id,job_name,address,company_id,company_name,province_name,city_name,job_type_name,job_url,com_url,third_kind from  t_ent_jobinfo where step =0 ";
        List<Ent_jobinfo> jobinfos = DbUtils.queryList(querySql, Ent_jobinfo.class);
        parseDetail(jobinfos);
    }

    /**
     * @param jobinfos
     */
    private void parseDetail(List<Ent_jobinfo> jobinfos) {

        if (null != jobinfos) {
            for (Object object : jobinfos) {
                Ent_jobinfo jobinfo = (Ent_jobinfo) object;
                // 数据来源
                String third_kind = jobinfo.getThird_kind();
                jobinfo.setStep(AppConstant.step_1);
                DbUtils.updateJobStep(jobinfo);

                if (third_kind.equals(AppConstant._51job)) {
                    _51jobJobUrlQueue.put(jobinfo);
                } else if (third_kind.equals(AppConstant.liepin)) {
                    LiepinJobUrlQueue.put(jobinfo);
                } else if (third_kind.equals(AppConstant.dxy)) {
                    DxyJobUrlQueue.put(jobinfo);
                } else if (third_kind.equals(AppConstant.zhaopin)) {
                    _zhaopinJobUrlQueue.put(jobinfo);
                }


            }
        }
    }

}