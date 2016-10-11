package com.cnfwsy.spider.htmlparser.buss._51job;

import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.buss._51job.helper.Read51JobHelper;
import com.cnfwsy.spider.htmlparser.queue._51job._51jobJobUrlQueue;
import org.apache.log4j.Logger;

/**
 * 读取职位详细信息
 *
 * @author zhangjh
 */
public class Read51JobDetail implements Runnable {
    Logger logger = Logger.getLogger(Read51JobDetail.class.getName());

    @Override
    public void run() {

        Ent_jobinfo jobinfo = _51jobJobUrlQueue.pop();
        if (null == jobinfo) {
            return;
        }
        int step = jobinfo.getStep();
        String url = jobinfo.getJob_url();
        logger.info("职位url:" + url);
        Read51JobHelper.SINGLETONE.readJobUrl(jobinfo, step, url);

    }

}
