package com.cnfwsy.interfaces.controller.ent;

import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.utils.Base64Utils;
import com.cnfwsy.interfaces.bean.ent.EntResume;
import com.cnfwsy.interfaces.model.ent.IEntResumeSrv;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

/**
 * 接口层
 * Created by zhangjh on 2016-7-28 0:36:59
 */
@RestController
public class EntResumeController extends BaseController<EntResume> {

    @Resource(name = "entResumeSrvImpl")
    private IEntResumeSrv entResumeSrvImpl;

    /**
     * 新增
     *
     * @return
     */
    @SystemControllerLog(description = "新增")
    @RequestMapping(value = "/entResume", method = RequestMethod.POST)
    public Response create(@Valid @RequestBody EntResume entResume) {

        entResumeSrvImpl.add(entResume);
        Response response = buildResponse(entResume);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "查询详细信息")
    @RequestMapping(value = "/entResume/{businessKey}", method = RequestMethod.GET)
    public Response queryByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EntResume entResume = entResumeSrvImpl.queryInfoByNatrualKey(businessKey);
        Response response = buildResponse(entResume);
        return response;

    }


    /**
     * @param businessKey
     * @return
     */
    @SystemControllerLog(description = "删除")
    @RequestMapping(value = "/entResume/{businessKey}", method = RequestMethod.DELETE)
    public Response deleteByBusinessKey(@PathVariable("businessKey") String businessKey) {

        EntResume entResume = null;
        entResumeSrvImpl.del(businessKey);
        Response response = buildResponse(entResume);
        return response;

    }

    /**
     * @param entResume
     * @return
     */
    @SystemControllerLog(description = "更新")
    @RequestMapping(value = "/entResume/{businessKey}", method = RequestMethod.PUT)
    @IgnoreSecurity
    public Response update(@PathVariable("businessKey") String businessKey,  /**@Valid*/@RequestBody EntResume entResume) {

        entResumeSrvImpl.edit(entResume);
        Response response = buildResponse(entResume);
        return response;

    }

    /**
     * @param infos List<EntResume>
     * @return
     */
    @SystemControllerLog(description = "批量更新")
    @RequestMapping(value = "/entResume", method = RequestMethod.PUT)
    public Response updateBatch(@RequestBody List<EntResume> infos) {

        entResumeSrvImpl.updateBatch(infos);
        Response response = buildResponse(infos);
        return response;

    }


    /**
     * @return 查询集合
     */
    @SystemControllerLog(description = "查询列表")
    @RequestMapping(value = "/entResumes", method = RequestMethod.POST)
    public Response search(HttpServletRequest request, @RequestBody EntResume entResume) {

        entResume.setCompanyId(Base64Utils.decode(entResume.getCompanyId()));
        Response response = buildSearchJsonMap(entResume, request, entResumeSrvImpl);
        return response;

    }

}
