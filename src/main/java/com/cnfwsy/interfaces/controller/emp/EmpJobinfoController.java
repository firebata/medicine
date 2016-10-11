package com.cnfwsy.interfaces.controller.emp;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.bean.SysAccount;
import com.cnfwsy.core.constant.ReturnCodeConstant;
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.exception.BusinessException;
import com.cnfwsy.core.utils.Base64Utils;
import com.cnfwsy.interfaces.bean.emp.EmpEmployee;
import com.cnfwsy.interfaces.bean.emp.EmpJobinfo;
import com.cnfwsy.interfaces.bean.ent.EntResume;
import com.cnfwsy.interfaces.model.emp.IEmpEmployeeSrv;
import com.cnfwsy.interfaces.model.emp.IEmpJobinfoSrv;
import com.cnfwsy.interfaces.model.ent.IEntResumeSrv;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

import static com.cnfwsy.core.api.UserSessionUtils.getUserFromSession;
import static com.cnfwsy.core.api.UserSessionUtils.judgeIsEmpAccount;

/**
 * 接口层
 * Created by zhangjh on 2016-7-28 0:36:59
 */
@RestController
public class EmpJobinfoController extends BaseController<EmpJobinfo> {

    @Resource(name = "empJobinfoSrvImpl")
    private IEmpJobinfoSrv empJobinfoSrvImpl;
    @Resource(name = "entResumeSrvImpl")
    private IEntResumeSrv entResumeSrvImpl;
    @Resource(name = "empEmployeeSrvImpl")
    private IEmpEmployeeSrv empEmployeeSrvImpl;

    /**
     * 投递简历
     *
     * @return
     */
    @SystemControllerLog(description = "投递简历")
    @RequestMapping(value = "/empJobinfo", method = RequestMethod.POST)
    public Response create(@Valid @RequestBody EmpJobinfo empJobinfo) {

        Response response = new Response();
        boolean isEmpAccout = judgeIsEmpAccount();
        if (isEmpAccout) {
            //个人信息
            SysAccount sysAccount = getUserFromSession();
            EmpEmployee empEmployee = empEmployeeSrvImpl.queryInfoByAccountId(sysAccount.getAccountId());
            if (null == empEmployee) {
                throw new BusinessException(ReturnCodeConstant.NOT_FINISH_RESUME);
            }
            String companyId = Base64Utils.decode(empJobinfo.getCompanyId());
            String jobId = Base64Utils.decode(empJobinfo.getJobId());
            empJobinfo.setCompanyId(companyId);
            empJobinfo.setJobId(jobId);
            empJobinfo.setEmployeeId(empEmployee.getEmployeeId());
            empJobinfo.setaccountId(sysAccount.getAccountId());
            //重复申请
            int repeat = 0;
            repeat = empJobinfoSrvImpl.listFilteredInfosCounts(empJobinfo);
            if (repeat > 0) {
                response = response.failure(ReturnCodeConstant.REPEAT_APPLY_JOB);
                return response;
            }
            empJobinfoSrvImpl.add(empJobinfo);

            EntResume entResume = new EntResume();
            entResume.setAccountId(empJobinfo.getaccountId());
            entResume.setCompanyId(empJobinfo.getCompanyId());
            entResume.setJobId(empJobinfo.getJobId());
            entResume.setEmployeeId(empJobinfo.getEmployeeId());
            entResumeSrvImpl.add(entResume);
            response = buildResponse(empJobinfo);
        } else {
            response = response.failure(ReturnCodeConstant.USER_IS_NOT_LOGINED);
        }
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/empJobinfo/{businessKey}", method = RequestMethod.GET)
    @IgnoreSecurity
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpJobinfo empJobinfo = empJobinfoSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(empJobinfo);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/empJobinfo/{businessKey}", method = RequestMethod.DELETE)
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EmpJobinfo empJobinfo = null;
        empJobinfoSrvImpl.del(businessKey);
        Response response = buildResponse(empJobinfo);
        return response;

    }

    /**
     * @param empJobinfo
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/empJobinfo/{businessKey}", method = RequestMethod.PUT)
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EmpJobinfo empJobinfo) {

        empJobinfoSrvImpl.edit(empJobinfo);
        Response response = buildResponse(empJobinfo);
        return response;

    }

    /**
     * @param infos List<EmpJobinfo>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/empJobinfo", method = RequestMethod.PUT)
    public Response updateBatch(@RequestBody List<EmpJobinfo> infos) {

        empJobinfoSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/empJobinfos", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response search(HttpServletRequest request, @RequestBody EmpJobinfo empJobinfo) {
        Response response = buildSearchJsonMap(empJobinfo, request, empJobinfoSrvImpl);
        return response;
    }

}
