package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.api.UserSessionUtils;
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.emp.EmpEmployee;
import com.cnfwsy.interfaces.model.emp.IEmpEmployeeSrv;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 接口层
 * Created by zhangjh on 2016-6-27 10:05:24
 */
@RestController
public class EmpEmployeeController extends BaseController<EmpEmployee> {

    @Resource(name = "empEmployeeSrvImpl")
    private IEmpEmployeeSrv empEmployeeSrvImpl;


    /**
     * @return
     */
    @SystemControllerLog(description = "跳转简历")
    @RequestMapping(value = "/preview", method = RequestMethod.GET)
//    @IgnoreSecurity
    public ModelAndView turnToPreview(ModelMap modelMap) {

        String employeeId = UserSessionUtils.getBussIdSession();
        modelMap.put("employeeId", employeeId);
        ModelAndView mm = new ModelAndView("employee/preview", modelMap);

        return mm;
    }


    /**
     * @return
     */
    @SystemControllerLog(description = "显示简历详细")
    @RequestMapping(value = "resume/preview/{usrid}", method = RequestMethod.GET)
    public ModelAndView resume_preview(ModelMap modelMap) {
        String employeeId = UserSessionUtils.getBussIdSession();
        modelMap.put("employeeId", employeeId);
        ModelAndView mm = new ModelAndView("employee/preview", modelMap);

        return mm;
    }



    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/empEmployee", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EmpEmployee empEmployee) {

        empEmployeeSrvImpl.add(empEmployee);
        Response response = buildResponse(empEmployee);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empEmployee/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpEmployee empEmployee = empEmployeeSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empEmployee);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empEmployee/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpEmployee empEmployee = null;
        empEmployeeSrvImpl.del(businessKey);
        Response response = buildResponse(empEmployee);
        return response;

    }

    /**
     * @param empEmployee
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empEmployee/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpEmployee empEmployee) {

        empEmployeeSrvImpl.edit(empEmployee);
        Response response = buildResponse(empEmployee);
        return response;

    }

    /**
     * @param infos List<EmpEmployee>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empEmployee", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EmpEmployee> infos) {

        empEmployeeSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empEmployees", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpEmployee empEmployee) {

        Response response = buildSearchJsonMap(empEmployee, request, empEmployeeSrvImpl);
        return response;

    }

    /**
     * @return
     */
    @SystemControllerLog(description = "显示简历页面")
    @RequestMapping(value = "/jianli", method = RequestMethod.GET)
    public ModelAndView turnToVitaeview(ModelMap modelMap) {
        String employee_id = UserSessionUtils.getBussIdSession();
        modelMap.put("employee_id", employee_id);
        ModelAndView mm = new ModelAndView("/employee/curriculum_vitae");
        return mm;
    }


}
