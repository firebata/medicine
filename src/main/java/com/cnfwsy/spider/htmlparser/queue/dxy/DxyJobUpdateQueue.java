package com.cnfwsy.spider.htmlparser.queue.dxy;

import org.apache.log4j.Logger;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 数据更新队列
 * 
 * @author zhangjh
 *
 */
public class DxyJobUpdateQueue {
	Logger logger = Logger.getLogger(DxyJobUpdateQueue.class.getName());
	private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

	public static void put(Object t) {
		queue.add(t);
	}

	public static <T> T pop() {
		return (T) queue.poll();
	}
}
