package com.cnfwsy.core.exception;


import com.cnfwsy.core.constant.ReturnCodeConstant;

/**
 * 类说明:业务异常
 * Created by zhangjh on 2015/7/13.
 */
public class BusinessException extends RuntimeException {
    ReturnCodeConstant returnCodeConstant;

    public BusinessException(ReturnCodeConstant returnCodeConstant) {
        super();
        this.returnCodeConstant = returnCodeConstant;
    }

    public ReturnCodeConstant getReturnCodeConstant() {
        return returnCodeConstant;
    }

    public void setReturnCodeConstant(ReturnCodeConstant returnCodeConstant) {
        this.returnCodeConstant = returnCodeConstant;
    }
}
