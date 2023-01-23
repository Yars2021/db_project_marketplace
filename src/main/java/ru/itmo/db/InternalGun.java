package ru.itmo.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "guns")
public class InternalGun {
    @Id
    @Column(unique = true, nullable = false)
    private Integer gid;

    @Column(nullable = false, length = 256)
    private String name;

    @Column(nullable = false)
    private Integer rarity;

    @Column(length = 1024)
    private String description;
}