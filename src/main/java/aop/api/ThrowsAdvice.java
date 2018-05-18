package aop.api;

import java.lang.reflect.Method;

/**
 *  Created by ly on 2018/2/7.
 */
public class ThrowsAdvice implements org.springframework.aop.ThrowsAdvice {

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("ThrowsAdvice afterThrowing 1");
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("ThrowsAdvice afterThrowing 2" + method.getName()+"   " + target.getClass().getName());
    }
}
