package com.cnfwsy.interfaces.model.sys.impl;

import com.cnfwsy.core.api.WebContext;
import com.cnfwsy.core.utils.FreeMarkerUtils;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;
import com.cnfwsy.interfaces.model.ent.IEntJobCominfoSrv;
import com.cnfwsy.interfaces.model.ent.IEntJobinfoSrv;
import com.cnfwsy.interfaces.model.sys.IRefreshServ;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明:
 * Created by zhangjh on 2016-08-29.
 */
@Service("refreshServ")
public class RefreshServImpl implements IRefreshServ {
    @Resource(name = "entJobinfoSrvImpl")
    private IEntJobinfoSrv entJobinfoSrvImpl;
    @Autowired
    private IEntJobCominfoSrv entJobCominfoSrvImpl;

    @Override
    public void refreshIdx() throws IOException, TemplateException {
        List<EntJobinfo> hotJobs = entJobCominfoSrvImpl.queryHotJobs(null);
        List<EntJobinfo> latestJobs = entJobCominfoSrvImpl.queryLatestJobs(null);


        Map<String, Object> rootMap = new HashMap();
        rootMap.put("hotJobs", hotJobs);
        rootMap.put("latestJobs", latestJobs);

        String webAppRootKey = WebContext.getRealPath();
        File file = new File(webAppRootKey + "index.html");
        FreeMarkerUtils.SINGLETONE.printFile("index.html", null, rootMap, file);
    }
}
