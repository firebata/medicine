package com.cnfwsy.interfaces.controller.ent;

import com.cnfwsy.core.annotation.IgnoreSecurity;
import com.cnfwsy.core.controller.BaseController;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liangminglong on 2016/7/24.
 */
@Controller
public class EntJobListController extends BaseController<EntJobinfo> {

    /**
     * 首页跳转职位搜索页面
     *
     * @param jobName
     * @param request
     * @param mm
     * @return
     */
    @RequestMapping(value = "/entJobList/{jobName}", method = RequestMethod.GET)
    @IgnoreSecurity
    public String loadEntJobPage(@PathVariable("jobName") String jobName, HttpServletRequest request, ModelMap mm) {
        String labelWords = jobName;// request.getParameter("labelWords");

        String gj = request.getParameter("gj");
        String xl = request.getParameter("xl");
        String yx = request.getParameter("yx");
        String gx = request.getParameter("gx");
        String st = request.getParameter("st");
        String ct = request.getParameter("ct");
        String xj = request.getParameter("xj");
        String com = request.getParameter("com");
        mm.put("labelWords", labelWords);

        mm.put("gj", gj);
        mm.put("xl", xl);
        mm.put("yx", yx);
        mm.put("gx", gx);
        mm.put("st", st);
        mm.put("ct", ct);
        mm.put("xj", xj);
        mm.put("com", com);
        mm.put("isFromIndex", 1);

        return "company/search_list";
    }


}
