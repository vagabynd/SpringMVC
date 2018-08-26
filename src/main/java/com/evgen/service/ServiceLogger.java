package com.evgen.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ServiceLogger {

    private static final Logger LOGGER = LogManager.getLogger(ServiceLogger.class.getName());

    @Pointcut("execution(* com.evgen.service.UserServiceImpl.findAll(..))")
    private void userServiceMethod() { }

    @Pointcut("@annotation(com.evgen.service.Logging)")
    public void logMethod() { }

    @Around(value = "userServiceMethod()")
    public Object logWebServiceCall(ProceedingJoinPoint joinPoint) throws Throwable {
            System.out.println("Not annotation");
            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            Object methodArgs = joinPoint.getArgs();
            Thread curThread = Thread.currentThread();
            LOGGER.info("From Class " + className + " method " + methodName + " was called on thread " + curThread.getName() + " with args " + methodArgs);
            Object result =  joinPoint.proceed();
            LOGGER.info("Method " + methodName + " returned value = " + result + " on thread " + curThread.getName());

            return result;
    }

    @Around(value = "logMethod()")
    public Object logServiceWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Annotation");
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object methodArgs = joinPoint.getArgs();
        Thread curThread = Thread.currentThread();
        LOGGER.info("From Class " + className + " method " + methodName + " was called on thread " + curThread.getName() + " with args " + methodArgs);
        Object result =  joinPoint.proceed();
        LOGGER.info("Method " + methodName + " returned value = " + result + " on thread " + curThread.getName());

        return result;
    }
}
