package com.cnfwsy.core.api;

import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.constant.ReturnCodeConstant;
import com.cnfwsy.core.exception.AuthorizationException;
import com.cnfwsy.core.exception.BusinessException;
import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ValidationException;

/**
 * 说明:全局异常处理
 * Created by zhangjh on 2016-05-27.
 */
@ControllerAdvice
@ResponseBody
public class BusinessExceptionAdvice {
    Logger logger = LoggerFactory.getLogger(BusinessExceptionAdvice.class);

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        return new Response().failure(ReturnCodeConstant.MESSAGE_NOT_READABLE);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public Response handleValidationException(ValidationException e) {
        logger.error("参数验证失败", e);
        return new Response().failure(ReturnCodeConstant.VALIDATION_EXCEPTION);
    }

    /**
     * 400 - Bad Request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonParseException.class)
    public Response handleValidationException(JsonParseException e) {
        logger.error("数据解析失败", e);
        return new Response().failure(ReturnCodeConstant.JSONPARSE_EXCEPTION);
    }

    /**
     * 405 - Method Not Allowed
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        return new Response().failure(ReturnCodeConstant.REQUEST_METHOD_NOT_SUPPORTED);
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Response handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("不支持当前媒体类型", e);
        return new Response().failure(ReturnCodeConstant.MEDIA_TYPE_NOT_SUPPORTED);
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public Response handleBusinessException(BusinessException e) {
        logger.error(e.getMessage(), e);
        return new Response().failure(e.getReturnCodeConstant());
    }

    /**
     * 未登录
     */
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView handleBusinessException(AuthorizationException e) {
//        ModelAndView view = new ModelAndView("/login");
//        return view;
        throw e;
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        logger.error("服务运行异常", e);
        return new Response().failure(ReturnCodeConstant.SYS_EXP);
    }

}
