package ru.itmo.transfer;

import ru.itmo.db.InternalItem;

public class FormattedItem {
    private Integer iid;
    private String type;
    private String owner;
    private String name;
    private String rarity;
    private String description;

    public FormattedItem(Integer iid, String type, String owner, String name, String rarity, String description) {
        this.iid = iid;
        this.type = type;
        this.owner = owner;
        this.name = name;
        this.rarity = rarity;
        this.description = description;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
