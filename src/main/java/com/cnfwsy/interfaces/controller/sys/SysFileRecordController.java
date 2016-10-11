package com.cnfwsy.interfaces.controller.sys;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.bean.SysFileRecord;
import com.cnfwsy.core.model.file.ISysFileRecordSrv;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 接口层
 * Created by zhangjh on 2016-6-16 15:33:15
 */
@RestController
public class SysFileRecordController extends BaseController<SysFileRecord> {

    @Resource(name = "sysFileRecordSrvImpl")
    private ISysFileRecordSrv sysFileRecordSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/sysFileRecord", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody SysFileRecord sysFileRecord) {
        sysFileRecordSrvImpl.add(sysFileRecord);
        Response response = buildResponse(sysFileRecord);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/sysFileRecord/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysFileRecord sysFileRecord = sysFileRecordSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(sysFileRecord);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/sysFileRecord/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysFileRecord sysFileRecord = null;
        sysFileRecordSrvImpl.del(businessKey);
        Response response = buildResponse(sysFileRecord);
        return response;
    }

    /**
     * @param sysFileRecord
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/sysFileRecord/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody SysFileRecord sysFileRecord) {
        sysFileRecordSrvImpl.edit(sysFileRecord);
        Response response = buildResponse(sysFileRecord);
        return response;
    }

    /**
     * @param infos List<SysFileRecord>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/sysFileRecord", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<SysFileRecord> infos) {
        sysFileRecordSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/sysFileRecords", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody SysFileRecord sysFileRecord) {
        Response response = buildSearchJsonMap(sysFileRecord, request, sysFileRecordSrvImpl);
        return response;
    }

}
