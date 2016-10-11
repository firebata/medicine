package com.cnfwsy.spider.htmlparser.bean;

import java.math.BigInteger;

/**
 * 实体bean Created by zhangjh on 2016-7-19 15:15:26
 */
public class Ent_company {
    /**
     *
     */
    private BigInteger company_id;
    /**
     * 公司名
     */
    private String company_name;

    /**
     * 行业id
     */
    private String industry_id;

    /**
     * 行业名称
     */
    private String industry_name;

    private String industry_name2;

    public String getIndustry_name2() {
        return industry_name2;
    }

    public void setIndustry_name2(String industry_name2) {
        this.industry_name2 = industry_name2;
    }

    /**
     * logo地址
     */
    private String company_logo_url;
    /**
     * 营业执照
     */
    private String company_licence_url;
    /**
     *
     */
    private String company_type_id;
    /**
     *
     */
    private String company_type_name;
    /**
     *
     */
    private String company_size_id;
    /**
     *
     */
    private String company_size_name;
    /**
     *
     */
    private int province_id;
    /**
     * 国家
     */
    private String province_name;
    /**
     *
     */
    private int city_id;
    /**
     * 城市
     */
    private String city_name;
    /**
     *
     */
    private int area_id;
    /**
     * 区域
     */
    private String area_name;
    /**
     * 公司地址
     */
    private String company_address;
    /**
     * 招聘联系人
     */
    private String contact_man;
    /**
     * 招聘联系人手机
     */
    private String mobile;
    /**
     * 座机，类似：020-85968471-867
     */
    private String telephone;
    /**
     * 招聘联系E-Mail
     */
    private String email;
    /**
     * 公司主页
     */
    private String url;
    private String all_con;
    /**
     * 公司简介
     */
    private String summary;

    /**
     * 0:爬虫阶段；1:注册绑定（注册账号和公司绑定，允许一个公司多个该状态数据,审核时取最新的数据）；2：审核通过（账号绑定+营业执照审核通过）
     */
    private int status;
    /**
     * 爬虫阶段使用:第三方检索出来的公司id
     */
    private BigInteger third_id;
    /**
     * 爬虫阶段使用:数据来源51job/liepin/dxy
     */
    private String third_kind;

    /**
     * 公司链接
     */
    private String com_url;

    /**
     * 爬虫阶段:0,概要阶段(列表)；1，详细阶段
     */
    private int step;

    /**
     * 医院等级
     */
    private String hosp_level_name;

    private String scale_name;

    private String hosp_type_id;
    private String hosp_type_name;


    public String getScale_name() {
        return scale_name;
    }

    public void setScale_name(String scale_name) {
        this.scale_name = scale_name;
    }

    public String getCom_url() {
        return com_url;
    }

    public void setCom_url(String com_url) {
        this.com_url = com_url;
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
    public String getCompany_logo_url() {
        return this.company_logo_url;
    }

    /**
     *
     */
    public void setCompany_logo_url(String company_logo_url) {
        this.company_logo_url = company_logo_url;
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
    public String getCompany_type_name() {
        return this.company_type_name;
    }

    /**
     *
     */
    public void setCompany_type_name(String company_type_name) {
        this.company_type_name = company_type_name;
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
    public String getCompany_address() {
        return this.company_address;
    }

    /**
     *
     */
    public void setCompany_address(String company_address) {
        this.company_address = company_address;
    }

    /**
     *
     */
    public String getContact_man() {
        return this.contact_man;
    }

    /**
     *
     */
    public void setContact_man(String contact_man) {
        this.contact_man = contact_man;
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

    public String getCompany_licence_url() {
        return company_licence_url;
    }

    public void setCompany_licence_url(String company_licence_url) {
        this.company_licence_url = company_licence_url;
    }

    public String getCompany_type_id() {
        return company_type_id;
    }

    public void setCompany_type_id(String company_type_id) {
        this.company_type_id = company_type_id;
    }

    public String getCompany_size_id() {
        return company_size_id;
    }

    public void setCompany_size_id(String company_size_id) {
        this.company_size_id = company_size_id;
    }

    public String getCompany_size_name() {
        return company_size_name;
    }

    public void setCompany_size_name(String company_size_name) {
        this.company_size_name = company_size_name;
    }


    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getThird_kind() {
        return third_kind;
    }

    public void setThird_kind(String third_kind) {
        this.third_kind = third_kind;
    }

    public String getIndustry_id() {
        return industry_id;
    }

    public void setIndustry_id(String industry_id) {
        this.industry_id = industry_id;
    }

    public String getIndustry_name() {
        return industry_name;
    }

    public void setIndustry_name(String industry_name) {
        this.industry_name = industry_name;
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

    public String getAll_con() {
        return all_con;
    }

    public void setAll_con(String all_con) {
        this.all_con = all_con;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ent_company company = (Ent_company) o;

        if (!company_id.equals(company.company_id)) return false;
        return third_kind.equals(company.third_kind);

    }

    @Override
    public int hashCode() {
        int result = company_id.hashCode();
        result = 31 * result + third_kind.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ent_company{" +
                "company_id=" + company_id +
                ", company_name='" + company_name + '\'' +
                ", industry_id='" + industry_id + '\'' +
                ", industry_name='" + industry_name + '\'' +
                ", industry_name2='" + industry_name2 + '\'' +
                ", company_logo_url='" + company_logo_url + '\'' +
                ", company_licence_url='" + company_licence_url + '\'' +
                ", company_type_id='" + company_type_id + '\'' +
                ", company_type_name='" + company_type_name + '\'' +
                ", company_size_id='" + company_size_id + '\'' +
                ", company_size_name='" + company_size_name + '\'' +
                ", province_id=" + province_id +
                ", province_name='" + province_name + '\'' +
                ", city_id=" + city_id +
                ", city_name='" + city_name + '\'' +
                ", area_id=" + area_id +
                ", area_name='" + area_name + '\'' +
                ", company_address='" + company_address + '\'' +
                ", contact_man='" + contact_man + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", all_con='" + all_con + '\'' +
                ", summary='" + summary + '\'' +
                ", status_0=" + status +
                ", third_id=" + third_id +
                ", third_kind='" + third_kind + '\'' +
                ", com_url='" + com_url + '\'' +
                ", step=" + step +
                ", hosp_level_name='" + hosp_level_name + '\'' +
                ", scale_name='" + scale_name + '\'' +
                ", hosp_type_id='" + hosp_type_id + '\'' +
                ", hosp_type_name='" + hosp_type_name + '\'' +
                '}';
    }

    public String getHosp_level_name() {
        return hosp_level_name;
    }

    public void setHosp_level_name(String hosp_level_name) {
        this.hosp_level_name = hosp_level_name;
    }

    public String getHosp_type_id() {
        return hosp_type_id;
    }

    public void setHosp_type_id(String hosp_type_id) {
        this.hosp_type_id = hosp_type_id;
    }

    public String getHosp_type_name() {
        return hosp_type_name;
    }

    public void setHosp_type_name(String hosp_type_name) {
        this.hosp_type_name = hosp_type_name;
    }
}
