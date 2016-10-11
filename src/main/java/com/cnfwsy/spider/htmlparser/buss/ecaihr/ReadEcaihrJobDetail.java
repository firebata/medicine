package com.cnfwsy.spider.htmlparser.buss.ecaihr;

import com.cnfwsy.spider.htmlparser.queue.ecaihr.EcaihrJobUrlQueue;
import org.apache.log4j.Logger;

/**
 * 说明:
 * Created by zhangjh on 2016-08-30.
 */
public class ReadEcaihrJobDetail implements Runnable {
    Logger logger = Logger.getLogger(ReadEcaihrJobDetail.class.getName());

    @Override
    public void run() {

        String url = EcaihrJobUrlQueue.pop();
        if (null == url) {
            return;
        }
        logger.info("职位url:" + url);

        ReadEcaihrJobHelper.SINGLETONE.readJobUrl(url);

    }

}
