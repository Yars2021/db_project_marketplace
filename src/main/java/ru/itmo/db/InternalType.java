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
    private String type_name;

    public InternalType() {
    }

    public InternalType(Integer tid, String type_name) {
        this.tid = tid;
        this.type_name = type_name;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}