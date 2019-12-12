package cn.itcast.stream.consumer;

import cn.itcast.stream.processor.myProcessor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@EnableBinding(myProcessor.class)
@Component
public class messageListener {
    @StreamListener(myProcessor.MYINPUT)
    public void input(String obj){
        System.out.println("接收到消息:"+obj);
    }
}
