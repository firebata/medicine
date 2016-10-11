package com.cnfwsy.spider.htmlparser.bean;
import java.math.BigInteger;
import java.util.Date;
/**
* 实体bean
* Created by zhangjh on 2016-7-18 17:08:41
*/
public class EntCompany{
    /**
    *
    */
    private int id;
    /**
    *
    */
    private BigInteger company_id;
    /**
    *公司名
    */
    private String company_name;
    /**
    *logo地址
    */
    private String company_logo_url;
    /**
    *营业执照
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
    private int country_id;
    /**
    *国家
    */
    private String country_name;
    /**
    *
    */
    private int city_id;
    /**
    *城市
    */
    private String city_name;
    /**
    *
    */
    private int area_id;
    /**
    *区域
    */
    private String area_name;
    /**
    *公司地址
    */
    private String company_address;
    /**
    *招聘联系人
    */
    private String contact_man;
    /**
    *招聘联系人手机
    */
    private String mobile;
    /**
    *座机，类似：020-85968471-867
    */
    private String telephone;
    /**
    *招聘联系E-Mail
    */
    private String email;
    /**
    *公司主页
    */
    private String url;
    /**
    *公司简介
    */
    private String summary;
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
    *0:爬虫阶段；1:注册绑定（注册账号和公司绑定，离婚允许一个公司多个该状态数据）；2：审核通过（账号绑定+营业执照审核通过）
    */
    private int status;

    /**
    *
    */
    public  String getArea_name(){
        return this.area_name;
    }

    /**
    *
    */
    public  void setArea_name(String area_name){
        this.area_name = area_name;
    }

    /**
    *
    */
    public  String getCompany_logo_url(){
        return this.company_logo_url;
    }

    /**
    *
    */
    public  void setCompany_logo_url(String company_logo_url){
        this.company_logo_url = company_logo_url;
    }

    /**
    *
    */
    public  String getCompany_type_name(){
        return this.company_type_name;
    }

    /**
    *
    */
    public  void setCompany_type_name(String company_type_name){
        this.company_type_name = company_type_name;
    }

    /**
    *
    */
    public  int getArea_id(){
        return this.area_id;
    }

    /**
    *
    */
    public  void setArea_id(int area_id){
        this.area_id = area_id;
    }

    /**
    *
    */
    public  String getCompany_address(){
        return this.company_address;
    }

    /**
    *
    */
    public  void setCompany_address(String company_address){
        this.company_address = company_address;
    }

    /**
    *
    */
    public  String getContact_man(){
        return this.contact_man;
    }

    /**
    *
    */
    public  void setContact_man(String contact_man){
        this.contact_man = contact_man;
    }

    /**
    *
    */
    public  String getCity_name(){
        return this.city_name;
    }

    /**
    *
    */
    public  void setCity_name(String city_name){
        this.city_name = city_name;
    }

    /**
    *
    */
    public  Date getUpdate_time(){
        return this.update_time;
    }

    /**
    *
    */
    public  void setUpdate_time(Date update_time){
        this.update_time = update_time;
    }

    /**
    *
    */
    public  String getCompany_size_name(){
        return this.company_size_name;
    }

    /**
    *
    */
    public  void setCompany_size_name(String company_size_name){
        this.company_size_name = company_size_name;
    }

    /**
    *
    */
    public  String getCountry_name(){
        return this.country_name;
    }

    /**
    *
    */
    public  void setCountry_name(String country_name){
        this.country_name = country_name;
    }

    /**
    *
    */
    public  int getId(){
        return this.id;
    }

    /**
    *
    */
    public  void setId(int id){
        this.id = id;
    }

    /**
    *
    */
    public  String getEmail(){
        return this.email;
    }

    /**
    *
    */
    public  void setEmail(String email){
        this.email = email;
    }

    /**
    *
    */
    public  String getSummary(){
        return this.summary;
    }

    /**
    *
    */
    public  void setSummary(String summary){
        this.summary = summary;
    }

    /**
    *
    */
    public  String getDel_flag(){
        return this.del_flag;
    }

    /**
    *
    */
    public  void setDel_flag(String del_flag){
        this.del_flag = del_flag;
    }

    /**
    *
    */
    public  BigInteger getCompany_id(){
        return this.company_id;
    }

    /**
    *
    */
    public  void setCompany_id(BigInteger company_id){
        this.company_id = company_id;
    }

    /**
    *
    */
    public  Date getCreate_time(){
        return this.create_time;
    }

    /**
    *
    */
    public  void setCreate_time(Date create_time){
        this.create_time = create_time;
    }

    /**
    *
    */
    public  String getMobile(){
        return this.mobile;
    }

    /**
    *
    */
    public  void setMobile(String mobile){
        this.mobile = mobile;
    }

    /**
    *
    */
    public  String getCompany_licence_url(){
        return this.company_licence_url;
    }

    /**
    *
    */
    public  void setCompany_licence_url(String company_licence_url){
        this.company_licence_url = company_licence_url;
    }

    /**
    *
    */
    public  String getTelephone(){
        return this.telephone;
    }

    /**
    *
    */
    public  void setTelephone(String telephone){
        this.telephone = telephone;
    }

    /**
    *
    */
    public  String getUrl(){
        return this.url;
    }

    /**
    *
    */
    public  void setUrl(String url){
        this.url = url;
    }

    /**
    *
    */
    public  String getCompany_size_id(){
        return this.company_size_id;
    }

    /**
    *
    */
    public  void setCompany_size_id(String company_size_id){
        this.company_size_id = company_size_id;
    }

    /**
    *
    */
    public  String getCompany_type_id(){
        return this.company_type_id;
    }

    /**
    *
    */
    public  void setCompany_type_id(String company_type_id){
        this.company_type_id = company_type_id;
    }

    /**
    *
    */
    public  String getCompany_name(){
        return this.company_name;
    }

    /**
    *
    */
    public  void setCompany_name(String company_name){
        this.company_name = company_name;
    }

    /**
    *
    */
    public  int getCountry_id(){
        return this.country_id;
    }

    /**
    *
    */
    public  void setCountry_id(int country_id){
        this.country_id = country_id;
    }

    /**
    *
    */
    public  int getCity_id(){
        return this.city_id;
    }

    /**
    *
    */
    public  void setCity_id(int city_id){
        this.city_id = city_id;
    }

    /**
    *
    */
    public  int getStatus(){
        return this.status;
    }

    /**
    *
    */
    public  void setStatus(int status){
        this.status = status;
    }

}
