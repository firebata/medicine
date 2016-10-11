package com.cnfwsy.core.bean;

import com.cnfwsy.core.constant.ReturnCodeConstant;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 类说明:基础返回信息
 * Created by zhangjh on 2015/7/13.
 */
@Scope("prototype")
@Component
public class Response<T> {
    /**
     * 返回码
     */
    private Header header;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功
     *
     * @param data
     * @return
     */
    public Response<T> sucess(T data) {
        this.header = new Header(ReturnCodeConstant.SUCESS);
        this.data = data;
        return this;
    }

    /**
     * 失败
     *
     * @param returnCodeConstant
     * @return
     */
    public Response<T> failure(ReturnCodeConstant returnCodeConstant) {
        this.header = new Header(returnCodeConstant);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    /**
     * 返回码
     */
    public class Header {
        String rtn_code;
        String rtn_msg;

        public Header(ReturnCodeConstant returnCodeConstant) {
            this.rtn_code = returnCodeConstant.getCode();
            this.rtn_msg = returnCodeConstant.getMsg();
        }

        public String getRtn_code() {
            return rtn_code;
        }

        public void setRtn_code(String rtn_code) {
            this.rtn_code = rtn_code;

        }

        public String getRtn_msg() {
            return rtn_msg;
        }

        public void setRtn_msg(String rtn_msg) {
            this.rtn_msg = rtn_msg;
        }
    }


}
