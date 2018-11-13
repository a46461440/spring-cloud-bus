package com.springboot.bus.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
@Slf4j
public class Receiver {

    private AmqpTemplate rabbitTemplate;

    @RabbitHandler
    public void proces(String hello) {
        this.log.info(hello);
    }

    public Message receive(String key, long timeout) {
        Message message = this.rabbitTemplate.receive(key, timeout);
        return message;
    }

    @Autowired
    public void setRabbitTemplate(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
}
