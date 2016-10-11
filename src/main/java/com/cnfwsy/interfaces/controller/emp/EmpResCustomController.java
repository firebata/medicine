package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.emp.EmpResCustom;
import com.cnfwsy.interfaces.model.emp.IEmpResCustomSrv;
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
public class EmpResCustomController extends BaseController<EmpResCustom> {

    @Resource(name = "empResCustomSrvImpl")
    private IEmpResCustomSrv empResCustomSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/empResCustom", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EmpResCustom empResCustom) {
        //先删除
        empResCustomSrvImpl.del(empResCustom.getResumeId() + "");
        //再增加
        empResCustomSrvImpl.add(empResCustom);
        Response response = buildResponse(empResCustom);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empResCustom/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResCustom empResCustom = empResCustomSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empResCustom);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empResCustom/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResCustom empResCustom = null;
        empResCustomSrvImpl.del(businessKey);
        Response response = buildResponse(empResCustom);
        return response;
    }

    /**
     * @param empResCustom
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empResCustom/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpResCustom empResCustom) {
        empResCustomSrvImpl.edit(empResCustom);
        Response response = buildResponse(empResCustom);
        return response;
    }

    /**
     * @param infos List<EmpResCustom>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empResCustom", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EmpResCustom> infos) {
        empResCustomSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empResCustoms", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpResCustom empResCustom) {
        Response response = buildSearchJsonMap(empResCustom, request, empResCustomSrvImpl);
        return response;
    }

}
