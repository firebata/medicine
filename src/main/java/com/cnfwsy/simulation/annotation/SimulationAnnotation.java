package com.cnfwsy.simulation.annotation;

import java.lang.annotation.*;

/**
 * 说明:用于生成模拟数据
 * Created by zhangjh on 2016-05-30.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SimulationAnnotation {
    String description = "";
}
