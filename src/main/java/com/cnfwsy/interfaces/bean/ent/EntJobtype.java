package com.cnfwsy.interfaces.bean.ent;

import com.cnfwsy.core.bean.BaseForm;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-7-20 15:21:10
 */
public class EntJobtype extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private int typeId;
    /**
     * 职位类别名称
     */
    private String typeName;
    /**
     * -1表示顶级职位类别
     */
    private int parentId;
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
    public String getTypeName() {
        return this.typeName;
    }

    /**
     *
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
    public int getParentId() {
        return this.parentId;
    }

    /**
     *
     */
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

}
