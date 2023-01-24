package ru.itmo.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<InternalItem, Integer> {
    List<InternalItem> findByOwner(String owner);
}