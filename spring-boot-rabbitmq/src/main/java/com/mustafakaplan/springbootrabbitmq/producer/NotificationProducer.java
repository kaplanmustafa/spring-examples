package com.mustafakaplan.springbootrabbitmq.producer;

import com.mustafakaplan.springbootrabbitmq.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    private final RabbitTemplate rabbitTemplate;

    public NotificationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendToQueue(Notification notification) {
        System.out.println("Notification Sent - ID : " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
    }
}
