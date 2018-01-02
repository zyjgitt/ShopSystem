package com.zyj.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//商品
@Component
public class Good implements Serializable {
    private int id;
    //商品编码
    private String code;
    private String name;
    //商品简码
    private String briefCode;
    //商品类型ID
    private int typeId;
    //供货商ID
    private int  supplierId;
    //店铺名称
    private String storeName;
    //上架时间
    private String registerDate;
    //价格
    private Double price;
    //商品显示图片URL
    private String imgUrl;
    //是否是赠品
    private String ifGift;
    //是否支持退换
    private String ifReturn;
    private GoodType goodType;
    //商品和商品详细信息一对多
    private List<GoodDetail> goodDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBriefCode() {
        return briefCode;
    }

    public void setBriefCode(String briefCode) {
        this.briefCode = briefCode;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getIfGift() {
        return ifGift;
    }

    public void setIfGift(String ifGift) {
        this.ifGift = ifGift;
    }

    public String getIfReturn() {
        return ifReturn;
    }

    public void setIfReturn(String ifReturn) {
        this.ifReturn = ifReturn;
    }

    public GoodType getGoodType() {
        return goodType;
    }

    public void setGoodType(GoodType goodType) {
        this.goodType = goodType;
    }

    public List<GoodDetail> getGoodDetails() {
        return goodDetails;
    }

    public void setGoodDetails(List<GoodDetail> goodDetails) {
        this.goodDetails = goodDetails;
    }
}
