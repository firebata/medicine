package com.cnfwsy.interfaces.bean.emp;

import com.cnfwsy.core.bean.BaseForm;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class EmpResShow extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 作品ID
     */
    private String showId;
    /**
     * 简历ID
     */
    private String resumeId;
    /**
     * 标题
     */
    private String title;
    /**
     * 网页
     */
    private String website;
    /**
     * 作品类型
     */
    private int typeId;
    /**
     * 图片路径
     */
    private String imagePath;
    /**
     * 描述
     */
    private String description;
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
    public String getWebsite() {
        return this.website;
    }

    /**
     *
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     *
     */
    public String getShowId() {
        return this.showId;
    }

    /**
     *
     */
    public void setShowId(String showId) {
        this.showId = showId;
    }

    /**
     *
     */
    public String getResumeId() {
        return this.resumeId;
    }

    /**
     *
     */
    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
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
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     *
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     *
     */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     */
    public void setDescription(String description) {
        this.description = description;
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
    public String getTitle() {
        return this.title;
    }

    /**
     *
     */
    public void setTitle(String title) {
        this.title = title;
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
