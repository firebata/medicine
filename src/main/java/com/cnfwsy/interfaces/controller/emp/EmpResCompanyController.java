package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.interfaces.bean.emp.EmpResCompany;
import com.cnfwsy.interfaces.model.emp.IEmpResCompanySrv;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

/**
 * 接口层
 * Created by zhangjh on 2016-6-29 17:00:53
 */
@RestController
public class EmpResCompanyController extends BaseController<EmpResCompany> {

    @Resource(name = "empResCompanySrvImpl")
    private IEmpResCompanySrv empResCompanySrvImpl;


    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/empResCompany", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EmpResCompany empResCompany) {

        empResCompany.setCompanyId(new Random().nextInt(10) + "");
        empResCompanySrvImpl.add(empResCompany);
        Response response = buildResponse(empResCompany);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empResCompany/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpResCompany empResCompany = empResCompanySrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empResCompany);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empResCompany/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpResCompany empResCompany = null;
        empResCompanySrvImpl.del(businessKey);
        Response response = buildResponse(empResCompany);
        return response;

    }

    /**
     * @param empResCompany
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empResCompany/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpResCompany empResCompany) {

        empResCompanySrvImpl.edit(empResCompany);
        Response response = buildResponse(empResCompany);
        return response;

    }

    /**
     * @param infos List<EmpResCompany>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empResCompany", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EmpResCompany> infos) {

        empResCompanySrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empResCompanys", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpResCompany empResCompany) {

        Response response = buildSearchJsonMap(empResCompany, request, empResCompanySrvImpl);
        return response;

    }

}
