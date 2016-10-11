package com.cnfwsy.core.init;

import com.cnfwsy.core.api.SpringContextHolder;
import com.cnfwsy.core.filter.LoginInterceptor;
import com.cnfwsy.core.thread.SystemInitThread;
import com.cnfwsy.core.utils.PropertiesUtils;
import com.cnfwsy.interfaces.model.sys.ICreateHotJobsTableSrc;
import com.cnfwsy.interfaces.model.sys.IRefreshServ;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.util.Arrays;

/**
 * 启动加载数据字段等信息
 *
 * @author: zhangjh
 * @version:2015年5月6日 下午2:49:25
 */
public class InitSystemInfoListener implements ServletContextListener {
    private static Logger logger = LoggerFactory.getLogger(InitSystemInfoListener.class);
//    static ScheduledExecutorService cachedThreadPool = Executors.newScheduledThreadPool(10);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        initSystemPropertis();
        initDictionary();
//        startNoGenerator();
        createHotsJobTable();
        createIdx();
    }

    private void createHotsJobTable() {
        ICreateHotJobsTableSrc createHotJobsTableSrc = SpringContextHolder.getBean("createHotJobsTableSrc");
        createHotJobsTableSrc.createHosJobsTable();
    }

    private void createIdx() {
        IRefreshServ refreshServ = SpringContextHolder.getBean("refreshServ");
        try {
            refreshServ.refreshIdx();
        } catch (IOException e) {
            logger.info("创建首页失败", e);
        } catch (TemplateException e) {
            logger.info("创建首页失败", e);
        }
    }

    /**
     * 字典表
     */
    private void initDictionary() {
        new Thread(new SystemInitThread()).start();
    }

    /**
     * 忽略权限url
     */
    private void initSystemPropertis() {
        try {
            String uirStr = PropertiesUtils.getString("ig_uris");
            String[] uirArr = uirStr.split(",");
            LoginInterceptor.IGNORE_URIS = Arrays.asList(uirArr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 主键生成
     */
   /* private void startNoGenerator() {

        INoGenerator companyNoGenerator = SpringContextHolder.getBean("companyNoGenerator");
        cachedThreadPool.scheduleAtFixedRate(companyNoGenerator, 0, 100, TimeUnit.MILLISECONDS);

        INoGenerator employeeNoGenerator = SpringContextHolder.getBean("employeeNoGenerator");
        cachedThreadPool.scheduleAtFixedRate(employeeNoGenerator, 0, 100, TimeUnit.MILLISECONDS);

        INoGenerator resumeNoGenerator = SpringContextHolder.getBean("resumeNoGenerator");
        cachedThreadPool.scheduleAtFixedRate(resumeNoGenerator, 0, 100, TimeUnit.MILLISECONDS);


        INoGenerator verificationCodeGenerator = SpringContextHolder.getBean("verificationCodeGenerator");
        cachedThreadPool.scheduleAtFixedRate(verificationCodeGenerator, 0, 100, TimeUnit.MILLISECONDS);

        INoGenerator accountNoGenerator = SpringContextHolder.getBean("accountNoGenerator");
        cachedThreadPool.scheduleAtFixedRate(accountNoGenerator, 0, 100, TimeUnit.MILLISECONDS);

        INoGenerator entJobNoGenerator = SpringContextHolder.getBean("entJobNoGenerator");
        cachedThreadPool.scheduleAtFixedRate(entJobNoGenerator, 0, 100, TimeUnit.MILLISECONDS);

        INoGenerator empExpectNoGenerator = SpringContextHolder.getBean("empExpectNoGenerator");
        cachedThreadPool.scheduleAtFixedRate(empExpectNoGenerator, 0, 100, TimeUnit.MILLISECONDS);

    }
*/
}
