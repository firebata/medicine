package com.cnfwsy.spider.htmlparser.buss._51job;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.queue._51job._51jobComUpdateQueue;
import org.apache.log4j.Logger;

public class _51jobComUpdateThread implements Runnable {
    Logger logger = Logger.getLogger(_51jobJobUpdateThread.class.getName());

    @Override
    public void run() {
        Ent_company company = _51jobComUpdateQueue.pop();
        if (company != null) {
            DbUtils.updateCom(company);
        }
    }

}