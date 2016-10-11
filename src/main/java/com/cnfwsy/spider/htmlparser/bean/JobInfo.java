package com.cnfwsy.spider.htmlparser.bean;

import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean Created by zhangjh on 2016-7-18 15:07:38
 */
public class JobInfo {
	/**
	*
	*/
	private int id;
	/**
	 * 职位id
	 */
	private BigInteger job_id;
	/**
	 * 职位名
	 */
	private String job_name;
	/**
	 * 公司id
	 */
	private BigInteger company_id;
	/**
	 * 公司名
	 */
	private String company_name;
	/**
	 * 城市id
	 */
	private int city_id;
	/**
	 * 城市id
	 */
	private String city_name;
	/**
	 * 区县id
	 */
	private int area_id;
	/**
	 * 区县名
	 */
	private String area_name;
	/**
	 * 发布日期
	 */
	private String publish_date;
	/**
	 * 发布截止日期：请根据实际需求选择截止时间。如不选择，默认60天后下线
	 */
	private String end_date;
	/**
	 * 职位性质
	 */
	private String job_nature_id;
	/**
	 * 职位性质：全职/兼职/实习
	 */
	private String job_nature_name;
	/**
	 * 职位类别
	 */
	private int job_type_id;
	/**
	 * 职位类别
	 */
	private String job_type_name;
	/**
	 * 职位子类别id
	 */
	private int job_type_sub_id;
	/**
	 * 职位子类别名称
	 */
	private String job_type_sub_name;
	/**
	*
	*/
	private String del_flag;
	/**
	*
	*/
	private Date create_time;
	/**
	*
	*/
	private Date update_time;
	/**
	 * 招聘人数
	 */
	private int quantity;
	/**
	*
	*/
	private String education_id;
	/**
	 * 学历要求
	 */
	private String education_name;
	/**
	*
	*/
	private String experience_id;
	/**
	*
	*/
	private String experience_name;
	/**
	 * 月薪
	 */
	private String monthly_pay_id;
	/**
	 * 最低月薪(元)
	 */
	private int salary_start;
	/**
	 * 最高月薪(元)
	 */
	private int salary_end;
	/**
	 * 职位描述
	 */
	private String job_desc;
	/**
	 * 职位福利，职位标签：多个标签已都好分割
	 */
	private String job_welfare;
	/**
	 * 职位链接
	 */
	private String job_url;
	/**
	 * 公司链接
	 */
	private String com_url;
	/**
	 * 薪资:年薪或月薪直接表示
	 */
	private String payroll;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getJob_id() {
		return job_id;
	}

	public void setJob_id(BigInteger job_id) {
		this.job_id = job_id;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public BigInteger getCompany_id() {
		return company_id;
	}

	public void setCompany_id(BigInteger company_id) {
		this.company_id = company_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public int getArea_id() {
		return area_id;
	}

	public void setArea_id(int area_id) {
		this.area_id = area_id;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getJob_nature_id() {
		return job_nature_id;
	}

	public void setJob_nature_id(String job_nature_id) {
		this.job_nature_id = job_nature_id;
	}

	public String getJob_nature_name() {
		return job_nature_name;
	}

	public void setJob_nature_name(String job_nature_name) {
		this.job_nature_name = job_nature_name;
	}

	public int getJob_type_id() {
		return job_type_id;
	}

	public void setJob_type_id(int job_type_id) {
		this.job_type_id = job_type_id;
	}

	public String getJob_type_name() {
		return job_type_name;
	}

	public void setJob_type_name(String job_type_name) {
		this.job_type_name = job_type_name;
	}

	public int getJob_type_sub_id() {
		return job_type_sub_id;
	}

	public void setJob_type_sub_id(int job_type_sub_id) {
		this.job_type_sub_id = job_type_sub_id;
	}

	public String getJob_type_sub_name() {
		return job_type_sub_name;
	}

	public void setJob_type_sub_name(String job_type_sub_name) {
		this.job_type_sub_name = job_type_sub_name;
	}

	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getEducation_id() {
		return education_id;
	}

	public void setEducation_id(String education_id) {
		this.education_id = education_id;
	}

	public String getEducation_name() {
		return education_name;
	}

	public void setEducation_name(String education_name) {
		this.education_name = education_name;
	}

	public String getExperience_id() {
		return experience_id;
	}

	public void setExperience_id(String experience_id) {
		this.experience_id = experience_id;
	}

	public String getExperience_name() {
		return experience_name;
	}

	public void setExperience_name(String experience_name) {
		this.experience_name = experience_name;
	}

	public String getMonthly_pay_id() {
		return monthly_pay_id;
	}

	public void setMonthly_pay_id(String monthly_pay_id) {
		this.monthly_pay_id = monthly_pay_id;
	}

	public int getSalary_start() {
		return salary_start;
	}

	public void setSalary_start(int salary_start) {
		this.salary_start = salary_start;
	}

	public int getSalary_end() {
		return salary_end;
	}

	public void setSalary_end(int salary_end) {
		this.salary_end = salary_end;
	}

	public String getJob_desc() {
		return job_desc;
	}

	public void setJob_desc(String job_desc) {
		this.job_desc = job_desc;
	}

	public String getJob_welfare() {
		return job_welfare;
	}

	public void setJob_welfare(String job_welfare) {
		this.job_welfare = job_welfare;
	}

	public String getJob_url() {
		return job_url;
	}

	public void setJob_url(String job_url) {
		this.job_url = job_url;
	}

	public String getCom_url() {
		return com_url;
	}

	public void setCom_url(String com_url) {
		this.com_url = com_url;
	}

	public String getPayroll() {
		return payroll;
	}

	public void setPayroll(String payroll) {
		this.payroll = payroll;
	}

	@Override
	public String toString() {
		return "JobInfo [id=" + id + ", job_id=" + job_id + ", job_name=" + job_name + ", company_id=" + company_id
				+ ", company_name=" + company_name + ", city_id=" + city_id + ", city_name=" + city_name + ", area_id="
				+ area_id + ", area_name=" + area_name + ", publish_date=" + publish_date + ", end_date=" + end_date
				+ ", job_nature_id=" + job_nature_id + ", job_nature_name=" + job_nature_name + ", job_type_id="
				+ job_type_id + ", job_type_name=" + job_type_name + ", job_type_sub_id=" + job_type_sub_id
				+ ", job_type_sub_name=" + job_type_sub_name + ", del_flag=" + del_flag + ", create_time=" + create_time
				+ ", update_time=" + update_time + ", quantity=" + quantity + ", education_id=" + education_id
				+ ", education_name=" + education_name + ", experience_id=" + experience_id + ", experience_name="
				+ experience_name + ", monthly_pay_id=" + monthly_pay_id + ", salary_start=" + salary_start
				+ ", salary_end=" + salary_end + ", job_desc=" + job_desc + ", job_welfare=" + job_welfare
				+ ", job_url=" + job_url + ", com_url=" + com_url + ", payroll=" + payroll + "]";
	}

	public String primary() {
		return "JobInfo [id=" + id + ", job_id=" + job_id + ", 职位名称=" + job_name + ", 公司名=" + job_name + ", 城市="
				+ city_name + ", 区=" + area_name + ", 发布日期=" + publish_date + ", jobNatureName=" + job_nature_name
				+ ", 薪酬=" + payroll + "]" + ", jobUrl=" + job_url + ", comUrl=" + com_url;
	}

}
