package ru.itmo.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class InternalStatus {
    @Id
    @Column(unique = true, nullable = false)
    private Integer sid;

    @Column(nullable = false)
    private String status;

    public InternalStatus() {
    }

    public InternalStatus(Integer sid, String status) {
        this.sid = sid;
        this.status = status;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status_name) {
        this.status = status_name;
    }
}