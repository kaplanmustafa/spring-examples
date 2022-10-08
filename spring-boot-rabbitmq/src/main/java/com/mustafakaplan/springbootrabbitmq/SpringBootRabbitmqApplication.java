package com.mustafakaplan.springbootrabbitmq;

import com.mustafakaplan.springbootrabbitmq.model.Notification;
import com.mustafakaplan.springbootrabbitmq.producer.NotificationProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringBootRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitmqApplication.class, args);
    }

    @Bean
//    @Profile("dev")
    CommandLineRunner createInitialUsers(NotificationProducer notificationProducer) {
        return (args) -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    Notification notification = new Notification();
                    notification.setNotificationId(UUID.randomUUID().toString());
                    notification.setCreatedAt(new Date());
                    notification.setMessage("Notification-" + i);
                    notification.setSeen(Boolean.FALSE);

                    notificationProducer.sendToQueue(notification);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        };
    }
}
