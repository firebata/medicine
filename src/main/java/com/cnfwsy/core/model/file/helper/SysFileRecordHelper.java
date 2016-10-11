package com.cnfwsy.core.model.file.helper;

import com.cnfwsy.core.bean.SysFileRecord;
import com.cnfwsy.interfaces.constant.BusinessConstant;

/**
 * 说明:
 * Created by zhangjh on 2016-06-22.
 */
public enum SysFileRecordHelper {

    SINGLETONE;

    /**
     * @param bussId BigInteger
     * @param fileId String
     * @param status String
     * @return
     */
    public static SysFileRecord getInstance(String bussId, String fileId, String status) {
        SysFileRecord file = new SysFileRecord(bussId, fileId, status);
        return file;
    }


    public static SysFileRecord getInstance(String busId, String fileId) {
        return getInstance(busId, fileId, BusinessConstant.FILE_STATUS_OK);
    }
}
