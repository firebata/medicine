package com.cnfwsy.interfaces.controller.sys;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.sys.SysCity;
import com.cnfwsy.interfaces.model.sys.ISysCitySrv;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 接口层
 * Created by zhangjh on 2016-6-12 13:37:37
 */
@RestController
public class SysCityController extends BaseController<SysCity> {

    @Resource(name = "sysCitySrvImpl")
    private ISysCitySrv sysCitySrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/sysCity", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody SysCity sysCity) {
        sysCitySrvImpl.add(sysCity);
        Response response = buildResponse(sysCity);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/sysCity/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysCity sysCity = sysCitySrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(sysCity);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/sysCity/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysCity sysCity = null;
        sysCitySrvImpl.del(businessKey);
        Response response = buildResponse(sysCity);
        return response;
    }

    /**
     * @param sysCity
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/sysCity/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody SysCity sysCity) {
        sysCitySrvImpl.edit(sysCity);
        Response response = buildResponse(sysCity);
        return response;
    }

    /**
     * @param infos List<SysCity>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/sysCity", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<SysCity> infos) {
        sysCitySrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/sysCitys", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody SysCity sysCity) {
        Response response = buildSearchJsonMap(sysCity, request, sysCitySrvImpl);
        return response;
    }

    /**
     * 根据名字查找城市
     *
     * @param cityName
     * @return
     */
    @SystemControllerLog(description = "检测城市是否存在")
    @RequestMapping(value = "/checkCity/{cityName}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response querySysCityByCityName(@PathVariable("cityName") String cityName) {
        SysCity sysCity = sysCitySrvImpl.querySysCityByCityName(cityName);
        Response response = buildResponse(sysCity);
        return response;
    }


    /**
     * 根据名字查找城市
     *
     * @return
     */
    @SystemControllerLog(description = "根据省份找所有城市")
    @RequestMapping(value = "/qCitysByPid/{pid}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryCitysByProvinceId(@PathVariable("pid") String pid) {

        Map<String, String> maps = sysCitySrvImpl.options(pid);
        Response response = buildResponse(maps);
        return response;

    }


}
