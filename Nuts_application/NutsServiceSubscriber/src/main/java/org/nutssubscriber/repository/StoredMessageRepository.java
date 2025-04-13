package org.nutssubscriber.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoredMessageRepository extends JpaRepository<StoredMessage, Long> {
}
