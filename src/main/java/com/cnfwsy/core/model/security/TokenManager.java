package com.cnfwsy.core.model.security;

/**
 * 说明:
 * Created by zhangjh on 2016-05-27.
 */
public interface TokenManager {

    String createToken(String userId);

    boolean checkToken(String token);

    boolean removeToken(String token);
}
