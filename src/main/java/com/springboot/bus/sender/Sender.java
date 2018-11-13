package com.springboot.bus.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    @Autowired
    public void setRabbitTemplate(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
}
