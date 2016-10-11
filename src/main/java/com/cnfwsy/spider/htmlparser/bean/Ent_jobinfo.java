package com.cnfwsy.spider.htmlparser.bean;

import java.math.BigInteger;

/**
 * 实体bean Created by zhangjh on 2016-7-19 15:15:26
 */
public class Ent_jobinfo {
    /**
     *
     */
    /**
     * 职位id
     */
    private BigInteger job_id;
    /**
     * 职位名
     */
    private String job_name;

    private String address;
    /**
     * 公司id
     */
    private BigInteger company_id;
    /**
     * 公司名
     */
    private String company_name;

    /**
     *
     */
    private int province_id;

    /**
     *
     */
    private String province_name;

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
    /**
     * 爬虫阶段使用:第三方检索出来的公司id
     */
    private BigInteger third_id;
    /**
     * 爬虫阶段使用:数据来源51job/liepin/dxy
     */
    private String third_kind;
    /**
     * 0:爬虫阶段；1:注册绑定（注册账号和公司绑定，允许一个公司多个该状态数据,审核时取最新的数据）；2：审核通过（账号绑定+营业执照审核通过）
     */
    private int status;

    /**
     * 爬虫阶段:0,概要阶段(列表)；1，详细阶段
     */
    private int step;

    /**
     * 职称要求
     */
    private String title_requr;

    /**
     * 年龄要求
     */
    private String age_requr;

    /**
     * 专业要求
     */
    private String pro_requr;

    public String getPro_requr() {
        return pro_requr;
    }

    public void setPro_requr(String pro_requr) {
        this.pro_requr = pro_requr;
    }

    public String getTitle_requr() {
        return title_requr;
    }

    public void setTitle_requr(String title_requr) {
        this.title_requr = title_requr;
    }

    public String getAge_requr() {
        return age_requr;
    }

    public void setAge_requr(String age_requr) {
        this.age_requr = age_requr;
    }

    public int getProvince_id() {
        return province_id;
    }

    public void setProvince_id(int province_id) {
        this.province_id = province_id;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    /**
     *
     */
    public String getArea_name() {
        return this.area_name;
    }

    /**
     *
     */
    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    /**
     *
     */
    public String getEnd_date() {
        return this.end_date;
    }

    /**
     *
     */
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    /**
     *
     */
    public BigInteger getThird_id() {
        return this.third_id;
    }

    /**
     *
     */
    public void setThird_id(BigInteger third_id) {
        this.third_id = third_id;
    }

    /**
     *
     */
    public String getJob_welfare() {
        return this.job_welfare;
    }

    /**
     *
     */
    public void setJob_welfare(String job_welfare) {
        this.job_welfare = job_welfare;
    }

    /**
     *
     */
    public String getEducation_id() {
        return this.education_id;
    }

    /**
     *
     */
    public void setEducation_id(String education_id) {
        this.education_id = education_id;
    }

    /**
     *
     */
    public String getJob_nature_name() {
        return this.job_nature_name;
    }

    /**
     *
     */
    public void setJob_nature_name(String job_nature_name) {
        this.job_nature_name = job_nature_name;
    }

    /**
     *
     */
    public int getArea_id() {
        return this.area_id;
    }

    /**
     *
     */
    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    /**
     *
     */
    public int getJob_type_id() {
        return this.job_type_id;
    }

    /**
     *
     */
    public void setJob_type_id(int job_type_id) {
        this.job_type_id = job_type_id;
    }

    /**
     *
     */
    public String getJob_nature_id() {
        return this.job_nature_id;
    }

    /**
     *
     */
    public void setJob_nature_id(String job_nature_id) {
        this.job_nature_id = job_nature_id;
    }

    /**
     *
     */
    public String getExperience_id() {
        return this.experience_id;
    }

    /**
     *
     */
    public void setExperience_id(String experience_id) {
        this.experience_id = experience_id;
    }

    /**
     *
     */
    public String getCity_name() {
        return this.city_name;
    }

    /**
     *
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
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

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEducation_name() {
        return education_name;
    }

    public void setEducation_name(String education_name) {
        this.education_name = education_name;
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

    public String getThird_kind() {
        return third_kind;
    }

    public void setThird_kind(String third_kind) {
        this.third_kind = third_kind;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String primary() {
        return "职位信息 [job_id=" + job_id + ", 职位名称=" + job_name + ", 公司名=" + job_name + ", 城市=" + city_name + ", 区="
                + area_name + ", 发布日期=" + publish_date + ", jobNatureName=" + job_nature_name + ", 薪酬=" + payroll
                + ", status_0=" + status + ", third_id=" + third_id + ", third_kind=" + third_kind + ", jobUrl=" + job_url
                + ", comUrl=" + com_url + "]";
    }

    @Override
    public String toString() {
        return "Ent_jobinfo{" +
                "job_id=" + job_id +
                ", job_name='" + job_name + '\'' +
                ", address='" + address + '\'' +
                ", company_id=" + company_id +
                ", company_name='" + company_name + '\'' +
                ", province_id=" + province_id +
                ", province_name='" + province_name + '\'' +
                ", city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                ", area_id=" + area_id +
                ", area_name='" + area_name + '\'' +
                ", publish_date='" + publish_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", job_nature_id='" + job_nature_id + '\'' +
                ", job_nature_name='" + job_nature_name + '\'' +
                ", job_type_id=" + job_type_id +
                ", job_type_name='" + job_type_name + '\'' +
                ", job_type_sub_id=" + job_type_sub_id +
                ", job_type_sub_name='" + job_type_sub_name + '\'' +
                ", quantity=" + quantity +
                ", education_id='" + education_id + '\'' +
                ", education_name='" + education_name + '\'' +
                ", experience_id='" + experience_id + '\'' +
                ", experience_name='" + experience_name + '\'' +
                ", monthly_pay_id='" + monthly_pay_id + '\'' +
                ", salary_start=" + salary_start +
                ", salary_end=" + salary_end +
                ", job_desc='" + job_desc + '\'' +
                ", job_welfare='" + job_welfare + '\'' +
                ", job_url='" + job_url + '\'' +
                ", com_url='" + com_url + '\'' +
                ", payroll='" + payroll + '\'' +
                ", third_id=" + third_id +
                ", third_kind='" + third_kind + '\'' +
                ", status_0=" + status +
                ", step=" + step +
                ", title_requr='" + title_requr + '\'' +
                ", age_requr='" + age_requr + '\'' +
                ", pro_requr='" + pro_requr + '\'' +
                '}';
    }

    public void setArea(String cityStr) {
        if (cityStr.contains("-")) {
            String[] cityArr = cityStr.split("-");
            String city_name = cityArr[0];
            String area_name = cityArr[1];
            this.setCity_name(city_name.trim());
            this.setArea_name(area_name.trim());
        } else {
            this.setCity_name(cityStr.trim());
        }
    }

    public void setJobType(String val) {
        if (val.contains("/")) {
            String[] jobTypeArr = val.split("/");
            String job_type_name = jobTypeArr[0].trim();
            String job_type_sub_name = jobTypeArr[1].trim();
            this.setJob_type_name(job_type_name);
            this.setJob_type_sub_name(job_type_sub_name);
        } else {
            this.setJob_type_sub_name(val.trim());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ent_jobinfo jobinfo = (Ent_jobinfo) o;

        if (!job_id.toString().equals(jobinfo.job_id.toString())) return false;
        return third_kind.equals(jobinfo.third_kind);

    }

    @Override
    public int hashCode() {
        int result = job_id.toString().hashCode();
        result = 31 * result + third_kind.hashCode();
        return result;
    }
}
