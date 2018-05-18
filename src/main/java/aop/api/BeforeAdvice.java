package aop.api;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 *  Created by ly on 2018/2/7.
 */
public class BeforeAdvice implements MethodBeforeAdvice{
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice :" +method.getName() + "     " + target.getClass().getName());
    }
}
