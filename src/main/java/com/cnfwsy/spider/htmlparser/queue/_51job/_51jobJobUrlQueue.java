package com.cnfwsy.spider.htmlparser.queue._51job;

import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * 51job公司队列
 * @author zhangjh
 *
 */
public class _51jobJobUrlQueue {

	private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

	public static void put(Object t) {
		queue.add(t);
	}

	public static <T> T pop() {
		return (T) queue.poll();
	}
}
