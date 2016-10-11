package com.cnfwsy.interfaces.controller.sys;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.sys.SysMessage;
import com.cnfwsy.interfaces.model.sys.ISysMessageSrv;
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
public class SysMessageController extends BaseController<SysMessage> {

    @Resource(name = "sysMessageSrvImpl")
    private ISysMessageSrv sysMessageSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/sysMessage", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody SysMessage sysMessage) {
        sysMessageSrvImpl.add(sysMessage);
        Response response = buildResponse(sysMessage);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/sysMessage/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysMessage sysMessage = sysMessageSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(sysMessage);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/sysMessage/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysMessage sysMessage = null;
        sysMessageSrvImpl.del(businessKey);
        Response response = buildResponse(sysMessage);
        return response;
    }

    /**
     * @param sysMessage
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/sysMessage/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody SysMessage sysMessage) {
        sysMessageSrvImpl.edit(sysMessage);
        Response response = buildResponse(sysMessage);
        return response;
    }

    /**
     * @param infos List<SysMessage>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/sysMessage", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<SysMessage> infos) {
        sysMessageSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/sysMessages", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody SysMessage sysMessage) {
        Response response = buildSearchJsonMap(sysMessage, request, sysMessageSrvImpl);
        return response;
    }

}
