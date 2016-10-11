package com.cnfwsy.core.constant;

import java.io.File;

/**
 * 公用常量类
 *
 * @author: zhangjh
 * @version:2015年5月6日 下午5:24:55
 */
public interface CommonConstant extends CharConstant, NumberConstant {
    String FILE_SEPRITER = File.separator;
    /**
     *
     */
    String RETURN_SUCCESS = "SUCCESS";
    /**
     *
     */
    String RETURN_FAIL = "FAIL";
    /**
     *
     */
    String RESULT_SUCCESS = "SUCCESS";
    /**
     *
     */
    String RESULT_FAIL = "FAIL";


    String SDE = "sde";//开发环境
    String STE = "ste";//测试环境
    String SPE = "spe";//生产环境


    int RESOURCE_TYPE_MENU = 0;
    int RESOURCE_TYPE_BTN = 1;
    String MENU_LEVEL_TOP_ID = "0";

    int USER_IS_UNLOCK = 0;//用户状态
    int USER_IS_LOCK = 1;

    int USER_IS_ADMIN = 1;//管理员
    int USER_IS_NOT_ADMIN = 0;//非管理员

    int NEED_TRANSFORM_COLUMN_NEME = 0;
    int NO_NEED_TRANSFORM_COLUMN_NAME = 1;
    String CURRENT_USER = "current_user";


    String SYSTEM_ENVIRONMENT = "system_environment";//软件产品环境
    String SYSTEM_ENVIRONMENT_CURRENT = "current";//当前软件产品环境


    int ACCOUNT_TYPE_PER = 0; //个人账号
    int ACCOUNT_TYPE_COM = 1; //企业账号
}
