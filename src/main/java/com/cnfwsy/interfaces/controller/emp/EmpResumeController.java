package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.emp.EmpResume;
import com.cnfwsy.interfaces.model.emp.IEmpResumeSrv;
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
public class EmpResumeController extends BaseController<EmpResume> {

    @Resource(name = "empResumeSrvImpl")
    private IEmpResumeSrv empResumeSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/empResume", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EmpResume empResume) {
        empResumeSrvImpl.add(empResume);
        Response response = buildResponse(empResume);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empResume/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResume empResume = empResumeSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empResume);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empResume/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResume empResume = null;
        empResumeSrvImpl.del(businessKey);
        Response response = buildResponse(empResume);
        return response;
    }

    /**
     * @param empResume
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empResume/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpResume empResume) {
        empResumeSrvImpl.edit(empResume);
        Response response = buildResponse(empResume);
        return response;
    }

    /**
     * @param infos List<EmpResume>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empResume", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EmpResume> infos) {
        empResumeSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empResumes", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpResume empResume) {
        Response response = buildSearchJsonMap(empResume, request, empResumeSrvImpl);
        return response;
    }

}
