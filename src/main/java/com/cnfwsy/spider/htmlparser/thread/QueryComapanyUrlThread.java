package com.cnfwsy.spider.htmlparser.thread;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.htmlparser.queue._51job._51jobComUrlQueue;
import com.cnfwsy.spider.htmlparser.queue.doctorjob.DoctorjobComUrlQueue;
import com.cnfwsy.spider.htmlparser.queue.dxy.DxyComUrlQueue;
import com.cnfwsy.spider.htmlparser.queue.liepin.LiepinComUrlQueue;
import com.cnfwsy.spider.htmlparser.queue.zhaopin._zhaopinComUrlQueue;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * 查询企业url列表
 *
 * @author zhangjh
 */
public class QueryComapanyUrlThread implements Runnable {

    Logger logger = Logger.getLogger(QueryComapanyUrlThread.class.getName());

    public QueryComapanyUrlThread() {

        super();

    }

    @Override
    public void run() {
        String querySql = "select company_id,company_name,com_url,third_kind from t_ent_company where step =0 ";
        // limit " + begin
        // + "," + length;
        // querySql = querySq+ " limit " + begin + "," + length;
        List<Ent_company> companies = DbUtils.queryList(querySql, Ent_company.class);
        parseDetail(companies);
    }

    /**
     * @param companies
     */
    private void parseDetail(List<Ent_company> companies) {

        if (null != companies) {
            for (Object obejct : companies) {
                Ent_company company = (Ent_company) obejct;
                String third_kind = company.getThird_kind();
                company.setStep(AppConstant.step_1);
                DbUtils.updateCompanyStep(company);

                if (third_kind.equals(AppConstant._51job)) {
                    _51jobComUrlQueue.put(company);
                } else if (third_kind.equals(AppConstant.liepin)) {
                    LiepinComUrlQueue.put(company);
                } else if (third_kind.equals(AppConstant.dxy)) {
                    DxyComUrlQueue.put(company);
                } else if (third_kind.equals(AppConstant.zhaopin)) {
                    _zhaopinComUrlQueue.put(company);
                } else if (third_kind.equals(AppConstant.doctorjob)) {
                    DoctorjobComUrlQueue.put(company);
                }
            }
        }
    }

}