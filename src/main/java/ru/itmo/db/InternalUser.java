package ru.itmo.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class InternalUser {
    @Id
    @Column(unique = true, nullable = false, length = 64)
    private String login;

    @Column(nullable = false, length = 256)
    private String password;

    @Column(unique = true, nullable = false, length = 128)
    private String username;

    @Column(nullable = false)
    private Integer buyer_reputation;

    @Column(nullable = false)
    private Integer salesman_reputation;

    public InternalUser() {
    }

    public InternalUser(String login, String password, String username, Integer buyer_reputation, Integer salesman_reputation) {
        this.login = login;
        this.password = password;
        this.username = username;
        this.buyer_reputation = buyer_reputation;
        this.salesman_reputation = salesman_reputation;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBuyer_reputation() {
        return buyer_reputation;
    }

    public void setBuyer_reputation(Integer buyer_reputation) {
        this.buyer_reputation = buyer_reputation;
    }

    public Integer getSalesman_reputation() {
        return salesman_reputation;
    }

    public void setSalesman_reputation(Integer salesman_reputation) {
        this.salesman_reputation = salesman_reputation;
    }
}