package com.cdl.spring_boot_test2.aspect;

import java.lang.annotation.*;

/**
 * @Description ServiceAnnotation
 * @Author HymanHu
 * @Date 2020/8/17 14:32
 */
@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceAnnotation {
    String value() default "aaa";
}
