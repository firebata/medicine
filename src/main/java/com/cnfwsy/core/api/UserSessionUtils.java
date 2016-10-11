package com.cnfwsy.core.api;

import com.cnfwsy.core.bean.SysAccount;
import com.cnfwsy.core.constant.CommonConstant;
import com.cnfwsy.core.constant.ReturnCodeConstant;
import com.cnfwsy.core.exception.AuthorizationException;
import com.cnfwsy.core.exception.BusinessException;

import javax.servlet.http.HttpSession;

/**
 * 用户工具类
 *
 * @author zhangjh
 */
public class UserSessionUtils {

    public static final String CURRENT_USER = "current_user";

    /**
     * 从Session获取当前用户信息
     *
     * @return
     */
    public static SysAccount getUserFromSession() {
        HttpSession session = WebContext.getRequest().getSession();
        return getUserFromSession(session);
    }


    /**
     * 获取账号的业务id：企业id或者个人信息id
     *
     * @return
     */
    public static String getBussIdSession() {
        SysAccount account = getUserFromSession();
        if (null == account) {
            throw new AuthorizationException();
        }
        String bussId = account.getBussId();
        return bussId.toString();
    }

    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static SysAccount getUserFromSession(HttpSession session) {
        SysAccount result = null;
        if (null != session) {
            Object attribute = session.getAttribute(CURRENT_USER);
            result = attribute == null ? null : (SysAccount) attribute;
        }
        return result;
    }

    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, SysAccount user) {
        session.setAttribute(CURRENT_USER, user);
    }


    public static void removeUserFromSession(HttpSession session) {
        session.removeAttribute(CURRENT_USER);//用户信息
    }

    /**
     * 是否为企业账号
     *
     * @return
     */
    public static boolean judgeIsEntAccount() {
        SysAccount account = getUserFromSession();
        int type_id = account.getTypeId();
        if (type_id == CommonConstant.ACCOUNT_TYPE_PER) {
            throw new BusinessException(ReturnCodeConstant.ACCOUNT_ISNOT_ENT);
        }
        return true;
    }

    /**
     * 是否为个人账号
     *
     * @return
     */
    public static boolean judgeIsEmpAccount() {
        boolean result = true;
        SysAccount account = getUserFromSession();
        if (null == account || account.getTypeId() == CommonConstant.ACCOUNT_TYPE_COM) {
            result = false;
        }
        return result;
    }

    /**
     * 是否为用户自己的企业
     *
     * @param companyId
     */
    public static boolean judgeIsSelf(String companyId) {
        SysAccount account = getUserFromSession();
        String bussId = account.getBussId();
        if (null != bussId) {
            if (!bussId.toString().equals(companyId.trim())) {
                throw new BusinessException(ReturnCodeConstant.CANNOT_VIEW_OTHER_ENT);
            }
        } else {
//            throw new BusinessException(ReturnCodeConstant.CANNOT_VIEW_OTHER_ENT);
        }

        return true;
    }
}
