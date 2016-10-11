package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.interfaces.mapper.sys.CreateHotJobsTableMapper;
import com.cnfwsy.interfaces.model.sys.ICreateHotJobsTableSrc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 说明:
 * Created by zhangjh on 2016-09-20.
 */
@Service("createHotJobsTableSrc")
public class CreateHotJobsTableSrcImpl implements ICreateHotJobsTableSrc {
    @Autowired
    private CreateHotJobsTableMapper createHotJobsTableMapper;

    @Override
    public void createHosJobsTable() {
        createHotJobsTableMapper.createHosJobsTable();
    }
}
