package com.cnfwsy.core.model.file;

import com.cnfwsy.core.model.common.ICommonSrv;
import com.cnfwsy.core.bean.SysFileRecord;

import java.util.List;

/**
 * 类说明: Created by zhangjh on 2016-6-16 15:33:15
 */
public interface ISysFileRecordSrv extends ICommonSrv<SysFileRecord> {

    SysFileRecord saveFileRecord(String relativePath, String originFileName, String fileId, String suffix, String newFileName);

    void updateStatus(SysFileRecord sysFileRecord);

    void updateStatus(List<SysFileRecord> records);
}