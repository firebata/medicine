package com.cnfwsy.token.interceptor;

import com.cnfwsy.core.annotation.ForbidRepeatSubmit;
import com.cnfwsy.core.api.UserSessionUtils;
import com.cnfwsy.token.processor.SubmitTokenProcessor;
import com.cnfwsy.core.bean.SysAccount;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 说明:防止重复提交拦截器
 * Created by zhangjh on 2016-06-30.
 */
public class ForbidRepeatSubmitInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = Logger.getLogger(ForbidRepeatSubmitInterceptor.class);

    /**
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param handler  Object
     * @return boolean
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        SysAccount user = UserSessionUtils.getUserFromSession(request.getSession());
        if (user != null) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            ForbidRepeatSubmit annotation = method.getAnnotation(ForbidRepeatSubmit.class);
            if (annotation != null) {
                boolean needSaveSession = annotation.needSaveToken();
                if (needSaveSession) {
                    SubmitTokenProcessor.getInstance().saveToken(request);
//                    request.getSession(false).setAttribute("token", SubmitTokenProcessor.getInstance().generateToken(request));
                }

                boolean needRemoveSession = annotation.needRemoveToken();
                if (needRemoveSession) {
                    if (SubmitTokenProcessor.getInstance().isTokenValid(request)/*isRepeatSubmit(request)*/) {
                        logger.warn("please don't repeat submit,[user:" + user.getName() + ",url:" + request.getServletPath() + "]");
                        return false;
                    }
                    SubmitTokenProcessor.getInstance().resetToken(request);
//                    request.getSession(false).removeAttribute("token");
                }
            }
        }
        return true;
    }
//
//    private boolean isRepeatSubmit(HttpServletRequest request) {
//        String serverToken = (String) request.getSession(false).getAttribute("token");
//        if (serverToken == null) {
//            return true;
//        }
//        String clinetToken = request.getParameter("token");
//        if (clinetToken == null) {
//            return true;
//        }
//        if (!serverToken.equals(clinetToken)) {
//            return true;
//        }
//        return false;
//    }

}