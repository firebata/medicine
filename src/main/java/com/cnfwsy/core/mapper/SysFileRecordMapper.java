package com.cnfwsy.core.mapper;

import com.cnfwsy.core.bean.SysFileRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类说明: Created by zhangjh on 2016-6-16 15:33:15
 */
@Repository("sysFileRecordMapper")
public interface SysFileRecordMapper extends CommonMapper<SysFileRecord> {

    void updateStatus(SysFileRecord sysFileRecord);

    void batchUpdate(List<SysFileRecord> records);
}