package com.mustafakaplan.springbootrabbitmq.handler;

import com.mustafakaplan.springbootrabbitmq.model.Notification;
import com.mustafakaplan.springbootrabbitmq.producer.NotificationProducer;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Configuration
public class NotificationSender {

    private final NotificationProducer notificationProducer;

    public NotificationSender(NotificationProducer notificationProducer) {
        this.notificationProducer = notificationProducer;
    }

    @PostConstruct
    public void init() {
        getThread();
    }

    public void getThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                Notification notification = new Notification();
                notification.setNotificationId(UUID.randomUUID().toString());
                notification.setCreatedAt(new Date());
                notification.setMessage("Notification...");
                notification.setSeen(false);

                notificationProducer.sendToQueue(notification);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.setName("Notification sender");
        thread.start();
    }
}
