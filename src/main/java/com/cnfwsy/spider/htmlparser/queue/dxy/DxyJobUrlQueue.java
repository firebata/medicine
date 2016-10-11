package com.cnfwsy.spider.htmlparser.queue.dxy;

import java.util.concurrent.ConcurrentLinkedQueue;

public class DxyJobUrlQueue {

	private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

	public static void put(Object t) {
		queue.add(t);
	}

	public static <T> T pop() {
		return (T) queue.poll();
	}
}
