package com.springboot.bus;

import com.springboot.bus.receiver.Receiver;
import com.springboot.bus.sender.Sender;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BusApplicationTests {

    public Sender sender;

    public Receiver receiver;

    @Test
    public void testSend() {
        this.sender.send();
    }

    @Test
    public void testReceive() {
        Message message = this.receiver.receive("hello", 1000);
        byte[] bs = message.getBody();
        String str_message = new String(bs);
        this.log.info(str_message);
    }

    @Autowired
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @Autowired
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}
