package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.emp.EmpResEdu;
import com.cnfwsy.interfaces.model.emp.IEmpResEduSrv;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 接口层
 * Created by zhangjh on 2016-7-1 10:50:07
 */
@RestController
public class EmpResEduController extends BaseController<EmpResEdu> {

    @Resource(name = "empResEduSrvImpl")
    private IEmpResEduSrv empResEduSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/empResEdu", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EmpResEdu empResEdu) {

        empResEduSrvImpl.add(empResEdu);
        Response response = buildResponse(empResEdu);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empResEdu/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpResEdu empResEdu = empResEduSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empResEdu);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empResEdu/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpResEdu empResEdu = null;
        empResEduSrvImpl.del(businessKey);
        Response response = buildResponse(empResEdu);
        return response;

    }

    /**
     * @param empResEdu
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empResEdu/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpResEdu empResEdu) {

        empResEduSrvImpl.edit(empResEdu);
        Response response = buildResponse(empResEdu);
        return response;

    }

    /**
     * @param infos List<EmpResEdu>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empResEdu", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EmpResEdu> infos) {

        empResEduSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empResEdus", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpResEdu empResEdu) {

        Response response = buildSearchJsonMap(empResEdu, request, empResEduSrvImpl);
        return response;

    }

}
