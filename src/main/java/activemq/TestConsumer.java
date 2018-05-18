package activemq;

/**
 *  Created by ly on 2018/2/22.
 */
public class TestConsumer {
    public static void main(String[] args) {
        Comsumer comsumer = new Comsumer();
        try {
            comsumer.init();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Thread(new ConsumerMq(comsumer)).start();
        new Thread(new ConsumerMq(comsumer)).start();
        new Thread(new ConsumerMq(comsumer)).start();
        new Thread(new ConsumerMq(comsumer)).start();
    }
}
