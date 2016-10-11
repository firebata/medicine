package com.cnfwsy.spider.htmlparser.buss.doctorjob;
import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.buss.doctorjob.helper.ReadDjComDetailHelper;
import com.cnfwsy.spider.htmlparser.queue.doctorjob.DoctorjobComUrlQueue;
import org.apache.log4j.Logger;

/**
 * 说明:
 * Created by zhangjh on 2016-08-03.
 */
public class ReadDjComDetail implements Runnable {

    Logger logger = Logger.getLogger(ReadDjComDetail.class.getName());

    @Override
    public void run() {
        Ent_company cominfo = DoctorjobComUrlQueue.pop();
        if (null == cominfo) {
            return;
        }
        int step = cominfo.getStep();
        String url = cominfo.getCom_url();
        logger.info("公司url:" + url);
        ReadDjComDetailHelper.SINGLETONE.readComUrl(cominfo);
    }


}