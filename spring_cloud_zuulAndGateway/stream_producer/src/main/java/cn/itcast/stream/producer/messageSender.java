package cn.itcast.stream.producer;

import cn.itcast.stream.processor.myProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@EnableBinding(myProcessor.class)
@Component
public class messageSender{

    @Autowired
    @Qualifier("myoutput")
    private MessageChannel output;

    public void sender(Object obj){
        output.send(MessageBuilder.withPayload(obj).build());
    }
}
