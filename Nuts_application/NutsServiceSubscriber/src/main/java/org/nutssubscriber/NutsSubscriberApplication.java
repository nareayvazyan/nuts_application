package org.nutssubscriber;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class NutsSubscriberApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutsSubscriberApplication.class, args);
        System.out.println("🚀 Nuts Subscriber Application is running...");
    }
}
