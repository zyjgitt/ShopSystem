package com.zyj.pojo;

import java.io.Serializable;
import java.util.Date;

//供应商
public class Supplier implements Serializable{
    private int id;
    //供货商编码
    private String code;
    //供货商名称
    private String name;
    //注册公司
    private String regCompany;
    //所在地
    private String address;
    //创建时间
    private Date createTime;

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

    public String getRegCompany() {
        return regCompany;
    }

    public void setRegCompany(String regCompany) {
        this.regCompany = regCompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", regCompany='" + regCompany + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
