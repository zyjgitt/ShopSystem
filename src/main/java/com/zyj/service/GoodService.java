package com.zyj.service;

import com.zyj.pojo.*;

import java.util.Date;
import java.util.List;

public interface GoodService {
    //添加商品分类
    public void saveGoodType(GoodType goodType);
    //添加店铺
/*    public void saveStore(Store store);*/

    //添加供应商
    public void saveSupplier(Supplier supplier);
  /*  //查询供应商是否存在
    public int selSupplierExist(String name);*/
    //查供货商有哪些
    public List<Supplier> selAllSupplier();
    //查询商品类型有哪些
    public List<GoodType> selAllGoodType();
    //添加商品
    public void saveGood(Good good);
    //添加商品详细信息
    public void saveGoodDetail(GoodDetail goodDetail);
    //根据商品类型查出此类型的所有商品
    public List<Good> selAllGoodByType(int typeId);
    //显示出此店铺的所有商品
    public  List<Good> selAllGoodByStore(String storeName);
    //显示出此店铺的所有商品的所有信息
    public  List<Good> selGoodALLMessage(String storeName);
  //显示出此店铺的所有商品的所有明细信息
  public  List<GoodDetail> selGoodDetailByStore(String storeName);
    //查出所有商品的 图片url，商品名称，商品编码
    public List<Good> selAllGood();
    //根据商品编码查出商品详细信息（图片，商品名称，价格，描述，库存）
    public Good selGoodDetailByGoodCode(String code);
   /* //根据商品编码和描述查到商品图片，库存，价格
    public GoodDetail selNum(String code,String description);*/
   //保存加入购物车的商品信息
   public void saveShopCart(ShopCart shopCart);
}
