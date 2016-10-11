package com.cnfwsy.interfaces.thread;

import com.cnfwsy.interfaces.model.sys.ICreateHotJobsTableSrc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 说明:创建首页表数据，每天早上5点生成
 * Created by zhangjh on 2016-09-20.
 */
@Component
public class CreateHotJobsTableThread {

    @Autowired
    private ICreateHotJobsTableSrc createHotJobsTableSrc;


    @Scheduled(cron = "0 0 5 * * ?")
    public void run() {
        createHotJobsTableSrc.createHosJobsTable();
    }



}
