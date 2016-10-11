package com.cnfwsy.serialnumber.generator.impl;

import com.cnfwsy.core.utils.DateUtils;
import com.cnfwsy.serialnumber.generator.AbstractNoGenerator;
import com.cnfwsy.serialnumber.generator.INoGenerator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 说明:
 * Created by zhangjh on 2016-08-02.
 */
@Component
public class EntJobNoGenerator extends AbstractNoGenerator implements INoGenerator {

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(20, true);

    public String nextNo(int len) {
        String time = DateUtils.SINGLETONE.getYYMMDD();
        double random = (Math.random() * (len + 1) + 1) * Math.pow(10, len);
        time = time + "" + random;
        long result = new Double(time).longValue();
        String nextNo = String.valueOf(result);
        return nextNo;
    }

    @Override
    public String offer() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }


    @Override
    @Scheduled(cron = "* * *  * * ? ")
    public void run() {
        int codeLength = 8;
        doWhile(queue, codeLength);
    }
}