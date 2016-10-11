package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.emp.EmpResSkill;
import com.cnfwsy.interfaces.model.emp.IEmpResSkillSrv;
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
public class EmpResSkillController extends BaseController<EmpResSkill> {

    @Resource(name = "empResSkillSrvImpl")
    private IEmpResSkillSrv empResSkillSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/empResSkill", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EmpResSkill empResSkill) {
        empResSkillSrvImpl.add(empResSkill);
        Response response = buildResponse(empResSkill);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empResSkill/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResSkill empResSkill = empResSkillSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empResSkill);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empResSkill/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResSkill empResSkill = null;
        empResSkillSrvImpl.del(businessKey);
        Response response = buildResponse(empResSkill);
        return response;
    }

    /**
     * @param empResSkill
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empResSkill/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpResSkill empResSkill) {
        empResSkillSrvImpl.edit(empResSkill);
        Response response = buildResponse(empResSkill);
        return response;
    }

    /**
     * @param infos List<EmpResSkill>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empResSkill", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EmpResSkill> infos) {
        empResSkillSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empResSkills", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpResSkill empResSkill) {
        Response response = buildSearchJsonMap(empResSkill, request, empResSkillSrvImpl);
        return response;
    }

}
