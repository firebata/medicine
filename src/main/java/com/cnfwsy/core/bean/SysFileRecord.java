package com.cnfwsy.core.bean;

import java.math.BigInteger;

/**
 * 实体bean
 * Created by zhangjh on 2016-6-16 15:33:15
 */
public class SysFileRecord extends BaseForm {
    /**
     *
     */
    private int id;
    /**
     *
     */
    private String fileId;
    /**
     * 上传文件名
     */
    private String fileName;
    /**
     * 新文件名
     */
    private String newFileName;
    /**
     * 文件后缀
     */
    private String suffix;
    /**
     * 文件相对路径
     */
    private String filePath;
    /**
     * 文件url
     */
    private String fileUrl;
    /**
     *
     */
    private String delUrl;
    /**
     *
     */
    private String delFlag;
    /**
     * 业务模块id
     */
    private String bussId;
    /**
     * 上传文件
     */
    private String operatorId;
    /**
     *
     */
    private String createTime;
    /**
     *
     */
    private String updateTime;
    /**
     * 文件状态:0,临时状态，1：文件生效状态
     */
    private String status;
    /**
     *
     */
    private String pathType;

    public SysFileRecord() {
    }

    public SysFileRecord(int id) {
        this.id = id;
    }

    public SysFileRecord(String bussId, String fileId, String status) {
        super();
        this.bussId = bussId;
        this.fileId = fileId;
        this.status = status;
    }

    /**
     *
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     *
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     */
    public String getDelUrl() {
        return this.delUrl;
    }

    /**
     *
     */
    public void setDelUrl(String delUrl) {
        this.delUrl = delUrl;
    }

    /**
     *
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     *
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     *
     */
    public String getNewFileName() {
        return this.newFileName;
    }

    /**
     *
     */
    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    /**
     *
     */
    public String getUpdateTime() {
        return this.updateTime;
    }

    /**
     *
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *
     */
    public String getSuffix() {
        return this.suffix;
    }

    /**
     *
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
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
    public String getPathType() {
        return this.pathType;
    }

    /**
     *
     */
    public void setPathType(String pathType) {
        this.pathType = pathType;
    }

    /**
     *
     */
    public String getBussId() {
        return this.bussId;
    }

    /**
     *
     */
    public void setBussId(String bussId) {
        this.bussId = bussId;
    }

    /**
     *
     */
    public String getCreateTime() {
        return this.createTime;
    }

    /**
     *
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    /**
     *
     */
    public String getFileUrl() {
        return this.fileUrl;
    }

    /**
     *
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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
    public String getOperatorId() {
        return this.operatorId;
    }

    /**
     *
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     *
     */
    public String getFileId() {
        return this.fileId;
    }

    /**
     *
     */
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    /**
     *
     */
    public String getStatus() {
        return this.status;
    }

    /**
     *
     */
    public void setStatus(String status) {
        this.status = status;
    }

}
