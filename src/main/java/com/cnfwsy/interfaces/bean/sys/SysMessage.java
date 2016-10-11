package com.cnfwsy.interfaces.bean.sys;

import com.cnfwsy.core.bean.BaseForm;

import java.math.BigInteger;
import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class SysMessage extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 消息ID
     */
    private BigInteger messageId;
    /**
     * 账号ID
     */
    private BigInteger accountId;
    /**
     * 消息类型id:系统,投递反馈
     */
    private int typeId;
    /**
     * 内容
     */
    private String text;
    /**
     * 删除标记:默认0,1:删除
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
     *
     */
    public BigInteger getAccountId() {
        return this.accountId;
    }

    /**
     *
     */
    public void setAccountId(BigInteger accountId) {
        this.accountId = accountId;
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
    public BigInteger getMessageId() {
        return this.messageId;
    }

    /**
     *
     */
    public void setMessageId(BigInteger messageId) {
        this.messageId = messageId;
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
    public String getText() {
        return this.text;
    }

    /**
     *
     */
    public void setText(String text) {
        this.text = text;
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

}
