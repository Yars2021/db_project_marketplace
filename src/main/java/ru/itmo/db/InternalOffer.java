package ru.itmo.db;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "offers")
public class InternalOffer {
    @Id
    @Column(unique = true, nullable = false)
    @SequenceGenerator(name="offer_id_seq",
            sequenceName="offer_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="offer_id_seq")
    private Integer oid;

    @Column(nullable = false, length = 64)
    private String salesman;

    @Column(length = 64)
    private String buyer;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String published;

    @Column(nullable = false)
    private Integer status;

    @ManyToMany
    @JoinTable(
            name = "offer_item",
            joinColumns = @JoinColumn(name = "offer_oid"),
            inverseJoinColumns = @JoinColumn(name = "item_iid"))
    private Set<InternalItem> items;

    public InternalOffer() {
    }

    public InternalOffer(String salesman, String buyer, Integer price, String published, Integer status) {
        this.salesman = salesman;
        this.buyer = buyer;
        this.price = price;
        this.published = published;
        this.status = status;
    }

    public InternalOffer(Integer oid, String salesman, String buyer, Integer price, String published, Integer status) {
        this.oid = oid;
        this.salesman = salesman;
        this.buyer = buyer;
        this.price = price;
        this.published = published;
        this.status = status;
    }

    public Set<InternalItem> getItems() {
        return items;
    }

    public void setItems(Set<InternalItem> items) {
        this.items = items;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}