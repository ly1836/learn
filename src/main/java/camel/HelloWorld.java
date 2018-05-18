package camel;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Handler;
import org.apache.camel.Headers;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.ModelCamelContext;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.jms.ConnectionFactory;

/**
 *  Created by ly on 2018/2/22.
 */
public class HelloWorld extends RouteBuilder {
    static ApplicationContext context;

    public static void main(String[] args) throws Exception {

        //context = new ClassPathXmlApplicationContext("classpath:camel.xml");
        CamelContext context = new DefaultCamelContext(); // 1. 创建 CamelContext.

        ConnectionFactory connectionfactory =
                new ActiveMQConnectionFactory("admin","admin","tcp://localhost:61616");

        //添加组件标签
        context.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge(connectionfactory));
        context.addRoutes(new HelloWorld());
        context.start();


        //使主线程不退出
        synchronized (HelloWorld.class) {
            HelloWorld.class.wait();
        }

    }


    public void configure() throws Exception {
        //.process(new HttpProcessor())
        //?host=tcp://127.0.0.1:1883&amp;userName=admin&amp;password=admin&amp
        from("activemq:queue:ly-MQ").process(new HttpProcessor()).bean(HelloWorld.class, "camelOut(String,String)").to("activemq:topic:camelLY");
    }


    public void camelOut(@Headers String msg,String body){
        System.out.println("camel用process处理后:"+body);
    }
}
