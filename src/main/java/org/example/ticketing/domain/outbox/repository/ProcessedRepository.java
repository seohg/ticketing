package org.example.ticketing.domain.outbox.repository;

import org.example.ticketing.domain.outbox.model.Processed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedRepository extends JpaRepository<Processed, Long> {
    boolean existsByMessageId(String messageId);
}