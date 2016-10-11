package com.cnfwsy.spider.htmlparser.queue.ecaihr;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 说明:
 * Created by zhangjh on 2016-08-30.
 */
public class EcaihrJobUrlQueue {

    private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

    public static void put(Object t) {
        queue.add(t);
    }

    public static <T> T pop() {
        return (T) queue.poll();
    }


}
