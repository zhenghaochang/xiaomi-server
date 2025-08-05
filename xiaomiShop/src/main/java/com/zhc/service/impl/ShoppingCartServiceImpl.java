package com.zhc.service.impl;

import com.zhc.common.context.BaseContext;
import com.zhc.entity.Goods;
import com.zhc.entity.ShoppingCart;
import com.zhc.entity.vo.ShoppingCartVo;
import com.zhc.mapper.ShoppingCartMapper;
import com.zhc.service.ShoppingCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public Integer findNumByUserId(Integer userId) {
        return shoppingCartMapper.findNumByUserId(userId);
    }

    @Override
    public void insert(Goods goods) {
        Integer userId = BaseContext.getCurrentId();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserId(userId);
        shoppingCart.setNumber(1);
        shoppingCart.setGoodsId(goods.getId());
        shoppingCart.setGoodsName(goods.getGoodsName());
        shoppingCart.setCreateTime(LocalDateTime.now());
        shoppingCart.setGoodsPrice(goods.getGoodsPriceNew());
        shoppingCartMapper.insert(shoppingCart);
    }

    @Override
    public List<ShoppingCartVo> getGoodsList() {
        Integer userId = BaseContext.getCurrentId();
        List<ShoppingCart> list = shoppingCartMapper.getGoodsList(userId);
        List<ShoppingCartVo> voList = new ArrayList<>();
        for (ShoppingCart shoppingCart : list) {
            ShoppingCartVo vo = new ShoppingCartVo();
            BeanUtils.copyProperties(shoppingCart, vo);
            vo.setXiaoji(vo.getGoodsPrice().multiply(BigDecimal.valueOf(vo.getNumber())));
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public void update(ShoppingCartVo shoppingCartVo) {
        ShoppingCart shoppingCart = new ShoppingCart();
        BeanUtils.copyProperties(shoppingCartVo, shoppingCart);
        shoppingCartMapper.update(shoppingCart);
    }

    @Override
    public void delete(Integer goodsId) {
        Integer userId = BaseContext.getCurrentId();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setGoodsId(goodsId);
        shoppingCart.setUserId(userId);
        shoppingCartMapper.delete(shoppingCart);
    }

    @Override
    public Integer getNumInCart() {
        Integer userId = BaseContext.getCurrentId();
        return shoppingCartMapper.getNumInCart(userId);
    }

    @Override
    public boolean getByUserId(Integer goodsId) {
        Integer userId = BaseContext.getCurrentId();
        ShoppingCart shoppingCart = shoppingCartMapper.getByUserId(userId,goodsId);
        if (shoppingCart != null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void addOne(Goods goods) {
        shoppingCartMapper.addOne(goods.getId(),BaseContext.getCurrentId());
    }
}
