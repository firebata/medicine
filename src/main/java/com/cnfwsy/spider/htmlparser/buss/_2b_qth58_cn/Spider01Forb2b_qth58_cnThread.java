package com.cnfwsy.spider.htmlparser.buss._2b_qth58_cn;

import com.cnfwsy.spider.htmlparser.bean.Company;
import com.cnfwsy.spider.htmlparser.bean.Companyfail;
import com.cnfwsy.spider.htmlparser.queue.DataSaveQueue;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Spider01Forb2b_qth58_cnThread implements Runnable {
	static String http = "http://";
	static String suffix = ".b2b.qth58.cn";
	private int noStart, noEnd;

	public Spider01Forb2b_qth58_cnThread(int noStart, int noEnd) {
		this.noEnd = noEnd;
		this.noStart = noStart;
	}

	public void parese(int noStart, int noEnd) {
		for (int no = noStart; no < noEnd; no++) {
			System.out.println("===========================分割线===========================no=" + no);
			parse(no);
		}

	}

	public void parse(int companyNo) {
		String company_no = String.valueOf(companyNo);
		try {
			String url = http + companyNo + suffix;
			// System.out.println("爬虫程序开始，当前网址==>" + url);
			Document doc = Jsoup.connect(url).get();
			Element det_info = doc.getElementById("det_info");
			Elements contactWay = doc.getElementsByClass("contact-way");
			Company company = null;
			if (det_info != null) {
				company = model1(doc, det_info);
			} else if (contactWay != null) {
				company = model2(doc, contactWay);
			}
			if (null != company) {
				company.setCompany_no(company_no);
				// CompanyQueue<Company> queue = new CompanyQueue<Company>();
				// queue.put(company);
				DataSaveQueue.put(company);
			}
			// DbUtils.insert(company);
			doc.remove();
			doc=null;

		} catch (Exception e) {
			System.err.println("异常情况,no=" + companyNo);
			Companyfail company = new Companyfail();
			company.setCompany_no(company_no);
			// DbUtils.insert(company);
			// CompanyQueue<Companyfail> queue = new
			// CompanyQueue<Companyfail>();
			// queue.put(company);
			DataSaveQueue.put(company);
		}

		// System.out.println("爬虫程序结束，当前网址==>" + url);
	}

	private Company model2(Document doc, Elements contactWay) {
		Company company = new Company();
		for (Element contact : contactWay) {
			Elements names = contact.getElementsByTag("strong");
			for (Element name : names) {
				String company_name = name.text();
				System.out.println("公司名：" + company_name);
				company.setCompany_name(company_name);
				break;
			}

			Elements strongs = contact.getElementsByTag("small");
			int index = 0;
			for (Element strong : strongs) {
				String text = strong.text();
				text = text.substring(text.indexOf("：") + 1);
				if (index == 0) {
					// System.out.println("联系人：" + text);
					company.setContact_name(text);
				} else if (index == 1) {
					// System.out.println("电话：" + text);
					company.setTel(text);
				} else if (index == 2) {
					// System.out.println("手机：" + text);
					company.setMobile(text);
				} else if (index == 3) {
					// System.out.println("传真：" + text);
					company.setFax(text);
				} else if (index == 4) {
					// System.out.println("地址：" + text);
					company.setAddress(text);
				} else if (index == 5) {
					// System.out.println("邮编：" + text);
					company.setZip_code(text);
				} else if (index == 6) {
					// System.out.println("网站：" + text);
					company.setWebsite(text);
				}
				index++;
			}
		}
		return company;
	}

	/**
	 * 
	 * @param doc
	 * @param det_info
	 */
	private Company model1(Document doc, Element det_info) {
		Company company = new Company();
		// 公司信息
		Elements commpanyNameE = det_info.getElementsByClass("blue-link");
		for (Element name : commpanyNameE) {
			String company_name = name.text();
			System.out.println("公司名：" + company_name);
			company.setCompany_name(company_name);
			break;
		}
		Elements dds = det_info.getElementsByTag("dd");
		int index = 0;
		for (Element dd : dds) {
			String text = dd.text();
			if (index == 0) {
				// System.out.println("公司地址：" + text);
				company.setAddress(text);
			} else if (index == 1) {
				// System.out.println("注册资本：" + text);
				company.setRegisteredc_apital(text);
			} else if (index == 2) {
				// System.out.println("企业类型：" + text);
				company.setType(text);
			}
			index++;
		}
		// 联系人信息
		Element contact = doc.getElementById("contact");
		if (contact != null) {
			Elements dds2 = contact.getElementsByTag("dd");
			int index2 = 0;
			for (Element dd2 : dds2) {
				String text = dd2.text();
				if (index2 == 0) {
					// System.out.println("联系人：" + text);
					company.setContact_name(text);
				} else if (index2 == 1) {
					// System.out.println("座机：" + text);
					company.setTel(text);
				} else if (index2 == 2) {
					// System.out.println("手机：" + text);
					company.setMobile(text);
				} else if (index2 == 3) {
					// System.out.println("传真：" + text);
					company.setFax(text);
				} else if (index2 == 4) {
					// System.out.println("客服：" + text);
					company.setCustomer(text);
				}
				index2++;
			}
		}
		return company;
	}

	@Override
	public void run() {
		parese(noStart, noEnd);

	}
}
