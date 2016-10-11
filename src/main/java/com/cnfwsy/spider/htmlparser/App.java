package com.cnfwsy.spider.htmlparser;

import com.cnfwsy.spider.core.bean.Third;
import com.cnfwsy.spider.core.util.ThirdUtils;
import com.cnfwsy.spider.htmlparser.buss._51job.*;
import com.cnfwsy.spider.htmlparser.buss.doctorjob.ReadDjJob2OfMedical;
import com.cnfwsy.spider.htmlparser.buss.dxy.*;
import com.cnfwsy.spider.htmlparser.buss.ecaihr.ReadEcaihrComDetail;
import com.cnfwsy.spider.htmlparser.buss.ecaihr.ReadEcaihrJobDetail;
import com.cnfwsy.spider.htmlparser.thread.DataSaveThread;
import com.cnfwsy.spider.htmlparser.thread.QueryComapanyUrlThread;
import com.cnfwsy.spider.htmlparser.thread.QueryJobUrlThread;
import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
	// static ThreadPoolExecutor cachedThreadPool = new ThreadPoolExecutor(11,
	// 30, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(20), 0,
	// 100, TimeUnit.MILLISECONDS);
	static ScheduledExecutorService cachedThreadPool = Executors.newScheduledThreadPool(10);
	static ScheduledExecutorService cachedThreadPool2 = Executors.newScheduledThreadPool(10);
	static ScheduledExecutorService cachedThreadPool3 = Executors.newScheduledThreadPool(10);

	static {
		InputStream in = App.class.getClassLoader().getResourceAsStream("spider/third.properties");
		Properties prop = new Properties();
		try {
			prop.load(in);
			String websites = prop.getProperty("websites");
			Third third = ThirdUtils.third;
			third.setWebsites(websites);
			List<String> list = Arrays.asList(websites.split(","));
			third.setWebsiteList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static {
		// BasicConfigurator.configure();
		InputStream in2 = App.class.getClassLoader().getResourceAsStream("conf/props/log4j.properties");
		PropertyConfigurator.configure(in2);
	}

	/**
	 * 分布执行: 1,职位列表 2,其他
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// //第一步
		startJobSpider();
		//
		// //第二步
		startSave();

		// //第三步
		startQueryUrl();
		//
		// //第四步
		startReadDtail();
		//
		// //第五步
		startUpdate();
	}

	private static void startJobSpider() {
		if (ThirdUtils.isNeed("51job")) {
			start51job();
		}
		if (ThirdUtils.isNeed("doctorjob")) {
			startdxyjob();
		}
		if (ThirdUtils.isNeed("dxy")) {
			startDoctorjobjob();
		}
		if (ThirdUtils.isNeed("zhaopin")) {

		}
		if (ThirdUtils.isNeed("liepin")) {

		}
		if (ThirdUtils.isNeed("ecaihr")) {
			startecaihr();
		}

	}

	// 170000-240000
	private static void startDoctorjobjob() {

		cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(460000, 462000), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(462000, 464000), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(464000, 466000), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(466000, 468000), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(468000, 470000), 0, 100, TimeUnit.MILLISECONDS);
		// cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(462000,
		// 464000), 0, 100, TimeUnit.MILLISECONDS);

		// cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(480000,
		// 500000), 0, 100, TimeUnit.MILLISECONDS);
		// cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(500000,
		// 520000), 0, 100, TimeUnit.MILLISECONDS);
		// cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(520000,
		// 540000), 0, 100, TimeUnit.MILLISECONDS);
		// cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(540000,
		// 560000), 0, 100, TimeUnit.MILLISECONDS);
		// cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(560000,
		// 580000), 0, 100, TimeUnit.MILLISECONDS);
		// cachedThreadPool.scheduleAtFixedRate(new ReadDjJob2OfMedical(580000,
		// 600000), 0, 100, TimeUnit.MILLISECONDS);

	}

	//
	private static void startSave() {
		cachedThreadPool2.scheduleAtFixedRate(new DataSaveThread(), 0, 100, TimeUnit.MILLISECONDS);
	}

	private static void startQueryUrl() {
		cachedThreadPool3.scheduleAtFixedRate(new QueryComapanyUrlThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool3.scheduleAtFixedRate(new QueryJobUrlThread(), 0, 100, TimeUnit.MILLISECONDS);
	}

	private static void startdxyjob() {
		DxyInvoke.invoke();
	}

	private static void startUpdate() {
		if (ThirdUtils.isNeed("51job")) {
			start51jobUpdate();

		}
		if (ThirdUtils.isNeed("doctorjob")) {

		}
		if (ThirdUtils.isNeed("dxy")) {
			startDxyjobUpdate();

		}
		if (ThirdUtils.isNeed("zhaopin")) {

		}
		if (ThirdUtils.isNeed("liepin")) {

		}
		if (ThirdUtils.isNeed("ecaihr")) {
			startEcaihrUpdate();
		}
	}

	private static void startEcaihrUpdate() {
		cachedThreadPool.scheduleAtFixedRate(new ReadEcaihrJobDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadEcaihrJobDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadEcaihrJobDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadEcaihrJobDetail(), 0, 100, TimeUnit.MILLISECONDS);
	}

	private static void startDxyjobUpdate() {
		cachedThreadPool.scheduleAtFixedRate(new DxyJobUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new DxyJobUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new DxyJobUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new DxyComUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new DxyComUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new DxyComUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
	}

	private static void start51jobUpdate() {
		cachedThreadPool.scheduleAtFixedRate(new _51jobJobUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new _51jobJobUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new _51jobJobUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new _51jobComUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new _51jobComUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new _51jobComUpdateThread(), 0, 100, TimeUnit.MILLISECONDS);
	}

	private static void startReadDtail() {
		if (ThirdUtils.isNeed("51job")) {
			startRead51JobDtail();
		}
		if (ThirdUtils.isNeed("doctorjob")) {

		}
		if (ThirdUtils.isNeed("dxy")) {
			startReadDxyJobDtail();
		}
		if (ThirdUtils.isNeed("zhaopin")) {

		}
		if (ThirdUtils.isNeed("liepin")) {

		}
	}

	private static void startReadDxyJobDtail() {

		cachedThreadPool.scheduleAtFixedRate(new ReadDxyJobDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadDxyJobDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadDxyJobDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadDxyComDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadDxyComDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadDxyComDetail(), 0, 100, TimeUnit.MILLISECONDS);

	}

	private static void startRead51JobDtail() {
		cachedThreadPool.scheduleAtFixedRate(new Read51JobDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new Read51JobDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new Read51JobDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new Read51ComDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new Read51ComDetail(), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new Read51ComDetail(), 0, 100, TimeUnit.MILLISECONDS);
	}

	private static void start51job() {
		startReadJoblist(1, 487);
	}

	private static void startReadJoblist(int noStart, int noEnd) {
		cachedThreadPool.scheduleAtFixedRate(new Read51JobOfMedical(noStart, noEnd), 0, 100, TimeUnit.MILLISECONDS);
	}

	private static void startecaihr() {

		cachedThreadPool.scheduleAtFixedRate(new ReadEcaihrComDetail(80000, 82000), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadEcaihrComDetail(82000, 84000), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadEcaihrComDetail(84000, 86000), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadEcaihrComDetail(86000, 88000), 0, 100, TimeUnit.MILLISECONDS);
		cachedThreadPool.scheduleAtFixedRate(new ReadEcaihrComDetail(88000, 90000), 0, 100, TimeUnit.MILLISECONDS);

	}

}
