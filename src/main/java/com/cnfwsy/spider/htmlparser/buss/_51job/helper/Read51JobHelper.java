package com.cnfwsy.spider.htmlparser.buss._51job.helper;

import com.cnfwsy.spider.htmlparser.bean.Ent_company;
import com.cnfwsy.spider.htmlparser.bean.Ent_jobinfo;
import com.cnfwsy.spider.htmlparser.constant.AppConstant;
import com.cnfwsy.spider.htmlparser.queue.DataSaveQueue;
import com.cnfwsy.spider.htmlparser.queue._51job._51jobJobUpdateQueue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum Read51JobHelper {

    SINGLETONE;
    Logger logger = Logger.getLogger(Read51JobHelper.class.getName());

    /**
     * 读取职位列表：职位查询列表和公司详细页面中的职位列表
     *
     * @param jobs
     * @param pageNo
     * @param url    职位详细
     * @param coName
     * @return
     */
    public List<Ent_jobinfo> model(Elements jobs, int pageNo, String url, String coName) {
        LocalDate today = LocalDate.now();
        String now = today.toString();
        String mmdd = today.toString().substring(5);
        List<Ent_jobinfo> ent_jobinfos = new ArrayList<Ent_jobinfo>();
        Set<Ent_company> ent_companies = new HashSet<Ent_company>();
        int jobindex = 0;
        for (Element job : jobs) {
            if (jobindex++ == 0) {// 过滤表头
                continue;
            }
            Ent_jobinfo ent_jobinfo = new Ent_jobinfo();
            Ent_company ent_company = new Ent_company();
            // 发布日期
            String publishDate = job.select(".t5").text();
            if (!mmdd.equals(publishDate)) {
                break;
            }
            ent_jobinfo.setPublish_date(now.toString());

            // 地点
            String cityStr = job.select(".t3").text();
            ent_jobinfo.setArea(cityStr);

            // 薪资
            String payroll = job.select(".t4").text();
            if (StringUtils.isNotBlank(payroll)) {
                // 月薪id
                String monthly_pay_id;
                // 最低月薪(元)
                int salary_start = 0;
                // 最高月薪(元)
                int salary_end = 0;
                if (payroll.endsWith("及以上/月")) {// 3000+ /月
                    int jiahao = payroll.lastIndexOf("及");
                    salary_start = Integer.parseInt(payroll.substring(0, jiahao));
                    // salary_end = salary_start+1000;
                } else if (payroll.endsWith("以下/月")) {// 3000+ /月
                    int jiahao = payroll.lastIndexOf("以");
                    salary_start = 0;
                    salary_end = Integer.parseInt(payroll.substring(0, jiahao));
                } else if (payroll.endsWith("+ /月")) {// 3000+ /月
                    int jiahao = payroll.lastIndexOf("+");
                    salary_start = Integer.parseInt(payroll.substring(0, jiahao));
                    salary_end = salary_end + 5000;
                } else if (payroll.endsWith("/月")) {// 6000-9000/月或者9000/月
                    int lastBackSlash = payroll.lastIndexOf("/");
                    GetSalary getSalary = new GetSalary(payroll, salary_end, lastBackSlash).invoke();
                    salary_start = getSalary.getSalary_start();
                    salary_end = getSalary.getSalary_end();
                } else if (payroll.endsWith("万/年")) {// 10-15万/年
                    int lastBackSlash = payroll.lastIndexOf("万");
                    GetSalary getSalary = new GetSalary(payroll, salary_end, lastBackSlash).invoke();
                    salary_start = getSalary.getSalary_start();
                    salary_end = getSalary.getSalary_end();
                    salary_start = salary_start * 1000;// (100 =*1000/10)
                    salary_end = salary_end * 1000;// (100 =*1000/10)
                } else if (payroll.endsWith("+ /年")) {// 70000-120000/年
                    int lastBackSlash = payroll.lastIndexOf("+");
                    GetSalary getSalary = new GetSalary(payroll, salary_end, lastBackSlash).invoke();
                    salary_start = getSalary.getSalary_start();
                    salary_end = getSalary.getSalary_end();
                    salary_start = salary_start / 10;// (100 =*1000/10)
                    salary_end = salary_end / 10;// (100 =*1000/10)
                } else if (payroll.endsWith("+ ")) {// 70000-120000/年
                    int lastBackSlash = payroll.lastIndexOf("+");
                    GetSalary getSalary = new GetSalary(payroll, salary_end, lastBackSlash).invoke();
                    salary_start = getSalary.getSalary_start();
                    salary_end = getSalary.getSalary_end();
                } else if (payroll.endsWith("/年")) {// 70000-120000/年
                    int lastBackSlash = payroll.lastIndexOf("/");
                    GetSalary getSalary = new GetSalary(payroll, salary_end, lastBackSlash).invoke();
                    salary_start = getSalary.getSalary_start();
                    salary_end = getSalary.getSalary_end();
                    salary_start = salary_start / 10;// (100 =*1000/10)
                    salary_end = salary_end / 10;// (100 =*1000/10)
                }

                ent_jobinfo.setSalary_start(salary_start);
                ent_jobinfo.setSalary_end(salary_end);
            }

            ent_jobinfo.setPayroll(payroll);

            Elements as = job.getElementsByTag("a");
            int aindex = 0;
            for (Element a : as) {
                if (aindex == 0) {
                    String jobName = a.text();
                    String jobUrl = a.attr("href");
                    // http://jobs.51job.com/guangzhou/79605982.html?s=0
                    // 或者http://astrazeneca.51job.com/sc/show_job_detail.php?jobid=66909412
                    BigInteger jobId = null;
                    if (jobUrl.contains("jobid")) {
                        // jobId = new
                        // BigInteger(jobUrl.substring(jobUrl.lastIndexOf("=") +
                        // 1));
                    } else {
                        int lastBackSlash = jobUrl.lastIndexOf("/");
                        int lashDecimal = jobUrl.lastIndexOf(".");
                        try {
                            jobId = new BigInteger(jobUrl.substring(lastBackSlash + 1, lashDecimal));
                            if (null != jobId) {
                                jobId = jobId.add(AppConstant.Addend);
                            }
                        } catch (Exception e) {
                            logger.error(e.getMessage(), e);
                        }

                    }

                    ent_jobinfo.setJob_name(jobName);
                    ent_jobinfo.setJob_url(jobUrl);
                    ent_jobinfo.setJob_id(jobId);
                    ent_jobinfo.setThird_id(jobId);
                    ent_jobinfo.setThird_kind(AppConstant._51job);
                    ent_jobinfo.setStatus(AppConstant.status_0);
                    ent_jobinfo.setStep(AppConstant.step_0);

                } else if (aindex == 1) {
                    String companyName = a.text();
                    String comUrl = a.attr("href");
                    BigInteger companyId;
                    companyId = getComId(comUrl);
                    if (companyId == null || null == companyName || comUrl == null) {
                        logger.error("在职位列表未能抓取公司信息:" + comUrl);
                    }

                    ent_jobinfo.setCompany_id(companyId);
                    ent_jobinfo.setCompany_name(companyName);
                    ent_jobinfo.setCom_url(comUrl);
                    ent_company.setCompany_id(companyId);
                    ent_company.setCompany_name(companyName);
                    ent_company.setCom_url(comUrl);
                    ent_company.setThird_id(companyId);
                    ent_company.setThird_kind(AppConstant._51job);
                    ent_company.setStatus(AppConstant.status_0);
                    ent_company.setStep(AppConstant.step_0);
//                    logger.error("ent_jobinfo:" + ent_jobinfo);
                } else {
                    break;
                }
                aindex++;
            }
            String comUrl = ent_jobinfo.getCom_url();

            if (StringUtils.isBlank(comUrl)) {// 公司列表中的职位信息中没有公司链接：直接用url，在前面有赋值(读取公司详细过程的末尾处)
//                logger.info("当前页面 url:" + pageNo);
//                logger.info("职位 url:" + url);
//                logger.info("第" + jobindex + "行数据");
                comUrl = url;
                BigInteger companyId = null;
                companyId = getComId(comUrl);
                ent_jobinfo.setCompany_id(companyId);
                ent_jobinfo.setCompany_name(coName);
                ent_jobinfo.setStep(AppConstant.step_0);
            } else {
                ent_companies.add(ent_company);
            }
            ent_jobinfo.setCom_url(comUrl);
            ent_jobinfos.add(ent_jobinfo);
        }

        DataSaveQueue.put(ent_jobinfos);
        DataSaveQueue.put(ent_companies);
        return ent_jobinfos;
    }

    private BigInteger getComId(String comUrl) {
        BigInteger companyId = null;
        if (comUrl.contains("=")) {
            int lastBackSlash = comUrl.lastIndexOf("=");
            // companyId = new
            // BigInteger(comUrl.substring(lastBackSlash + 1));
        } else {
            int lastBackSlash = comUrl.lastIndexOf("/");
            int lashDecimal = comUrl.lastIndexOf(".");
            companyId = new BigInteger(comUrl.substring(lastBackSlash + 3, lashDecimal));
            if (null != companyId) {
                companyId = companyId.add(AppConstant.Addend);
            }
        }
        return companyId;
    }

    public void readJobUrl(Ent_jobinfo jobinfo, int step, String url) {

        if (step == AppConstant.step_1) {// 职位概述阶段才解析职位详细信息，避免重复解析
            jobinfo.setThird_kind(AppConstant._51job);
            BigInteger jobId = jobinfo.getJob_id();
            BigInteger companyId = jobinfo.getCompany_id();
            try {

                Document doc = Jsoup.connect(url).get();
                Elements jobs = doc.select("div .tCompany_center .tHeader .in .cn .lname");
                String cityStr = jobs.get(0).text();
                jobinfo.setArea(cityStr);
                Elements sp4s = doc.select("div .tCompany_center .tCompany_main .tBorderTop_box .sp4");

                for (Element element : sp4s) {
                    List<Node> aEs = element.childNodes();
                    int index = 1;
                    String className = "";
                    String txt = "";
                    for (Node node : aEs) {
                        if (index == 1) {
                            className = node.attr("class");
                        } else {
                            txt = node.toString();
                        }
                        index++;
                    }
                    String idxStr = className.substring(1);
                    int idx = Integer.parseInt(idxStr);
                    if (idx == 1) {
                        jobinfo.setExperience_name(txt);
                    } else if (idx == 2) {
                        jobinfo.setEducation_name(txt);
                    } else if (idx == 3) {
                        String quantityS = txt.substring(txt.indexOf("聘") + 1, txt.indexOf("人"));
                        int quantity = 0;
                        if (StringUtils.isNumeric(quantityS)) {
                            jobinfo.setQuantity(quantity);
                        }
                    }
                    idx++;
                }

                Elements jobWelfares = doc.select("div .tCompany_center .tCompany_main .tBorderTop_box .t2 span");
                if (null != jobWelfares) {
                    StringBuilder jobSbf = new StringBuilder();
                    for (Element jobWelfare : jobWelfares) {
                        jobSbf.append(jobWelfare.text());
                        jobSbf.append(",");
                    }
                    jobinfo.setJob_welfare(jobSbf.toString());
                }

                Elements job_msgs = doc.select("div .tCompany_center .tCompany_main .tBorderTop_box .job_msg");
                if (null != job_msgs && job_msgs.size() > 0) {
                    for (Element elementSub : job_msgs) {
                        String html = elementSub.html();
                        int end = html.indexOf("<div class=\"mt10\">");
                        String job_desc = html.substring(0, end);
                        jobinfo.setJob_desc(job_desc);
                        break;
                    }
                }
                // 上班地址
                Elements address_msgs = doc
                        .select("div .tCompany_center .tCompany_main .tBorderTop_box .bmsg.inbox p.fp");
                if (null != address_msgs && address_msgs.size() > 0) {
                    for (Element elementSub : address_msgs) {

                        String txt = elementSub.text();

                        if (StringUtils.isNotBlank(txt)) {
                            String val = txt.substring(txt.indexOf("：") + 1);
                            if (txt.contains("上班地址")) {
                                jobinfo.setAddress(val);
                            } else if (txt.contains("职能类别")) {
                                jobinfo.setJobType(val);
                            }
                        }

                    }
                }
                String jobUrl = jobinfo.getJob_url();
                if (!jobUrl.contains("jobid")) {//// 非官网职位地址时，改为系统地址
                    jobUrl = "/entJobDetail/" + jobId;
                    jobinfo.setJob_url(jobUrl);
                }
                String comUrl = jobinfo.getCom_url();
                if (!comUrl.contains("/co")) {// 非官网公司地址时，改为系统地址
                    comUrl = "/entCompanyDetail/" + companyId;
                    jobinfo.setCom_url(comUrl);
                }

                jobinfo.setStep(AppConstant.step_2);

                _51jobJobUpdateQueue.put(jobinfo);

            } catch (Exception e) {
                logger.error("解析职位异常，当前职位url：" + url, e);
            }
        }
    }

    private class GetSalary {
        private String payroll;
        private int salary_end;
        private int lastBackSlash;
        private int salary_start;

        public GetSalary(String payroll, int salary_end, int lastBackSlash) {
            this.payroll = payroll;
            this.salary_end = salary_end;
            this.lastBackSlash = lastBackSlash;
        }

        public int getSalary_start() {
            return salary_start;
        }

        public int getSalary_end() {
            return salary_end;
        }

        public GetSalary invoke() {
            if (payroll.contains("-")) {
                int hengxian = payroll.lastIndexOf("-");
                salary_start = Integer.parseInt(payroll.substring(0, hengxian));
                salary_end = Integer.parseInt(payroll.substring(hengxian + 1, lastBackSlash));
            } else {
                salary_start = Integer.parseInt(payroll.substring(0, lastBackSlash));
            }
            return this;
        }
    }
}
