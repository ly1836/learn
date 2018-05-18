package autobean;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  Created by ly on 2018/1/20.
 */
public class TestCls {

    private ApplicationContext applicationContext;

    @Before
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:application-annotation.xml");
    }

    @Test
    public void testSay(){
        BeanAnnotation beanAnnotation = (BeanAnnotation) applicationContext.getBean("beanAnnotation");

        beanAnnotation.say("hello");

        beanAnnotation = (BeanAnnotation) applicationContext.getBean("beanAnnotation");
        beanAnnotation.say("hello");
    }

    @Test
    public void testScope(){
        BeanAnnotation beanAnnotation = (BeanAnnotation) applicationContext.getBean("beanAnnotation");

        beanAnnotation.say("hello");

        beanAnnotation = (BeanAnnotation) applicationContext.getBean("beanAnnotation");
        beanAnnotation.say("hello");
    }
}
