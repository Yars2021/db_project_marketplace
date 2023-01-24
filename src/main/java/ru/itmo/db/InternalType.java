package ru.itmo.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "types")
public class InternalType {
    @Id
    @Column(unique = true, nullable = false)
    private Integer tid;

    @Column(nullable = false)
    private String type;

    public InternalType() {
    }

    public InternalType(Integer tid, String type) {
        this.tid = tid;
        this.type = type;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type_name) {
        this.type = type_name;
    }
}