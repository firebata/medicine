package com.cnfwsy.spider.htmlparser.thread;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.queue.DataSaveQueue;
import org.apache.log4j.Logger;


/**
 * @author zhangjh
 */
public class DataSaveThread implements Runnable {
    Logger logger = Logger.getLogger(DataSaveThread.class.getName());

    @Override
    public void run() {
        Object object = DataSaveQueue.pop();
        if (object != null) {
            DbUtils.insert(object);
        }
    }

}
