package com.cyriljoui.spring.poc.springrabbitmq.web.controller;

import com.cyriljoui.spring.poc.springrabbitmq.Application;
import com.cyriljoui.spring.poc.springrabbitmq.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SendMessageController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    Receiver receiver;

    @RequestMapping("/send")
    @ResponseBody
    public String sendMessage() {
        rabbitTemplate.convertAndSend(Application.queueName, "Hello from RabbitMQ!");
        return "OK - count: " + receiver.getCountDown();
    }
}
