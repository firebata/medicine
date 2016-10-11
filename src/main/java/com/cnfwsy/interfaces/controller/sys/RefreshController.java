package com.cnfwsy.interfaces.controller.sys;

import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.interfaces.model.sys.IRefreshServ;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 说明:
 * Created by zhangjh on 2016-08-29.
 */
@RestController
public class RefreshController {

    @Resource(name = "refreshServ")
    private IRefreshServ refreshServ;


    /**
     * @return
     */
    @SystemControllerLog(description = "重新生成首页")
    @RequestMapping(value = "/refresh_idx", method = RequestMethod.GET)
    public Response queryByBusinessKey() throws IOException, TemplateException {

        refreshServ.refreshIdx();
        Response response = new Response().sucess(null);

        return response;
    }

}
