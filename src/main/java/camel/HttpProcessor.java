package camel;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;


/**
 *  Created by ly on 2018/2/22.
 */
public class HttpProcessor implements Processor {


    public void process(Exchange exchange) throws Exception {
        Message message = (Message) exchange.getIn();

        String text = message.getBody().toString();


        Message outMessage = exchange.getOut();
        outMessage.setBody(text + " || out");
    }


}
