package com.cnfwsy.interfaces.controller.sys;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.model.init.helper.DictionaryHelper;
import com.cnfwsy.interfaces.bean.sys.SysDictionary;
import com.cnfwsy.interfaces.model.sys.ISysDictionarySrv;
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
public class SysDictionaryController extends BaseController<SysDictionary> {

    @Resource(name = "sysDictionarySrvImpl")
    private ISysDictionarySrv sysDictionarySrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/sysDictionary", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody SysDictionary sysDictionary) {
        sysDictionarySrvImpl.add(sysDictionary);
        Response response = buildResponse(sysDictionary);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/sysDictionary/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysDictionary sysDictionary = sysDictionarySrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(sysDictionary);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/sysDictionary/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        SysDictionary sysDictionary = null;
        sysDictionarySrvImpl.del(businessKey);
        Response response = buildResponse(sysDictionary);
        return response;
    }

    /**
     * @param sysDictionary
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/sysDictionary/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody SysDictionary sysDictionary) {
        sysDictionarySrvImpl.edit(sysDictionary);
        Response response = buildResponse(sysDictionary);
        return response;
    }

    /**
     * @param infos List<SysDictionary>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/sysDictionary", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<SysDictionary> infos) {
        sysDictionarySrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/sysDictionarys", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody SysDictionary sysDictionary) {
        Response response = buildSearchJsonMap(sysDictionary, request, sysDictionarySrvImpl);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "刷新字典表")
    @RequestMapping(value = "/sysDictionarys", method = RequestMethod.GET)
    public Response fresh() {
        SysDictionary sysDictionary = null;
        // 初始化数据字典信息
        DictionaryHelper.SINGLETONE.initDictionary();
        Response response = buildResponse(sysDictionary);
        return response;
    }


}
