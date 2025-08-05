package com.zhc.service;

import com.zhc.entity.Favorite;
import com.zhc.entity.Goods;

import java.util.List;

public interface FavoriteService {
    void insert(Goods goods);

    List<Goods> getMyCollection();

    Favorite findByGoodsId(Integer goodsId);

    void remove(Integer goodsId);
}
