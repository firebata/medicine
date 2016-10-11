package com.cnfwsy.spider.htmlparser.buss._51job;

import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.buss._51job.helper.Read51CompanyHelper;
import com.cnfwsy.spider.htmlparser.queue._51job._51jobComUrlQueue;
import org.apache.log4j.Logger;

/**
 * 读取公司信息
 *
 * @author zhangjh
 */
public class Read51ComDetail implements Runnable {

    Logger logger = Logger.getLogger(Read51ComDetail.class.getName());

    @Override
    public void run() {
        Ent_company cominfo = _51jobComUrlQueue.pop();
        if (null == cominfo) {
            return;
        }
        int step = cominfo.getStep();
        String url = cominfo.getCom_url();
        logger.info("公司url:" + url);
        Read51CompanyHelper.SINGLETONE.readComUrl(cominfo, step, url);
    }


}
