package com.cnfwsy.interfaces.controller.sys;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.sys.SysSms;
import com.cnfwsy.interfaces.model.sys.ISysSmsSrv;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 接口层
 * Created by zhangjh on 2016-8-8 14:23:31
 */
@RestController
public class SysSmsController extends BaseController<SysSms> {

    @Resource(name = "sysSmsSrvImpl")
    private ISysSmsSrv sysSmsSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/sysSms", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody SysSms sysSms) {

        sysSmsSrvImpl.add(sysSms);
        Response response = buildResponse(sysSms);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/sysSms/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysSms sysSms = sysSmsSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(sysSms);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/sysSms/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {

        SysSms sysSms = null;
        sysSmsSrvImpl.del(businessKey);
        Response response = buildResponse(sysSms);
        return response;

    }

    /**
     * @param sysSms
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/sysSms/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody SysSms sysSms) {

        sysSmsSrvImpl.edit(sysSms);
        Response response = buildResponse(sysSms);
        return response;

    }

    /**
     * @param infos List<SysSms>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/sysSms", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<SysSms> infos) {

        sysSmsSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/sysSmss", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody SysSms sysSms) {

        Response response = buildSearchJsonMap(sysSms, request, sysSmsSrvImpl);
        return response;

    }

}
