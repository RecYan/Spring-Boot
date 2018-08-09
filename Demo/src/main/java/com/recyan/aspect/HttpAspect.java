package com.recyan.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.omg.CORBA.Object;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Yan_Jiang on 2018/8/9.
 *
 */
@Component
@Aspect
public class HttpAspect {

    private final static  Logger logger =  LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.recyan.controller.GirlController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {

        //获取HttpServletRequest对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //类名 --- joinpoint.getSignature().getDeclaringTypeName();//接口全路徑  --- joinpoint.getSignature().getName();//調用的方法
        logger.info("clsaa={}", joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName());
        //参数
        logger.info("arg={}",joinPoint.getArgs());

    }

    @After("log()")
    public void doAfter() {
        logger.info("after....");
    }

    /*@AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {

        logger.info("response={}", object.toString());
    }*/
}
