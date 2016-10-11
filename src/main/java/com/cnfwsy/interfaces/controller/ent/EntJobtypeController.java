package com.cnfwsy.interfaces.controller.ent;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.ent.EntJobtype;
import com.cnfwsy.interfaces.model.ent.IEntJobtypeSrv;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 接口层
 * Created by zhangjh on 2016-7-20 15:21:10
 */
@RestController
public class EntJobtypeController extends BaseController<EntJobtype> {

    @Resource(name = "entJobtypeSrvImpl")
    private IEntJobtypeSrv entJobtypeSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/entJobtype", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EntJobtype entJobtype) {

        entJobtypeSrvImpl.add(entJobtype);
        Response response = buildResponse(entJobtype);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/entJobtype/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EntJobtype entJobtype = entJobtypeSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(entJobtype);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/entJobtype/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EntJobtype entJobtype = null;
        entJobtypeSrvImpl.del(businessKey);
        Response response = buildResponse(entJobtype);
        return response;

    }

    /**
     * @param entJobtype
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/entJobtype/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EntJobtype entJobtype) {

        entJobtypeSrvImpl.edit(entJobtype);
        Response response = buildResponse(entJobtype);
        return response;

    }

    /**
     * @param infos List<EntJobtype>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/entJobtype", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EntJobtype> infos) {

        entJobtypeSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/entJobtypes", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EntJobtype entJobtype) {

        Response response = buildSearchJsonMap(entJobtype, request, entJobtypeSrvImpl);
        return response;

    }

}
