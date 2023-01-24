package ru.itmo.db;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "items")
public class InternalItem {
    @Id
    @Column(unique = true, nullable = false)
    @SequenceGenerator(name="item_id_seq",
            sequenceName="item_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="item_id_seq")
    private Integer iid;

    @Column(nullable = false)
    private Integer type;

    @Column(nullable = false, length = 64)
    private String owner;

    @Column(nullable = false, length = 256)
    private String name;

    @Column(nullable = false)
    private Integer rarity;

    @Column(length = 1024)
    private String description;

    @ManyToMany
    private Set<InternalOffer> offers;

    public InternalItem() {
    }

    public InternalItem(Integer type, String owner, String name, Integer rarity, String description) {
        this.type = type;
        this.owner = owner;
        this.name = name;
        this.rarity = rarity;
        this.description = description;
    }

    public InternalItem(Integer iid, Integer type, String owner, String name, Integer rarity, String description) {
        this.iid = iid;
        this.type = type;
        this.owner = owner;
        this.name = name;
        this.rarity = rarity;
        this.description = description;
    }

    public Set<InternalOffer> getOffers() {
        return offers;
    }

    public void setOffers(Set<InternalOffer> offers) {
        this.offers = offers;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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