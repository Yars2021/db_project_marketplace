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
    private String status_name;

    public InternalStatus() {
    }

    public InternalStatus(Integer sid, String status_name) {
        this.sid = sid;
        this.status_name = status_name;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }
}