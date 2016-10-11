package com.cnfwsy.interfaces.controller.sys;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.sys.SysLog;
import com.cnfwsy.interfaces.model.sys.ISysLogSrv;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 接口层
 * Created by zhangjh on 2016-6-12 13:37:37
 */
@RestController
public class SysLogController extends BaseController<SysLog> {

    @Resource(name = "sysLogSrvImpl")
    private ISysLogSrv sysLogSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/sysLog", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody SysLog sysLog) {
        sysLogSrvImpl.add(sysLog);
        Response response = buildResponse(sysLog);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/sysLog/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysLog sysLog = sysLogSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(sysLog);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/sysLog/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysLog sysLog = null;
        sysLogSrvImpl.del(businessKey);
        Response response = buildResponse(sysLog);
        return response;
    }

    /**
     * @param sysLog
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/sysLog/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody SysLog sysLog) {
        sysLogSrvImpl.edit(sysLog);
        Response response = buildResponse(sysLog);
        return response;
    }

    /**
     * @param infos List<SysLog>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/sysLog", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<SysLog> infos) {
        sysLogSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/sysLogs", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody SysLog sysLog) {
        Response response = buildSearchJsonMap(sysLog, request, sysLogSrvImpl);
        return response;
    }

}
