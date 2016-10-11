package com.cnfwsy.spider.htmlparser.buss.dxy;

import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.buss.dxy.helper.ReadDxyJobHelper;
import com.cnfwsy.spider.htmlparser.queue.dxy.DxyJobUrlQueue;
import org.apache.log4j.Logger;

/**
 * 说明:
 * Created by zhangjh on 2016-07-26.
 */
public class ReadDxyJobDetail implements Runnable {
    Logger logger = Logger.getLogger(ReadDxyJobDetail.class.getName());

    @Override
    public void run() {

        while (true) {
            Ent_jobinfo jobinfo = DxyJobUrlQueue.pop();
            if (null == jobinfo) {
                continue;
            }
            ReadDxyJobHelper.SINGLETONE.readJobUrl(jobinfo);
        }
    }

}