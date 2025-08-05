package com.zhc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhc.entity.Goods;
import com.zhc.entity.GoodsCategory;
import com.zhc.entity.dto.GoodsSelectDto;
import com.zhc.entity.vo.GoodsVo;
import com.zhc.entity.vo.PageGoodsVo;
import com.zhc.mapper.GoodsMapper;
import com.zhc.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsVo> getHotGoodsList(List<Integer> categoryId) {

        List<GoodsVo> list = goodsMapper.findHotGoodsOrderByNum(categoryId);
        return list;
    }

    @Override
    public List<GoodsVo> getGoodsList(Integer categoryId) {

        List<GoodsVo> list = goodsMapper.findGoodsOrderByNum(categoryId);
        return list;
    }

    @Override
    public List<GoodsCategory> getCategoryList() {
        List<GoodsCategory> categoryList = goodsMapper.getCategoryList();
        categoryList.add(0,new GoodsCategory(0,"全部"));
        return  categoryList;
    }

    @Override
    public PageGoodsVo getAllGoodsList(GoodsSelectDto selectParam) {
        System.out.println(selectParam.getGoodsName());
        PageHelper.startPage(selectParam.getCurrentPage(), selectParam.getPageSize());
        Page<GoodsVo> page = goodsMapper.getPageGoods(selectParam);
        PageGoodsVo pageGoodsVo = new PageGoodsVo();
        pageGoodsVo.setTotal(page.getTotal());
        pageGoodsVo.setGoods(page.getResult());
        return pageGoodsVo;
    }

    @Override
    public GoodsVo getById(Integer id) {
        return goodsMapper.getById(id);
    }


}
