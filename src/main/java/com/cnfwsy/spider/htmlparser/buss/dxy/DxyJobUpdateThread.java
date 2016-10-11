package com.cnfwsy.spider.htmlparser.buss.dxy;

import com.cnfwsy.spider.core.util.DbUtils;
import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.queue.dxy.DxyJobUpdateQueue;
import org.apache.log4j.Logger;

public class DxyJobUpdateThread implements Runnable {
	Logger logger = Logger.getLogger(DxyJobUpdateThread.class.getName());

	@Override
	public void run() {
		while (true) {
			Ent_jobinfo job = DxyJobUpdateQueue.pop();
			if (job != null) {
				DbUtils.updateJob(job);
			}

		}
	}

}
