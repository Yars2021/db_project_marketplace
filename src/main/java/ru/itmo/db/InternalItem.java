package ru.itmo.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class InternalItem {
    @Id
    @Column(unique = true, nullable = false)
    private Integer iid;

    @Column(nullable = false)
    private Integer type_id;

    @Column(nullable = false, length = 64)
    private String owner_login;

    @Column(nullable = false, length = 256)
    private String name;

    @Column(nullable = false)
    private Integer rarity;

    @Column(length = 1024)
    private String description;

    public InternalItem() {
    }

    public InternalItem(Integer iid, Integer type_id, String owner_login, String name, Integer rarity, String description) {
        this.iid = iid;
        this.type_id = type_id;
        this.owner_login = owner_login;
        this.name = name;
        this.rarity = rarity;
        this.description = description;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getOwner_login() {
        return owner_login;
    }

    public void setOwner_login(String owner_login) {
        this.owner_login = owner_login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}