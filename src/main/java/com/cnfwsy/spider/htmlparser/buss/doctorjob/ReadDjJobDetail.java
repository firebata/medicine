package com.cnfwsy.spider.htmlparser.buss.doctorjob;

import com.cnfwsy.spider.htmlparser.buss.doctorjob.helper.ReadDjJobHelper;
import com.cnfwsy.spider.htmlparser.queue._51job._51jobJobUrlQueue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * 说明:
 * Created by zhangjh on 2016-08-04.
 */
public class ReadDjJobDetail implements Runnable {
    Logger logger = Logger.getLogger(ReadDjJobDetail.class.getName());

    @Override
    public void run() {

        String jobUrl = _51jobJobUrlQueue.pop();
        if (StringUtils.isBlank(jobUrl)) {
            return;
        }
        logger.info("解析职位url:" + jobUrl);
        ReadDjJobHelper.SINGLETONE.readurl(jobUrl);

    }

}
