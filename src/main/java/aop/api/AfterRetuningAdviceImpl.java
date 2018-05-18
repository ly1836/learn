package aop.api;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 *  Created by ly on 2018/2/7.
 */
public class AfterRetuningAdviceImpl implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterRetuningAdviceImpl afterReturning" + method.getName()+"   " + target.getClass().getName() + returnValue);
    }
}
