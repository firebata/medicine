package com.cnfwsy.interfaces.thread;

import com.cnfwsy.core.api.WebContext;
import com.cnfwsy.core.utils.BaiduZZUtils;
import com.cnfwsy.core.utils.Base64Utils;
import com.cnfwsy.core.utils.DateUtils;
import com.cnfwsy.core.utils.FreeMarkerUtils;
import com.cnfwsy.interfaces.bean.ent.EntJobinfo;
import com.cnfwsy.interfaces.model.ent.IEntJobCominfoSrv;
import com.cnfwsy.interfaces.model.ent.IEntJobinfoSrv;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 说明:每天生成
 * Created by zhangjh on 2016-09-09.
 */
@Component
public class StaticJobPageThread {

    private static String current_date = "1970-01-20";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IEntJobCominfoSrv entJobCominfoSrvImpl;

    @Resource(name = "entJobinfoSrvImpl")
    private IEntJobinfoSrv entJobinfoSrvImpl;

    @Scheduled(cron = "* * *  * * ? ")
    public void run() {
        String now = DateUtils.SINGLETONE.getYY_MM_DD();
        if (!now.equals(current_date)) {
            logger.info("开始生成" + now + "的职位页面");
            createJobPage(now);
        }
    }

    private void createJobPage(String now) {
        current_date = now;
        List<String> jobids = entJobCominfoSrvImpl.queryJobsIdsByDate(now);
//        String[] parameters = new String[jobids.size()];
//        int index = 0;
        for (String jobid : jobids) {
            try {
                String businessKey = Base64Utils.encode(jobid);
                EntJobinfo entJobinfo = entJobinfoSrvImpl.queryInfoById(businessKey);
                Map<String, Object> rootMap = new HashMap();

                rootMap.put("entJobinfo", entJobinfo);

                String webAppRootKey = WebContext.getRealPath();
                File dic = new File(webAppRootKey + "job/");
                if (!dic.exists()) {
                    dic.mkdirs();
                }
                String suffix = "job/" + businessKey + ".html";

//                parameters[index] = "http://www.zzlinks.cn/"+  suffix;
                String parameter = "http://www.zzlinks.cn/" + suffix;
//                index++;
                BaiduZZUtils.post(BaiduZZUtils.postUrl, parameter);
                File file = new File(webAppRootKey + suffix);

                if (file.exists()) {
                    continue;
                }
                FreeMarkerUtils.SINGLETONE.printFile("job.ftl", null, rootMap, file);

            } catch (TemplateException e) {
                logger.error("生成职位id为：" + jobid + "的静态页面出错", e);
            } catch (IOException e) {
                logger.error("生成职位id为：" + jobid + "的静态页面出错", e);
            } catch (Exception e) {
                logger.error("生成职位id为：" + jobid + "的静态页面出错", e);
            }
        }


//        BaiduZZUtils.post(BaiduZZUtils.postUrl, parameters);
    }
}
