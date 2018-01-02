package com.zyj.pojo;

import java.io.Serializable;

public class ShopCart implements Serializable{
    private int id;
    private String goodCode;
    //商品明细的id
    private int did;
    private String goodName;
    private String imgUrl;
    //商品的描述：白色...
    private String descr;
    private Double price;
    //加入购物车的商品的数量
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
                "id=" + id +
                ", did=" + did +
                ", goodName='" + goodName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", desc='" + descr+ '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
