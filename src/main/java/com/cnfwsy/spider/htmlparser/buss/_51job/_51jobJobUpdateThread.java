package com.cnfwsy.spider.htmlparser.buss._51job;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.queue._51job._51jobJobUpdateQueue;
import org.apache.log4j.Logger;
public class _51jobJobUpdateThread implements Runnable {
    Logger logger = Logger.getLogger(_51jobJobUpdateThread.class.getName());

    @Override
    public void run() {
        Ent_jobinfo job = _51jobJobUpdateQueue.pop();
        if (job != null) {
            DbUtils.updateJob(job);
        }
    }

}
