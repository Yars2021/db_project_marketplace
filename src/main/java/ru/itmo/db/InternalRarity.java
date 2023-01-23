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
    private String rarity_name;

    public InternalRarity() {
    }

    public InternalRarity(Integer rid, String rarity_name) {
        this.rid = rid;
        this.rarity_name = rarity_name;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRarity_name() {
        return rarity_name;
    }

    public void setRarity_name(String rarity_name) {
        this.rarity_name = rarity_name;
    }
}