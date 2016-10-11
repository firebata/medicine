package com.cnfwsy.core.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 说明:
 * Created by zhangjh on 2015/12/1.
 */
public class LoginInterceptor implements HandlerInterceptor {
    public static List<String> IGNORE_URIS;
    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    /**
     * 还在完善:开发时，注释掉，直接返回true
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //
        String requestUri = request.getRequestURI();
        int endIndex = requestUri.indexOf("/", 1) == -1 ? requestUri.length() : requestUri.indexOf("/", 1);
        String parentUrl = requestUri.substring(0, endIndex);
/*

        if (!IGNORE_URIS.contains(requestUri) && !IGNORE_URIS.contains(parentUrl)) {
            SysAccount account = UserSessionUtils.getUserFromSession(request.getSession());
            if (null == account) {
                throw new AuthorizationException();
            } else {

            }
        }
*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


    }


}
