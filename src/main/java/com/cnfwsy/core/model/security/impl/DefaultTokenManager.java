package com.cnfwsy.core.model.security.impl;

import com.cnfwsy.core.model.security.TokenManager;
import com.cnfwsy.core.utils.UuidGeneratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 说明:需要注意的是，如果需要做到分布式集群，
 * 建议基于Redis提供一个实现类，将token存储到Redis中，并利用Redis与生俱来的特性，做到token的分布式一致性。
 * Created by zhangjh on 2016-05-27.
 */
@Component("tokenManager")
public class DefaultTokenManager implements TokenManager {

    private static Map<String, String> tokenMap = new ConcurrentHashMap<>();

    @Override
    public String createToken(String userId) {
        String token = UuidGeneratorUtils.getRandomUUID();
        tokenMap.put(token, userId);
        return token;
    }

    @Override
    public boolean checkToken(String token) {
        return !StringUtils.isEmpty(token) && tokenMap.containsKey(token);
    }

    @Override
    public boolean removeToken(String token) {
        if (StringUtils.isNotBlank(token)) {
            tokenMap.remove(token);
        }
        return true;
    }
}
