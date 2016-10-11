package com.geetest.sdk.java.web.demo;

/**
 * GeetestWeb配置文件
 */
public class GeetestConfig {

    // 填入自己的captcha_id和private_key
    private static final String captcha_id = "19233e1e9b909606741cd32dd2361370";
    private static final String private_key = "5fb6e428e2df2505c707ffaa4b856080";

    public static final String getCaptcha_id() {
        return captcha_id;
    }

    public static final String getPrivate_key() {
        return private_key;
    }

}
