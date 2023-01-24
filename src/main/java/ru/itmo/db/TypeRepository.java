package ru.itmo.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<InternalType, Integer> {
    InternalType findByType(String type);
}