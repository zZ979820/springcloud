package cn.itcast.stream.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface myProcessor {
    String MYOUTPUT="myoutput";
    @Output(MYOUTPUT)
    MessageChannel myoutput();

    String MYINPUT="myinput";
    @Input(MYINPUT)
    SubscribableChannel myinput();
}
