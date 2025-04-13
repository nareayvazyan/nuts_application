package org.nutssubscriber.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // Use your PostgreSQL DB
public class StoredMessageRepositoryTest {

    @Autowired
    private StoredMessageRepository repository;

    @Test
    public void testSaveAndFindMessage() {
        // Arrange
        StoredMessage message = new StoredMessage();
        message.setContent("messagesss");
        message.setReceivedAt(LocalDateTime.now());

        // Act
        repository.save(message);
        List<StoredMessage> all = repository.findAll();

        // Assert
        assertThat(all).isNotEmpty();
        assertThat(all.get(0).getContent()).isEqualTo("messagesss");
    }
}
