package org.nutssubscriber.service;

import org.nutssubscriber.repository.StoredMessage;
import org.nutssubscriber.repository.StoredMessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QueueMessageHandler {

    private final StoredMessageRepository messageRepository;

    public QueueMessageHandler(StoredMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void handleMessage(String content) {
        if (content == null || content.isBlank()) {
            System.out.println("⚠️ Skipping empty message");
            return;
        }

        System.out.println("💾 Saving message to database: " + content);

        StoredMessage message = new StoredMessage();
        message.setContent(content);
        message.setReceivedAt(LocalDateTime.now());

        messageRepository.save(message);
        System.out.println("✅ Message saved successfully");
    }
}
