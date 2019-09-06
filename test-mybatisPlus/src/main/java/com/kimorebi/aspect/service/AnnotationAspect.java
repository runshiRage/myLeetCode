package com.kimorebi.aspect.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect//声明这是一个切面
@Component//把这个类交给spring管理
public class AnnotationAspect {
    // 把切面的连接点放在了我们的注解上
    @Pointcut("@annotation(com.kimorebi.aspect.service.TestAspectAnnotation)")
    public void ouAspect() {
    }
    // 在这里定义前置切面
    @Before("ouAspect()")	
    public void beforeMethod(JoinPoint joinPoint) {
        
        // 这里执行保存日志的动作
        System.out.println("方法前.......");
        //得到被切方法的参数
        System.out.println(joinPoint.getArgs()[0]);
    }

    // 在这里定义后置切面
    @After("ouAspect()")	
    public void afterMethod(JoinPoint joinPoint) {
    	
    	// 这里执行保存日志的动作
    	System.out.println("方法后.......");
    	//得到被切方法的参数
    	System.out.println(joinPoint.getArgs()[0]);
    }
}