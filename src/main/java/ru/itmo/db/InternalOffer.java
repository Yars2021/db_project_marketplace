package ru.itmo.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "offers")
public class InternalOffer {
    @Id
    @Column(unique = true, nullable = false)
    private Integer oid;

    @Column(nullable = false, length = 64)
    private String salesman_login;

    @Column(length = 64)
    private String buyer_login;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String date_of_publishing;

    @Column(nullable = false)
    private Integer status_id;

    public InternalOffer() {
    }

    public InternalOffer(Integer oid, String salesman_login, String buyer_login, Integer price, String date_of_publishing, Integer status_id) {
        this.oid = oid;
        this.salesman_login = salesman_login;
        this.buyer_login = buyer_login;
        this.price = price;
        this.date_of_publishing = date_of_publishing;
        this.status_id = status_id;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getSalesman_login() {
        return salesman_login;
    }

    public void setSalesman_login(String salesman_login) {
        this.salesman_login = salesman_login;
    }

    public String getBuyer_login() {
        return buyer_login;
    }

    public void setBuyer_login(String buyer_login) {
        this.buyer_login = buyer_login;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate_of_publishing() {
        return date_of_publishing;
    }

    public void setDate_of_publishing(String date_of_publishing) {
        this.date_of_publishing = date_of_publishing;
    }

    public Integer getStatus_id() {
        return status_id;
    }

    public void setStatus_id(Integer status_id) {
        this.status_id = status_id;
    }
}