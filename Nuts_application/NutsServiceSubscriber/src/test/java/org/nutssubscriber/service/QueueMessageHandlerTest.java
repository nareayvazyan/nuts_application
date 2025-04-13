package org.nutssubscriber.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.nutssubscriber.repository.StoredMessage;
import org.nutssubscriber.repository.StoredMessageRepository;

import static org.mockito.Mockito.*;

public class QueueMessageHandlerTest {

    private StoredMessageRepository mockRepo;
    private QueueMessageHandler messageHandler;

    @BeforeEach
    public void setup() {
        mockRepo = mock(StoredMessageRepository.class);
        messageHandler = new QueueMessageHandler(mockRepo);
    }

    @Test
    public void testHandleValidMessage() {
        String message = "Test message";
        messageHandler.handleMessage(message);

        verify(mockRepo, times(1)).save(any(StoredMessage.class));
    }

    @Test
    public void testHandleBlankMessage() {
        messageHandler.handleMessage("   ");
        verify(mockRepo, never()).save(any());
    }

    @Test
    public void testHandleNullMessage() {
        messageHandler.handleMessage(null);
        verify(mockRepo, never()).save(any());
    }
}
