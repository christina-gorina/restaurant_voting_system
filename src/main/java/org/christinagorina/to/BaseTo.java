package org.christinagorina.to;


import org.springframework.util.Assert;

public abstract class BaseTo {
    protected Integer id;

    public BaseTo() {
    }

    public BaseTo(Integer id) {
        this.id = id;
    }

    public int id() {
        Assert.notNull(getId(), "Entity must has id");
        return getId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return getId() == null;
    }
}
