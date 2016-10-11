package com.cnfwsy.serialnumber.generator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by zhangjh on 16/6/13.
 */
public abstract class AbstractNoGenerator implements INoGenerator {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    protected void doWhile(ArrayBlockingQueue<String> queue, int codeLength) {
        try {
            String newNo = nextNo(codeLength);
            queue.put(newNo);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
    }


}
