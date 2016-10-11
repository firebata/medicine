package com.cnfwsy.core.annotation;

import java.lang.annotation.*;

/**
 * controller方法描述
 * Created by zhangjh on 16/5/29.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MethodDescription {
    String description() default "";
}
