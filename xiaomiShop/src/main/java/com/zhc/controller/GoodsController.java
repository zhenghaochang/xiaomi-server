package com.zhc.controller;


import com.github.pagehelper.PageHelper;
import com.zhc.common.result.Result;
import com.zhc.entity.Goods;
import com.zhc.entity.GoodsCategory;
import com.zhc.entity.dto.GoodsSelectDto;
import com.zhc.entity.vo.GoodsVo;
import com.zhc.entity.vo.PageGoodsVo;
import com.zhc.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("/getHotGoodsList")
    public Result<List<GoodsVo>> getHotGoodsList(@RequestBody List<Integer> categoryId){
        List<GoodsVo> list = goodsService.getHotGoodsList(categoryId);

        return Result.success(list);
    }

    @GetMapping("/getGoodsList")
    public Result<List<GoodsVo>> getGoodsList(Integer categoryId){
        List<GoodsVo> list = goodsService.getGoodsList(categoryId);
        return Result.success(list);
    }

    @GetMapping("/getCategoryList")
    public Result<List<GoodsCategory>> getCategoryList(){
        return Result.success(goodsService.getCategoryList());
    }

    @PostMapping("/getAllGoodsList")
    public Result<PageGoodsVo> getAllGoodsList(@RequestBody GoodsSelectDto selectParam){
        PageGoodsVo pageGoodsVo = goodsService.getAllGoodsList(selectParam);
        return Result.success(pageGoodsVo);
    }

    @GetMapping("/getById")
    public Result<GoodsVo> getById(Integer id){
        return Result.success(goodsService.getById(id));
    }

}
