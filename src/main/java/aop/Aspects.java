package aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *  Created by ly on 2018/2/6.
 */

public class Aspects {
    public void before() {
        System.out.println("Aspects before");
    }


    public void after() {
        System.out.println("Aspects after");
    }


    public void afterReturning() {
        System.out.println("Aspects afterReturning");
    }

    public void afterThrowing() {
        System.out.println("Aspects afterThrowing");
    }


    public Object around(ProceedingJoinPoint proceedingJoinPoint) {

        try {
            if (1 == 1) {
                proceedingJoinPoint.proceed();
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Aspects around");

        return new Object();
    }

    public Object aroundInit(ProceedingJoinPoint proceedingJoinPoint, String name, int times) throws Throwable {
        System.out.println("Aspects aroundInit :" + name + ";" + times);
        return proceedingJoinPoint.proceed();
    }
}
