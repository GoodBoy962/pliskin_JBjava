package com.pliskin.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ServiceAspect {

    private DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public Object timeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Начало выполенения метода : "
                + joinPoint.getSignature().getName()
                + " с параметрами" + Arrays.toString(joinPoint.getArgs())
                + " в классе : "
                + joinPoint.getTarget().getClass().getSimpleName()
                + " время: " + df.format(start));
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Звершение выполнения метода: "
                + joinPoint.getSignature().getName() + " время: " + df.format(end) + "");
        System.out.println("Время выполнения: " + (end - start) + " ms");
        return result;
    }

    public void exceptionLog(JoinPoint joinPoint) throws Throwable {
        System.out.println("Exception: " + joinPoint.getSignature().getName() + " :" + Arrays.toString(joinPoint.getArgs()));
    }


}
