package com.vedha.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AppProxy {

    @Around("execution(* com.vedha.service.*.*(..)) || execution(* com.vedha.controller.*.*(..))")
    public Object logMethodCalls(ProceedingJoinPoint joinPoint) throws Throwable {

        log.warn("Method: {} called with arguments: {}", joinPoint.getSignature().toShortString(), joinPoint.getArgs());
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        log.warn("Time taken by {} is {} s", joinPoint.getSignature().toShortString(), (endTime - startTime) / 1000);

        log.warn("Method: {} returned: {}", joinPoint.getSignature().toShortString(), result);

        return result;
    }
}
