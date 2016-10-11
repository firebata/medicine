package com.cnfwsy.core.controller;

import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.bean.Page;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.constant.ReturnCodeConstant;
import com.cnfwsy.core.exception.BusinessException;
import com.cnfwsy.core.model.common.ICommonSrv;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 此类描述的是：控制层基础处理类
 *
 * @author: zhangjh
 * @version: 2015年4月30日 下午4:34:05
 */
public abstract class BaseController<T> {

    /**
     * @param baseForm
     * @param request
     * @param commonSrv
     * @return
     */
    public Response<Page<T>> buildSearchJsonMap(BaseForm baseForm, HttpServletRequest request, ICommonSrv<T> commonSrv) {
        // 总记录数
        double recordsFiltered = commonSrv.listFilteredInfosCounts(baseForm) + 0.0d;
        int pageSize = baseForm.getPageSize() == null ? 16 : baseForm.getPageSize();
        int pageCount = (int) Math.ceil(recordsFiltered / pageSize);
        int start = (baseForm.getPageNo() - 1) * pageSize;
        baseForm.setStart(start);
        List<T> infos = commonSrv.searchInfos(baseForm);
        Page<T> page = new Page<>();
        page.setPageCount(pageCount);
        page.setPageNo(baseForm.getPageNo());
        page.setPageSize(pageSize);
        page.setItems(infos);
        page.setAllRecordCount((int) recordsFiltered);
        this.affterDeal(infos);
        return buildResponse(page);
    }

    private Response<Page<T>> buildResponse(Page<T> page) {
        Response<Page<T>> response = new Response<Page<T>>().sucess(page);
        return response;
    }

    /**
     * @param results 数据结果集
     * @return
     */
    public Response<List<T>> buildResponse(List<T> results) {
        Response<List<T>> response = new Response<List<T>>().sucess(results);
        return response;
    }

    /**
     * @param data 数据结果
     * @return
     */
    public Response<T> buildResponse(T data) {
        Response<T> response = new Response<T>().sucess(data);
        return response;
    }

    /**
     * @param data 数据结果
     * @return
     */
    public Response<Map<String, String>> buildResponse(Map<String, String> data) {
        Response<Map<String, String>> response = new Response<Map<String, String>>().sucess(data);
        return response;
    }


    /**
     * 对结果额外处理:实现放到子类处理
     *
     * @param infos
     */
    public void affterDeal(List<T> infos) {

    }

    /**
     * @param codeConstant 返回具体的业务异常
     */
    public void throwBusExp(ReturnCodeConstant codeConstant) {
        throw new BusinessException(codeConstant);
    }
}
