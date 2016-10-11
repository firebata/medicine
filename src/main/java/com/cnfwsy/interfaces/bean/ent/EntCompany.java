package com.cnfwsy.interfaces.bean.ent;

import com.cnfwsy.core.bean.BaseForm;

import java.math.BigInteger;
import java.util.*;

/**
 * 实体bean
 * Created by zhangjh on 2016-7-20 15:21:09
 */
public class EntCompany extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private String companyId;
    /**
     * 公司名
     */
    private String companyName;
    /**
     * 行业类别id，参考字典表
     */
    private String industryId;
    /**
     * 行业类别
     */
    private String industryName;

    /**
     * 行业类别id，参考字典表
     */
    private String industryId2;
    /**
     * 行业类别
     */
    private String industryName2;


    private Map<String, String> industryMap;
    /**
     * logo地址
     */
    private String companyLogoUrl;
    /**
     * 营业执照
     */
    private String companyLicenceUrl;
    /**
     * 公司性质id
     */
    private String companyTypeId;
    /**
     * 公司性质,值参考字典表
     */
    private String companyTypeName;
    private Map<String, String> companyTypeMap;
    /**
     * 公司规模id，值参考字典表
     */
    private String companySizeId;
    /**
     * 公司规模
     */
    private String companySizeName;
    private Map<String, String> companySizeMap;
    /**
     *
     */
    private String hospLevelId;
    /**
     * 医院等级
     */
    private String hospLevelName;
    private Map<String, String> hospLevelMap;
    /**
     *
     */
    private String provinceId;
    /**
     * 国家
     */
    private String provinceName;
    private Map<String, String> provinceMap;
    /**
     *
     */
    private String cityId;
    /**
     * 城市
     */
    private String cityName;
    private Map<String, String> cityMap;
    /**
     *
     */
    private int areaId;
    /**
     * 区域
     */
    private String areaName;
    /**
     * 公司地址
     */
    private String companyAddress;
    /**
     * 招聘联系人
     */
    private String contactMan;
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
    /**
     *
     */
    private String scaleId;
    /**
     * 机构规模
     */
    private String scaleName;
    /**
     * 公司简介
     */
    private String summary;
    /**
     *
     */
    private String delFlag;
    /**
     *
     */
    private Date createTime;
    /**
     *
     */
    private Date updateTime;
    /**
     * 0:爬虫阶段；1:注册绑定（注册账号和公司绑定，允许一个公司多个该状态数据,审核时取最新的数据）；2：审核通过（账号绑定+营业执照审核通过）
     */
    private int status;
    /**
     * 爬虫阶段使用:第三方检索出来的公司id
     */
    private BigInteger thirdId;
    /**
     * 爬虫阶段使用:数据来源51job/liepin/dxy
     */
    private String thirdKind;
    /**
     * 职位链接
     */
    private String comUrl;
    /**
     * 爬虫阶段:0,概要阶段(职位列表)；1，详细阶段
     */
    private int step;

    /**
     * 文件id
     */
    private String fileId;

    private String editorValue;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndustryId() {
        return industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getCompanyLogoUrl() {
        return companyLogoUrl;
    }

    public void setCompanyLogoUrl(String companyLogoUrl) {
        this.companyLogoUrl = companyLogoUrl;
    }

    public String getCompanyLicenceUrl() {
        return companyLicenceUrl;
    }

    public void setCompanyLicenceUrl(String companyLicenceUrl) {
        this.companyLicenceUrl = companyLicenceUrl;
    }

    public String getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(String companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    public String getCompanyTypeName() {
        return companyTypeName;
    }

    public void setCompanyTypeName(String companyTypeName) {
        this.companyTypeName = companyTypeName;
    }

    public String getCompanySizeId() {
        return companySizeId;
    }

    public void setCompanySizeId(String companySizeId) {
        this.companySizeId = companySizeId;
    }

    public String getCompanySizeName() {
        return companySizeName;
    }

    public void setCompanySizeName(String companySizeName) {
        this.companySizeName = companySizeName;
    }

    public String getHospLevelId() {
        return hospLevelId;
    }

    public void setHospLevelId(String hospLevelId) {
        this.hospLevelId = hospLevelId;
    }

    public String getHospLevelName() {
        return hospLevelName;
    }

    public void setHospLevelName(String hospLevelName) {
        this.hospLevelName = hospLevelName;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getContactMan() {
        return contactMan;
    }

    public void setContactMan(String contactMan) {
        this.contactMan = contactMan;
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

    public String getScaleId() {
        return scaleId;
    }

    public void setScaleId(String scaleId) {
        this.scaleId = scaleId;
    }

    public String getScaleName() {
        return scaleName;
    }

    public void setScaleName(String scaleName) {
        this.scaleName = scaleName;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigInteger getThirdId() {
        return thirdId;
    }

    public void setThirdId(BigInteger thirdId) {
        this.thirdId = thirdId;
    }

    public String getThirdKind() {
        return thirdKind;
    }

    public void setThirdKind(String thirdKind) {
        this.thirdKind = thirdKind;
    }

    public String getComUrl() {
        return comUrl;
    }

    public void setComUrl(String comUrl) {
        this.comUrl = comUrl;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public Map<String, String> getIndustryMap() {
        return industryMap;
    }

    public void setIndustryMap(Map<String, String> industryMap) {
        this.industryMap = industryMap;
    }

    public Map<String, String> getCompanyTypeMap() {
        return companyTypeMap;
    }

    public void setCompanyTypeMap(Map<String, String> companyTypeMap) {
        this.companyTypeMap = companyTypeMap;
    }

    public Map<String, String> getCompanySizeMap() {
        return companySizeMap;
    }

    public void setCompanySizeMap(Map<String, String> companySizeMap) {
        this.companySizeMap = companySizeMap;
    }

    public Map<String, String> getHospLevelMap() {
        return hospLevelMap;
    }

    public void setHospLevelMap(Map<String, String> hospLevelMap) {
        this.hospLevelMap = hospLevelMap;
    }

    public String getIndustryId2() {
        return industryId2;
    }

    public void setIndustryId2(String industryId2) {
        this.industryId2 = industryId2;
    }

    public String getIndustryName2() {
        return industryName2;
    }

    public void setIndustryName2(String industryName2) {
        this.industryName2 = industryName2;
    }

    public Map<String, String> getProvinceMap() {
        return provinceMap;
    }

    public void setProvinceMap(Map<String, String> provinceMap) {
        this.provinceMap = provinceMap;
    }

    public Map<String, String> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<String, String> cityMap) {
        this.cityMap = cityMap;
    }

    public String getEditorValue() {
        return editorValue;
    }

    public void setEditorValue(String editorValue) {
        this.editorValue = editorValue;
    }
}
