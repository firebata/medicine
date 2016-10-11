package com.cnfwsy.interfaces.bean.emp;

import com.cnfwsy.core.bean.BaseForm;

import java.util.Date;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class EmpResSkill extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     * 技能ID
     */
    private String skillId;
    /**
     * 简历ID
     */
    private String resumeId;
    /**
     * 水平(1了解,2熟悉,3掌握,4精通,5专家)
     */
    private int level;
    /**
     * 名称
     */
    private String name;
    /**
     * 排序
     */
    private int index;
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
    public String getSkillId() {
        return this.skillId;
    }

    /**
     *
     */
    public void setSkillId(String skillId) {
        this.skillId = skillId;
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
    public int getLevel() {
        return this.level;
    }

    /**
     *
     */
    public void setLevel(int level) {
        this.level = level;
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
    public int getIndex() {
        return this.index;
    }

    /**
     *
     */
    public void setIndex(int index) {
        this.index = index;
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

}
