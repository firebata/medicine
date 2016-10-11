package com.cnfwsy.spider.htmlparser.queue.doctorjob;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 51job公司队列
 * @author zhangjh
 *
 */
public class DoctorjobJobUrlQueue {

	private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

	public static void put(Object t) {
		queue.add(t);
	}

	public static <T> T pop() {
		return (T) queue.poll();
	}
}
