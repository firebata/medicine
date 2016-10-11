package com.cnfwsy.interfaces.controller.ent;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.utils.Base64Utils;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;
import com.cnfwsy.interfaces.model.ent.IEntJobCominfoSrv;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2016-09-12.
 */
@RestController
public class EntJobCompanyController extends BaseController<EntJobinfo> {

    @Autowired
    private IEntJobCominfoSrv entJobCominfoSrvImpl;

    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "首页职位展示，最热")
    @RequestMapping(value = "/entJobinfos/index/hot", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response jobIndex(HttpServletRequest request, @RequestBody EntJobinfo entJobinfo) {
        List<EntJobinfo> infos = entJobCominfoSrvImpl.queryHotJobs(entJobinfo);
        Response response = buildResponse(infos);
        return response;
    }

    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "首页职位展示,最新")
    @RequestMapping(value = "/entJobinfos/index/latest", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response jobLatest(HttpServletRequest request, @RequestBody EntJobinfo entJobinfo) {
        List<EntJobinfo> infos = entJobCominfoSrvImpl.queryLatestJobs(entJobinfo);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询职位列表-职位查询")
    @RequestMapping(value = "/qrjobs", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response searchjobs(@RequestBody EntJobinfo entJobinfo, HttpServletRequest request) {
        entJobinfo.setOnline(1);
        if (entJobinfo.getPayroll() != null && !entJobinfo.getPayroll().equals("")) {
            String payroll = entJobinfo.getPayroll();
            payroll = payroll.replace("k", "000");
            if (payroll.contains("-")) {
                String[] pay = payroll.split("-");
                entJobinfo.setSalaryStart(Integer.parseInt(pay[0]));
                entJobinfo.setSalaryEnd(Integer.parseInt(pay[1]));
            } else if (payroll.contains("2000")) {
                entJobinfo.setSalaryStart(0);
                entJobinfo.setSalaryEnd(2000);
            }
            if (payroll.contains("50000")) {
                entJobinfo.setSalaryStart(50000);
                entJobinfo.setSalaryEnd(100000000);
            }
        }
        entJobinfo.setPayroll("");
        if (StringUtils.isNotBlank(entJobinfo.getCompanyId())) {
            String companyId = Base64Utils.decode(entJobinfo.getCompanyId());
            entJobinfo.setCompanyId(companyId);
        }
        if (StringUtils.isNotBlank(entJobinfo.getJobId())) {
            String jobId = Base64Utils.decode(entJobinfo.getJobId());
            entJobinfo.setJobId(jobId);
        }
        Response response = buildSearchJsonMap(entJobinfo, request, entJobCominfoSrvImpl);
//        List<EntJobinfo> infos = entJobCominfoSrvImpl.searchInfos(entJobinfo);
//        Response response = buildResponse(infos);
        return response;
    }


}
