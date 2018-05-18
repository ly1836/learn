package activemq;

/**
 *  Created by ly on 2018/2/22.
 */
public class ConsumerMq implements Runnable {

    Comsumer comsumer;
    public ConsumerMq(Comsumer comsumer){
        this.comsumer = comsumer;
    }

    @Override
    public void run() {
        while(true){
            try {
                comsumer.getMessage("ly-MQ");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
