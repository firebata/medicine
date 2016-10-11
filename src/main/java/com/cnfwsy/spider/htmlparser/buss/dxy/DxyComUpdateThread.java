package com.cnfwsy.spider.htmlparser.buss.dxy;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.queue.dxy.DxyComUpdateQueue;
import org.apache.log4j.Logger;

/**
 *
 */
public class DxyComUpdateThread implements Runnable {
    Logger logger = Logger.getLogger(DxyComUpdateThread.class.getName());

    @Override
    public void run() {
        while (true) {
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Ent_company company = DxyComUpdateQueue.pop();
            if (company != null) {
                DbUtils.updateCom(company);
            }

        }
    }

}