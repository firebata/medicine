package com.cnfwsy.core.bean;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class SysAccount extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 企业账号id或者个人简历iid
     */
    private String bussId;
    /**
     * 账号ID
     */
    private String accountId;
    /**
     * 账号类型(0:个人1:公司)
     */
    private int typeId;
    /**
     * 账号
     */
    private String name;
    /**
     * 密码
     */
    private String password;

    /**
     * 新密码
     */
    private String passwordnew;
    /**
     * 手机号
     */
    private String telNo;
    /**
     * QQ号码
     */
    private String qq;
    /**
     * 微博账号
     */
    private String weibo;
    /**
     * 微信号
     */
    private String weixin;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 删除标记:默认0,1:删除
     */
    private String delFlag;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 验证码
     */
    private String validateCode;

    /**
     *
     */
    public String getQq() {
        return this.qq;
    }

    /**
     *
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     *
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     *
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public String getDelFlag() {
        return this.delFlag;
    }

    /**
     *
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     *
     */
    public String getTelNo() {
        return this.telNo;
    }

    /**
     *
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     *
     */
    public String getAccountId() {
        return this.accountId;
    }

    /**
     *
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     *
     */
    public String getPassword() {
        return this.password;
    }

    /**
     *
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     */
    public String getWeixin() {
        return this.weixin;
    }

    /**
     *
     */
    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    /**
     *
     */
    public String getWeibo() {
        return this.weibo;
    }

    /**
     *
     */
    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }

    /**
     *
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    public int getTypeId() {
        return this.typeId;
    }

    /**
     *
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    /**
     *
     */
    public int getId() {
        return this.id;
    }

    /**
     *
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     */
    public String getEmail() {
        return this.email;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    /**
     *
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getBussId() {
        return bussId;
    }

    public void setBussId(String bussId) {
        this.bussId = bussId;
    }

    public String getPasswordnew() {
        return passwordnew;
    }

    public void setPasswordnew(String passwordnew) {
        this.passwordnew = passwordnew;
    }
}
