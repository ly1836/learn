package activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  Created by ly on 2018/2/23.
 */
public class Topics {

    //ActiveMq 的默认用户名
//    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;.
    private static final String USERNAME = "admin";
    //ActiveMq 的默认登录密码
    //private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String PASSWORD = "admin";

    private static final String BROKEN_URL = ActiveMQConnection.DEFAULT_BROKER_URL;


    ConnectionFactory connectionFactory;

    Connection connection;

    Session session;

    ThreadLocal<MessageConsumer> threadLocal = new ThreadLocal<>();
    AtomicInteger count = new AtomicInteger();


    public void init() throws Exception{
        try {
            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEN_URL);

            connection  = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    public void getMessage(String disname) throws JMSException, InterruptedException {
        Topic topic =  session.createTopic(disname);


        MessageConsumer consumer = null;

        if(threadLocal.get()!=null){
            consumer = threadLocal.get();
        }else{
            consumer = session.createConsumer(topic);
            threadLocal.set(consumer);
        }

        while(true){
            Thread.sleep(1000);
            TextMessage msg = (TextMessage) consumer.receive();
            if(msg!=null) {
                msg.acknowledge();
                System.out.println("通过camel转发接收后的topic消息："+msg.getText());
            }else {
                break;
            }
        }


    }

}
