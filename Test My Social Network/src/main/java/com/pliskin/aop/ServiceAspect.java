package com.pliskin.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class ServiceAspect {

    public Object timeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Начало выполенения метода : "
                + joinPoint.getSignature().getName()
                + " с параметрами" + Arrays.toString(joinPoint.getArgs())
                + " в классе : "
                + joinPoint.getTarget().getClass().getSimpleName()
                + " время: " + start);
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Звершение выполнения метода: "
                + joinPoint.getSignature().getName() + " время: " + end + "");
        System.out.println("Время выполнения: " + (end - start));
        return result;
    }

    public void exceptionLog(JoinPoint joinPoint) throws Throwable {
        System.out.println("Exception: " + joinPoint.getSignature().getName() + " :" + Arrays.toString(joinPoint.getArgs()));
    }


}
