package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.api.UserSessionUtils;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.interfaces.bean.emp.EmpResExpect;
import com.cnfwsy.interfaces.model.emp.IEmpResExpectSrv;
import com.cnfwsy.serialnumber.generator.INoGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Random;

/**
 * 接口层
 * Created by zhangjh on 2016-6-28 16:46:35
 */
@RestController
public class EmpResExpectController extends BaseController<EmpResExpect> {

    @Resource(name = "empResExpectSrvImpl")
    private IEmpResExpectSrv empResExpectSrvImpl;

    @Autowired
    private INoGenerator empExpectNoGenerator;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/empResExpect", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EmpResExpect empResExpect) {
        empResExpect.setExpectId(empExpectNoGenerator.offer());
        String employee_id = UserSessionUtils.getBussIdSession();
        empResExpect.setEmployeeId(Integer.parseInt(employee_id));
        empResExpect.setResumeId(employee_id);
        empResExpectSrvImpl.add(empResExpect);
        Response response = buildResponse(empResExpect);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empResExpect/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpResExpect empResExpect = empResExpectSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empResExpect);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empResExpect/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpResExpect empResExpect = null;
        empResExpectSrvImpl.del(businessKey);
        Response response = buildResponse(empResExpect);
        return response;

    }

    /**
     * @param empResExpect
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empResExpect/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpResExpect empResExpect) {


        empResExpectSrvImpl.edit(empResExpect);
        Response response = buildResponse(empResExpect);
        return response;

    }

    /**
     * @param infos List<EmpResExpect>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empResExpect", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EmpResExpect> infos) {

        empResExpectSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empResExpects", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpResExpect empResExpect) {

        Response response = buildSearchJsonMap(empResExpect, request, empResExpectSrvImpl);
        return response;

    }

    public static void main(String[] args) {
        System.out.println(new Random().nextInt(20));
    }

}
