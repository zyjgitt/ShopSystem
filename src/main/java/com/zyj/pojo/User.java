package com.zyj.pojo;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int id;
    //会员编号
    private String number;
    //会员账号
    private String username;
    private String password;
    private String salt;
    private int grade;
    private String idCard;
    //真实姓名
    private String name;
    private Date regDate;
    private Double score;
    //账号余额
    private Double balance;
    private String email;
    //主收货地址
    private int paid;
    //消费金额
    private Double cost;
    private String phoneNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", grade=" + grade +
                ", idCard='" + idCard + '\'' +
                ", name='" + name + '\'' +
                ", regDate=" + regDate +
                ", score=" + score +
                ", balance=" + balance +
                ", email='" + email + '\'' +
                ", paid=" + paid +
                ", cost=" + cost +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
