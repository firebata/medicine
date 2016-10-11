package com.cnfwsy.spider.htmlparser.queue.liepin;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * @author zhangjh
 *
 */
public class LiepinJobUrlQueue {

	private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

	public static void put(Object t) {
		queue.add(t);
	}

	public static <T> T pop() {
		return (T) queue.poll();
	}
}
