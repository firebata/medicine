package com.cnfwsy.interfaces.bean.sys;

import com.cnfwsy.core.bean.BaseForm;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-12 13:37:37
 */
public class SysDictionary extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private String type;
    /**
     *
     */
    private String keyName;
    /**
     *
     */
    private String valueName;
    /**
     *
     */
    private String remark;

    /**
     *
     */
    public String getValueName() {
        return this.valueName;
    }

    /**
     *
     */
    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    /**
     *
     */
    public String getKeyName() {
        return this.keyName;
    }

    /**
     *
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    /**
     *
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     *
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
    public String getType() {
        return this.type;
    }

    /**
     *
     */
    public void setType(String type) {
        this.type = type;
    }

}
