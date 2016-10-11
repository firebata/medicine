package com.cnfwsy.core.constant;

/**
 * 说明:
 * Created by zhangjh on 2016-05-26.
 */
public enum ReturnCodeConstant {
    SUCESS("000000", "成功"),
    SYS_EXP("100001", "系统内部异常"),
    MESSAGE_NOT_READABLE("100002", "参数解析失败"),
    REQUEST_METHOD_NOT_SUPPORTED("100003", "不支持当前请求方法"),
    MEDIA_TYPE_NOT_SUPPORTED("100004", "不支持当前媒体类型"),
    VALIDATION_EXCEPTION("100005", "参数验证失败"),
    USER_IS_NOT_LOGINED("100006", "用户没有登录"),
    TOKEN_IS_INVALID("100007", "用户token失效"),
    SERVERID_IS_ERROR("100008", "server id is error,please check config file"),
    JSONPARSE_EXCEPTION("100009", "数据解析失败"),
    NOT_ALLOW_REGISTER("100010", "手机号码或邮箱已注册,不能重复注册"),
    TELNO_IS_INVALID("100011", "手机号码不正确"),
    ACCOUNT_ISNOT_ENT("100012", "非企业账号"),
    CANNOT_VIEW_OTHER_ENT("100013", "不能查看其它企业的信息"),
    GET_VCODE_EXCEPTION("100014", "获取短信验证码失败"),
    VCODE_ISERROR("100015", "验证码不正确"),
    VCODE_EXPIRED("10006", "验证码过期"),
    PWD_IS_ERROR("100017", "密码错误"),
    COMPANY_NOEXIT_EXCEPTION("200001", "公司信息不存在"),
    ACCOUNT_NOEXIT_EXCEPTION("200002", "账号信息不存在"),
    REPEAT_APPLY_JOB("300001", "重复申请职位"),
    NOT_FINISH_RESUME("300002", "简历没有完成"),;

    private String code;

    private String msg;


    ReturnCodeConstant(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
