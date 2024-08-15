package org.example.ticketing.domain.outbox.repository;

import org.example.ticketing.domain.outbox.model.Outbox;
import org.example.ticketing.domain.outbox.model.OutboxStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutboxRepository extends JpaRepository<Outbox, Long> {
    List<Outbox> findAllByStatus(OutboxStatus status);
}