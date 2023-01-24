package ru.itmo.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RarityRepository extends JpaRepository<InternalRarity, Integer> {
    InternalRarity findByRarity(String rarity);
}