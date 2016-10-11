package com.cnfwsy.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * 说明:百度链接提交
 * Created by zhangjh on 2016-09-14.
 */
public class BaiduZZUtils {

    private static Logger logger = LoggerFactory.getLogger(Base64Utils.class);

    public final static String postUrl = "http://data.zz.baidu.com/urls?site=www.zzlinks.cn&token=w7zcCOEnsOX7QcOq";

    /**
     * 百度链接实时推送
     *
     * @param postUrl
     * @param parameters
     * @return
     */
    public static String post(String postUrl, String[] parameters) {
        if (null == postUrl || null == parameters || parameters.length == 0) {
            return null;
        }
        //发送请求参数
        String parameter = "";
        for (String s : parameters) {
            parameter += s + "\n";
        }

        return post(postUrl, parameter);
    }


    public static String post(String postUrl, String parameter) {


        String result = "";
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            //建立URL之间的连接
            URLConnection conn = new URL(postUrl).openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("Host", "data.zz.baidu.com");
            conn.setRequestProperty("User-Agent", "curl/7.12.1");
            conn.setRequestProperty("Content-Length", "83");
            conn.setRequestProperty("Content-Type", "text/plain");

            //发送POST请求必须设置如下两行
            conn.setDoInput(true);
            conn.setDoOutput(true);

            //获取conn对应的输出流
            out = new PrintWriter(conn.getOutputStream());

            out.print(parameter.trim());
            //进行输出流的缓冲
            out.flush();
            //通过BufferedReader输入流来读取Url的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            logger.info("---->统计url:" + parameter + "，结果:" + result);
        } catch (Exception e) {
            logger.info("发送post请求出现异常！" + e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }

            } catch (IOException ex) {
                logger.info("关闭IO流异常");
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//        String[] parameters = new String[4];
//        parameters[0] = "http://www.zzlinks.cn/job/ODE3MTAxOTA=.html";
//        parameters[1] = "http://www.zzlinks.cn/job/NzQ5NjEwNzk=.html";
//        parameters[2] = "http://www.zzlinks.cn/job/ODE1NTIxNjM=.html";
//        parameters[3] = "http://www.zzlinks.cn/job/NzM1MTYyOTA=.html";
//        String result = post(postUrl, parameters);
//        System.out.println("result:" + result);
//    }

}
