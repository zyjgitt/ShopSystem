package com.zyj.pojo;

import java.io.Serializable;
import java.util.Date;
//商品分类
public class GoodType implements Serializable {
     //主键
     private int id;
     //类型编码
     private String typeCode;
     //类型名称
     private String name;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getTypeCode() {
          return typeCode;
     }

     public void setTypeCode(String typeCode) {
          this.typeCode = typeCode;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     @Override
     public String toString() {
          return "GoodType{" +
                  "id=" + id +
                  ", typeCode='" + typeCode + '\'' +
                  ", name='" + name + '\'' +
                  '}';
     }
}
