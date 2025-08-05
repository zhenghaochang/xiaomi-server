package com.zhc.service;

import com.zhc.entity.Goods;
import com.zhc.entity.vo.ShoppingCartVo;

import java.util.List;

public interface ShoppingCartService {
    Integer findNumByUserId(Integer id);

    void insert(Goods goods);

    List<ShoppingCartVo> getGoodsList();

    void update(ShoppingCartVo shoppingCartVo);

    void delete(Integer goodsId);

    Integer getNumInCart();

    boolean getByUserId(Integer goodsId);

    void addOne(Goods goods);
}
