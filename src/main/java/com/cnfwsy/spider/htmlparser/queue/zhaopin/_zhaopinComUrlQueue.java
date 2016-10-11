package com.cnfwsy.spider.htmlparser.queue.zhaopin;

import java.util.concurrent.ConcurrentLinkedQueue;

public class _zhaopinComUrlQueue {

	private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

	public static void put(Object t) {
		queue.add(t);
	}

	public static <T> T pop() {
		return (T) queue.poll();
	}
}
