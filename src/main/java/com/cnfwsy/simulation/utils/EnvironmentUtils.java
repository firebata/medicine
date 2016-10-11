package com.cnfwsy.simulation.utils;

import com.cnfwsy.core.annotation.MethodDescription;
import com.cnfwsy.core.bean.BaseForm;
import com.cnfwsy.core.constant.CommonConstant;
import com.cnfwsy.core.model.init.helper.InitHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发模式时，生成对象:
 * 1,bean必须继承BaseQueyrForm
 * 2，bean的get方法添加注解
 * Created by zhangjh on 16/5/29.
 */
public class EnvironmentUtils<T> {

    Logger logger = LoggerFactory.getLogger(EnvironmentUtils.class);

    /**
     * @return
     */
    public static boolean isDevEn() {
        String enviroment = InitHelper.SINGLETONE.getEnvironment();
        return CommonConstant.SDE.equals(enviroment);
    }

    /**
     * 查询列表信息
     *
     * @param baseForm
     * @param <T>
     * @return
     */
    public static <T> List<T> searchInfos(BaseForm baseForm) {
        List<T> result = new ArrayList<>();
        Map<String, String> attributes = new HashMap<>();
        try {
            attributes = loadVlaue(MethodDescription.class, "description", baseForm.getClass().getName());
            Class className = baseForm.getClass();
            for (int index = 0, size = 10; index < size; index++) {
                T t = createT(attributes, className, index);
                result.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param attributes
     * @param className
     * @param index
     * @param <T>
     * @return
     * @throws IllegalAccessException
     */
    private static <T> T createT(Map<String, String> attributes, Class className, int index) throws IllegalAccessException {
        T t = null;
        try {
            t = (T) className.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            Class fieldClass = field.getType();
            String fieldName = field.getName();
            String first = fieldName.substring(0, 1).toUpperCase();
            String left = fieldName.substring(1);
            field.setAccessible(true);
            String methodName = "get" + first + left;
            String methodDescription = attributes.get(methodName);
            if (StringUtils.isNoneEmpty(methodDescription)) {
                String fielfSuperClassName = field.getType().getSuperclass().getName();
                String fieldClassName = field.getType().getName();
                if (fielfSuperClassName.equals(BaseForm.class.getTypeName())) { //所有对象必须继承BaseQueryForm
                    Object object = createT(attributes, fieldClass, 0);
                    field.set(t, object);
                } else {
                    field.set(t, methodDescription + index);
                }

            }
        }
        return t;
    }

    /**
     * @param annotationClasss
     * @param annotationField
     * @param className
     * @return
     * @throws Exception
     */
    public static Map<String, String> loadVlaue(Class annotationClasss, String annotationField, String className) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        Method[] methods = Class.forName(className).getDeclaredMethods();
        for (Method method : methods) {
            String methodName = method.getName();
            if (method.isAnnotationPresent(annotationClasss)) {
                Annotation p = method.getAnnotation(annotationClasss);
                Method m = p.getClass().getDeclaredMethod(annotationField, null);
                String values = (String) m.invoke(p, null);
                map.put(methodName, values);
            }
        }
        System.out.println("map数量  === " + map.size());
        return map;
    }

}
