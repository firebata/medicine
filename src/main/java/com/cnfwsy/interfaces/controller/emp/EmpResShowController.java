package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.bean.emp.EmpResShow;
import com.cnfwsy.interfaces.model.emp.IEmpResShowSrv;
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
public class EmpResShowController extends BaseController<EmpResShow> {

    @Resource(name = "empResShowSrvImpl")
    private IEmpResShowSrv empResShowSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/empResShow", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@Valid @RequestBody EmpResShow empResShow) {
        empResShowSrvImpl.add(empResShow);
        Response response = buildResponse(empResShow);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empResShow/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResShow empResShow = empResShowSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empResShow);
        return response;
    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empResShow/{businessKey}", method = RequestMethod.DELETE)
    @IgnoreSecurity
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {
        EmpResShow empResShow = null;
        empResShowSrvImpl.del(businessKey);
        Response response = buildResponse(empResShow);
        return response;
    }

    /**
     * @param empResShow
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empResShow/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpResShow empResShow) {
        empResShowSrvImpl.edit(empResShow);
        Response response = buildResponse(empResShow);
        return response;
    }

    /**
     * @param infos List<EmpResShow>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empResShow", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response updateBatch(@RequestBody List<EmpResShow> infos) {
        empResShowSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;
    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empResShows", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpResShow empResShow) {
        Response response = buildSearchJsonMap(empResShow, request, empResShowSrvImpl);
        return response;
    }

}
