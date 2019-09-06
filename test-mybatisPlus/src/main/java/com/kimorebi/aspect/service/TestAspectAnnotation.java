package com.kimorebi.aspect.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明一个注解 @TestAspectAnnotation 用于实现添加注解之后，会在注解生成切面
 *
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)  
public @interface TestAspectAnnotation {
    
}
