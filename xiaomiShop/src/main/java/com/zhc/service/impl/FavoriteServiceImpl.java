package com.zhc.service.impl;

import com.zhc.common.context.BaseContext;
import com.zhc.entity.Favorite;
import com.zhc.entity.Goods;
import com.zhc.mapper.FavoriteMapper;
import com.zhc.mapper.GoodsMapper;
import com.zhc.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void insert(Goods goods) {
        Favorite favorite = new Favorite();
        favorite.setGoodsId(goods.getId());
        favorite.setUserId(BaseContext.getCurrentId());
        favoriteMapper.insert(favorite);
    }

    @Override
    public List<Goods> getMyCollection() {
        Integer userId = BaseContext.getCurrentId();
        List<Integer> goodsIds = favoriteMapper.getByUserId(userId);
        List<Goods> list = new ArrayList<Goods>();
        if(goodsIds!=null && goodsIds.size()>0){
            list = goodsMapper.findByIds(goodsIds);
        }
        return list;
    }

    @Override
    public Favorite findByGoodsId(Integer goodsId) {
        Integer userId = BaseContext.getCurrentId();
        Favorite favorite = new Favorite();
        favorite.setGoodsId(goodsId);
        favorite.setUserId(userId);
        return favoriteMapper.find(favorite);
    }

    @Override
    public void remove(Integer goodsId) {
        Integer userId = BaseContext.getCurrentId();
        Favorite favorite = new Favorite();
        favorite.setGoodsId(goodsId);
        favorite.setUserId(userId);
        favoriteMapper.remove(favorite);
    }
}
