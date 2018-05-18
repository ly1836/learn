package activemq;

/**
 *  Created by ly on 2018/2/22.
 */
public class ProductorMq implements  Runnable {

    public Producter producter;
    public ProductorMq(Producter producter){
        this.producter = producter;
    }

    @Override
    public void run() {
        while(true){
            try {
                producter.sendMessage("ly-MQ");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

