package com.cnfwsy.serialnumber.generator.impl;

import com.cnfwsy.serialnumber.generator.AbstractNoGenerator;
import com.cnfwsy.serialnumber.generator.INoGenerator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 说明:
 * Created by zhangjh on 2016-06-14.
 */
@Component
public class CompanyProductNoGenerator extends AbstractNoGenerator implements INoGenerator {
    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue(50, true);


    @Override
    public String nextNo(int len) {
        double random = (Math.random() * (len + 1) + 1) * Math.pow(10, len);
        long result = new Double(random).longValue();
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
