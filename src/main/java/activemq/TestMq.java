package activemq;

/**
 *  Created by ly on 2018/2/22.
 */
public class TestMq {

    public static void main(String[] args) {
        Producter producter = new Producter();
        try {
            producter.init();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Thread 1
        new Thread(new ProductorMq(producter)).start();
        //Thread 2
        new Thread(new ProductorMq(producter)).start();
        //Thread 3
        new Thread(new ProductorMq(producter)).start();
        //Thread 4
        new Thread(new ProductorMq(producter)).start();
        //Thread 5
        new Thread(new ProductorMq(producter)).start();
    }



}
