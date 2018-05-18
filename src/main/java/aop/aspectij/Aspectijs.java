package aop.aspectij;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * Created by ly on 2018/2/8.
 */
@Component
@Aspect
public class Aspectijs {

    @Pointcut("execution(* aop.*(..))")
    public void pointcut(){}


    @Before("execution(* aop.api.BizLogicImpl.*(..))")
    public void befores(){
        System.out.println("Aspectijs before...");
    }
}
