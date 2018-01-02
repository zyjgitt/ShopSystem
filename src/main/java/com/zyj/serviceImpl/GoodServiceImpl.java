package com.zyj.serviceImpl;

import com.zyj.mapper.GoodMapper;
import com.zyj.pojo.*;
import com.zyj.service.GoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("goodService")
public class GoodServiceImpl implements GoodService {
    @Resource
    private GoodMapper goodMapper;
    public void saveGoodType(GoodType goodType) {
        goodMapper.saveGoodType(goodType);
    }

   /* public void saveStore(Store store) {

    }*/

    public void saveSupplier(Supplier supplier) {
        goodMapper.saveSupplier(supplier);
    }

    public List<Supplier> selAllSupplier() {

        return goodMapper.selAllSupplier();
    }

    public int selSupplierExist(String name) {
        return goodMapper.selSupplierExist(name);
    }

    public List<GoodType> selAllGoodType() {
        return goodMapper.selAllGoodType();
    }

    public void saveGood(Good good) {
        goodMapper.saveGood(good);
    }

    public void saveGoodDetail(GoodDetail goodDetail) {
        goodMapper.saveGoodDetail(goodDetail);
    }

    public List<Good> selAllGoodByType(int typeId) {
        return goodMapper.selAllGoodByType(typeId);
    }

    public List<Good> selAllGoodByStore(String storeName) {
        return goodMapper.selAllGoodByStore(storeName);
    }

    public List<Good> selGoodALLMessage(String storeName) {
        return goodMapper.selGoodALLMessage(storeName);
    }

    public List<GoodDetail> selGoodDetailByStore(String storeName) {
        return goodMapper.selGoodDetailByStore(storeName);
    }

    public List<Good> selAllGood() {
        return goodMapper.selAllGood();
    }

    public Good selGoodDetailByGoodCode(String code) {
        return goodMapper.selGoodDetailByGoodCode(code);
    }

    public void saveShopCart(ShopCart shopCart) {
        goodMapper.saveShopCart(shopCart);
    }

   /* public GoodDetail selNum(String code, String description) {
        return goodMapper.selNum(code,description);
    }*/
}
