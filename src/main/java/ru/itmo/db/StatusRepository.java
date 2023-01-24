package ru.itmo.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<InternalStatus, Integer> {
    InternalStatus findByStatus(String status);
}