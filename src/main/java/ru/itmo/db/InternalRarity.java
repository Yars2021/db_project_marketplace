package ru.itmo.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rarities")
public class InternalRarity {
    @Id
    @Column(unique = true, nullable = false)
    private Integer rid;

    @Column(nullable = false)
    private String rarity;

    public InternalRarity() {
    }

    public InternalRarity(Integer rid, String rarity) {
        this.rid = rid;
        this.rarity = rarity;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity_name) {
        this.rarity = rarity_name;
    }
}