package com.cnfwsy.core.annotation;

import java.lang.annotation.*;

/**
 * 说明:如果不需要安全校验，在controller方法上面配置
 * Created by zhangjh on 2016-05-27.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreSecurity {

}
