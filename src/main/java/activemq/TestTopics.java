package activemq;

/**
 *
 * Created by ly on 2018/2/23.
 */
public class TestTopics {
    public static void main(String[] args) {
        Topics topics = new Topics();
        try {
            topics.init();
            topics.getMessage("camelLY");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
