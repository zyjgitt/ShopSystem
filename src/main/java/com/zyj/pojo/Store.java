package com.zyj.pojo;

import java.io.Serializable;

//店铺
public class Store implements Serializable {
    private int id;
    //店铺名称
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
