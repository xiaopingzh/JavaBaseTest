package com.ping.pattern.interceptingfilter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 使用切面实现拦截过滤器模式
 * Author:zhangxiaoping04@meituan.com
 * Date:2019/2/22
 * Time:上午10:38
 */
@Aspect
public class CoreTraceCommandAspect {


    @Pointcut("@annotation(com.meituan.baobab.tms.keeper.trace.annotation.CoreTraceCommand)")
    public void coreTraceCommandAnnotationPointcut() {
    }

    @Pointcut("@annotation(com.meituan.baobab.tms.keeper.trace.annotation.CoreTraceRelyCommand)")
    public void coreTraceRelyCommandAnnotationPointcut() {
    }

    /**
     * 注解标注的方法在执行前执行该方法
     * @param joinPoint
     * @throws Exception
     */
    @Around("coreTraceCommandAnnotationPointcut() || coreTraceRelyCommandAnnotationPointcut()")
    public void methodAnnotatedWithCoreTraceCommand(final ProceedingJoinPoint joinPoint) throws Exception{
        if (joinPoint.getSignature() instanceof MethodSignature) {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            System.out.println("ClassName  = " + joinPoint.getTarget().getClass() + ", methodName = " + signature.getName());
        }
    }


}
