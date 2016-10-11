package com.cnfwsy.interfaces.controller.sys;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.annotation.SystemControllerLog;
import com.cnfwsy.core.bean.Response;
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.interfaces.bean.sys.FeedBackVo;
import com.cnfwsy.interfaces.model.sys.IFeedBackSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 说明:
 * Created by zhangjh on 2016-07-21.
 */
@RestController
public class FeedBackController extends BaseController<FeedBackVo> {

    @Autowired
    private IFeedBackSrv feedBackSrv;

    @SystemControllerLog(description = "新增留言")
    @RequestMapping(value = "/user/savefeedback", method = RequestMethod.POST)
    @IgnoreSecurity
    public Response create(@RequestBody FeedBackVo feedBackVo) {
        feedBackSrv.add(feedBackVo);
        Response response = buildResponse(feedBackVo);
        return response;
    }

}
