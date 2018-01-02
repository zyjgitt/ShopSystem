package com.zyj.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

//商品明细
@Component
public class GoodDetail implements Serializable {

    private int id;
    //商品编码
    private String  goodCode;
    //商品明细编码001001
    private String goodDetailCode;
    // 商品描述
    private String description;
    // 明细图片显示url
    private String imgUrl;
    //成本价格
    private Double costPrice;
    //销售价格
    private Double salePrice;
    //创建时间
    private String createTime;
    //库存数量
    private int num;
    //一对多
    private String good;

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

    public String getGoodDetailCode() {
        return goodDetailCode;
    }

    public void setGoodDetailCode(String goodDetailCode) {
        this.goodDetailCode = goodDetailCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "GoodDetail{" +
                "id=" + id +
                ", goodCode='" + goodCode + '\'' +
                ", goodDetailCode='" + goodDetailCode + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", costPrice=" + costPrice +
                ", salePrice=" + salePrice +
                ", createTime=" + createTime +
                ", num=" + num +
                '}';
    }
}
