package com.cnfwsy.interfaces.constant;

/**
 * 业务常量累
 * Created by zhangjh on 16/6/4.
 */
public interface BusinessConstant {
    //帐号类型
    String ACCOUNT_TYPE = "account_type";
    //公司
    String ACCOUNT_TYPE_COMMPANY = "company";
    //个人帐号
    String ACCOUNT_TYPE_EMPLOYEE = "employee";


    String FILE_STATUS_TEMP = "0";
    String FILE_STATUS_OK = "1";

    String JOB_NATURE = "job_nature";//账户类型
    String BOX_EXPERIENCE = "box_experience";//工作经历
    String BOX_EDUCATION = "box_education";//学历
    String COMPANY_TYPE = "company_type";//公司性质
    String JOB_WELFARE = "job_welfare";//职位标签
    String COMPANY_SIZE = "company_size";//公司大小
    String INDUSTRY = "industry";//行业类别
    String HOSP_LEVEL = "hosp_level";//医院等级

    int STEP_FINISH = 2;
    String ZHAOLAI = "zl";
    String SMC_VERIFICATION = "smc_verification";
    String CURRENT_PLATFORM = "current_platform";
    String TEMPLATE = "template";
    String EFFECTIVE_TIME = "effective_time";
    int SMC_DOWN = 0;//发送状态
    int SMC_UP = 1;//已验证


    int COMPANY_STATUS_NEW = 0;//企业信息新建状态
    int COMPANY_STATUS_TEMP = 1;//企业信息临时状态
    int COMPANY_STATUS_APPROVED = 2;//企业信息已审核状态
    int COMPANY_STATUS_FORBIDDEN = 3;//企业账号禁用状态
}
