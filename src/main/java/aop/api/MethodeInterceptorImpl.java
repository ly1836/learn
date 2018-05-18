package aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *  Created by ly on 2018/2/7.
 */
public class MethodeInterceptorImpl implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("MethodeInterceptorImpl 1: " + invocation.getMethod().getName()+"    " + invocation.getStaticPart().getClass().getName());

        Object object = invocation.proceed();

        System.out.println("MethodeInterceptorImpl 2: " + object);
        return invocation.proceed();
    }
}
