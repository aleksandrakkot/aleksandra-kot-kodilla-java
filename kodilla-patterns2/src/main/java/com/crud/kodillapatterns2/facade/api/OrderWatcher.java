package com.crud.kodillapatterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Aspect
@Component
public class OrderWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before(value =
            "execution(* com.crud.kodillapatterns2.facade.api.OrderFacade.processOrder(..))" +
                    "&& args(theOrder, theNumber) && target(object)", argNames = "theOrder,theNumber,object")
    public void logEvent(OrderDto theOrder, long theNumber, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + "\nArgs:\n" + theOrder + "\nUser ID: " + theNumber);
    }

    @Around("execution(* com.crud.kodillapatterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.info("Something went wrong!");
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}