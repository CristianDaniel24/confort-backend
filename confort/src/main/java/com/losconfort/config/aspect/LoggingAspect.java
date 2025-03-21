package com.losconfort.config.aspect;

import static com.losconfort.confortstarterrest.common.Constants.BASE_POINTCUT;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Before(BASE_POINTCUT)
    public void logBeforeController(JoinPoint joinPoint) {
        log.info("Entering method: {}", joinPoint.getSignature().toShortString());
        log.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = BASE_POINTCUT, returning = "result")
    public void logAfterController(JoinPoint joinPoint, Object result) {
        log.info("Method returned: {} - Result: {}", joinPoint.getSignature().toShortString(), result);
    }

    @AfterThrowing(pointcut = BASE_POINTCUT, throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.error("Exception in method: {}", joinPoint.getSignature().toShortString());
        log.error("Exception message: {}", exception.getMessage(), exception);
    }
}
