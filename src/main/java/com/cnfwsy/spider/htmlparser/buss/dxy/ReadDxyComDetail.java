package com.cnfwsy.spider.htmlparser.buss.dxy;

import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.buss.dxy.helper.ReadDxyCompanyHelper;
import com.cnfwsy.spider.htmlparser.queue.dxy.DxyComUrlQueue;
import org.apache.log4j.Logger;

/**
 * 读取公司信息
 *
 * @author zhangjh
 */
public class ReadDxyComDetail implements Runnable {

    Logger logger = Logger.getLogger(ReadDxyComDetail.class.getName());

    @Override
    public void run() {
        while (true) {
            Ent_company cominfo = DxyComUrlQueue.pop();
            if (null == cominfo) {
                continue;
            }
            ReadDxyCompanyHelper.SINGLETONE.readComUrl(cominfo);
        }
    }


}
