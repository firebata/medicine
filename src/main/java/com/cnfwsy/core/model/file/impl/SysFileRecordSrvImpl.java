package com.cnfwsy.core.model.file.impl;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.bean.SysFileRecord;
import com.cnfwsy.core.mapper.SysFileRecordMapper;
import com.cnfwsy.core.model.common.impl.CommonSrvImpl;
import com.cnfwsy.core.model.file.ISysFileRecordSrv;
import com.cnfwsy.interfaces.constant.BusinessConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 类说明: Created by zhangjh on 2016-6-16 15:33:15
 */
@Service("sysFileRecordSrvImpl")
public class SysFileRecordSrvImpl extends CommonSrvImpl<SysFileRecord> implements ISysFileRecordSrv, InitializingBean {

    @Resource(name = "sysFileRecordMapper")
    private SysFileRecordMapper sysFileRecordMapper;


    @Override
    public void afterPropertiesSet() {
        commonMapper = sysFileRecordMapper;
    }

    @Override
    public List<SysFileRecord> searchInfos(BaseForm info) {
        List<SysFileRecord> resut = null;
        resut = super.searchInfos(info);
        return resut;
    }

    @Override
    public void add(SysFileRecord info) {
        super.add(info);
    }

    @Override
    public void edit(SysFileRecord info) {
        super.edit(info);
    }

    @Override
    public SysFileRecord queryInfoByNatrualKey(String natrualKey) {
        return super.queryInfoByNatrualKey(natrualKey);
    }

    @Override
    public void del(String natrualKey) {
        super.del(natrualKey);
    }

    @Override
    public SysFileRecord saveFileRecord(String relativePath, String originFileName, String fileId, String suffix, String newFileName) {


        SysFileRecord fileRecord = new SysFileRecord();
        fileRecord.setFilePath(relativePath);
        fileRecord.setFileName(originFileName);
        fileRecord.setSuffix(suffix);
        fileRecord.setNewFileName(newFileName);
        fileRecord.setFileId(fileId);
        fileRecord.setStatus(BusinessConstant.FILE_STATUS_TEMP);
        super.add(fileRecord);
        return fileRecord;
    }

    @Override
    public void updateStatus(SysFileRecord sysFileRecord) {
        String fileId = sysFileRecord.getFileId();
        if (StringUtils.isNotBlank(fileId)) {
            sysFileRecordMapper.updateStatus(sysFileRecord);
        }

    }

    @Override
    public void updateStatus(List<SysFileRecord> records) {
        if (null != records && !records.isEmpty()) {
            sysFileRecordMapper.batchUpdate(records);
        }
    }

}