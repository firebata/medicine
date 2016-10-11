package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.emp.EmpResProject;
import com.cnfwsy.interfaces.model.emp.IEmpResProjectSrv;
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
public class EmpResProjectController extends BaseController<EmpResProject> {

    @Resource(name = "empResProjectSrvImpl")
    private IEmpResProjectSrv empResProjectSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/empResProject", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EmpResProject empResProject) {
        empResProjectSrvImpl.add(empResProject);
        Response response = buildResponse(empResProject);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empResProject/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResProject empResProject = empResProjectSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empResProject);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empResProject/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResProject empResProject = null;
        empResProjectSrvImpl.del(businessKey);
        Response response = buildResponse(empResProject);
        return response;
    }

    /**
     * @param empResProject
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empResProject/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpResProject empResProject) {
        empResProjectSrvImpl.edit(empResProject);
        Response response = buildResponse(empResProject);
        return response;
    }

    /**
     * @param infos List<EmpResProject>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empResProject", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EmpResProject> infos) {
        empResProjectSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empResProjects", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpResProject empResProject) {
        Response response = buildSearchJsonMap(empResProject, request, empResProjectSrvImpl);
        return response;
    }

}
