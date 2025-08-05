package com.zhc.controller;

import com.zhc.common.result.Result;
import com.zhc.entity.Favorite;
import com.zhc.entity.Goods;
import com.zhc.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/insertToFavorite")
    public Result insertToFavorite(@RequestBody Goods goods) {
        favoriteService.insert(goods);
        return Result.success();
    }

    @GetMapping("/getMyCollection")
    public Result<List<Goods>> getMyCollection() {
        List<Goods> list = favoriteService.getMyCollection();
        return Result.success(list);
    }

    @GetMapping("/findInCollection")
    public Result findInCollection(Integer goodsId) {
        Favorite favorite = favoriteService.findByGoodsId(goodsId);
        if(favorite != null) {
            return Result.success();
        }else{
            return Result.error("未收藏");
        }
    }

    @DeleteMapping("/remove")
    public Result remove(Integer goodsId) {
        favoriteService.remove(goodsId);
        return Result.success();
    }

}
