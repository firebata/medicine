package com.cnfwsy.spider.htmlparser.queue;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 
 * @author zhangjh
 *
 */
public class DataSaveQueue {
	Logger logger = Logger.getLogger(DataSaveQueue.class.getName());
	private static ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();

	public static void put(Object t) {
		queue.add(t);
	}

	public static void put(List<?> t) {
		for (Object obj : t) {
			queue.add(obj);
		}
	}

	public static void put(Set<?> t) {
		for (Object obj : t) {
			queue.add(obj);
		}
	}

	public static <T> T pop() {
		return (T) queue.poll();
	}
}
