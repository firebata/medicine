package com.cnfwsy.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明:防止重复提交,定义到controller的方法上
 * Created by zhangjh on 2016-06-30.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ForbidRepeatSubmit {

    boolean needSaveToken() default false;

    boolean needRemoveToken() default false;
}
