package org.nutssubscriber.api;

import org.nutssubscriber.service.QueueMessageHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {

    private final QueueMessageHandler queueMessageHandler;

    public QueueConsumer(QueueMessageHandler queueMessageHandler) {
        this.queueMessageHandler = queueMessageHandler;
    }

    @RabbitListener(queues = "nuts_db_queue")
    public void handleIncomingMessage(String rawMessage) {
        System.out.println("🐇 Received message from RabbitMQ: " + rawMessage);
        queueMessageHandler.handleMessage(rawMessage);
    }
}
