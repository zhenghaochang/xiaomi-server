package com.zhc.service;

import com.zhc.entity.Goods;
import com.zhc.entity.GoodsCategory;
import com.zhc.entity.dto.GoodsSelectDto;
import com.zhc.entity.vo.GoodsVo;
import com.zhc.entity.vo.PageGoodsVo;

import java.util.List;

public interface GoodsService {
    List<GoodsVo> getHotGoodsList(List<Integer> categoryId);

    List<GoodsVo> getGoodsList(Integer categoryId);

    List<GoodsCategory> getCategoryList();

    PageGoodsVo getAllGoodsList(GoodsSelectDto selectParam);

    GoodsVo getById(Integer id);
}
