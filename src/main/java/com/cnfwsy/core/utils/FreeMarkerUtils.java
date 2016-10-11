package com.cnfwsy.core.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.Map;

/**
 * 说明:
 * Created by zhangjh on 2016-07-31.
 */
public enum FreeMarkerUtils {
    SINGLETONE;
    static Configuration cfg; // 模版配置对象

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setClassLoaderForTemplateLoading(FreeMarkerUtils.class.getClassLoader(), "conf/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    }

    /**
     * 获取指定目录下的模板文件
     *
     * @param name       模板文件的名称
     * @param pathPrefix 模板文件的目录
     */
    public Template getTemplate(String name, String pathPrefix) throws IOException {

//        Configuration cfg = new Configuration(); //通过FreeMarker的Configuration对象可以读取ftl文件
//        cfg.setClassForTemplateLoading(this.getClass(), pathPrefix); //设置模板文件的目录
//        cfg.setDefaultEncoding("UTF-8");       //Set the default charset of the template files
//        Template temp = cfg.getTemplate(name); //在模板文件目录中寻找名为"name"的模板文件
        Template temp = cfg.getTemplate(name); //在模板文件目录中寻找名为"name"的模板文件
        return temp; //此时FreeMarker就会到类路径下的"pathPrefix"文件夹中寻找名为"name"的模板文件

    }

    /**
     * 根据模板文件输出内容到控制台
     *
     * @param name       模板文件的名称
     * @param pathPrefix 模板文件的目录
     * @param rootMap    模板的数据模型
     */
    public void print(String name, String pathPrefix, Map<String, Object> rootMap) throws TemplateException, IOException {

        this.getTemplate(name, pathPrefix).process(rootMap, new PrintWriter(System.out));

    }

    /**
     * 根据模板文件输出内容到指定的文件中
     *
     * @param name       模板文件的名称
     * @param pathPrefix 模板文件的目录
     * @param rootMap    模板的数据模型
     * @param file       内容的输出文件
     */
    public void printFile(String name, String pathPrefix, Map<String, Object> rootMap, File file) throws TemplateException, IOException {
        Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        this.getTemplate(name, pathPrefix).process(rootMap, out); //将模板文件内容以UTF-8编码输出到相应的流中
        if (null != out) {
            out.close();
        }
    }
}
