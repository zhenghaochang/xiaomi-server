package com.zhc.controller;

import com.zhc.common.context.BaseContext;
import com.zhc.common.result.Result;
import com.zhc.entity.Goods;
import com.zhc.entity.vo.ShoppingCartVo;
import com.zhc.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/insertToCart")
    public Result insertToCart(@RequestBody Goods goods) {

        shoppingCartService.insert(goods);
        return Result.success();
    }

    @GetMapping("/getGoodsList")
    public Result<List<ShoppingCartVo>> getGoodsList() {
        return Result.success(shoppingCartService.getGoodsList());
    }

    @PutMapping("/update")
    public Result update(@RequestBody ShoppingCartVo shoppingCartVo) {
        shoppingCartService.update(shoppingCartVo);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(Integer goodsId) {
        shoppingCartService.delete(goodsId);
        return Result.success();
    }

    @GetMapping("/getNumInCart")
    public Result<Integer> getNumInCart() {
        return Result.success(shoppingCartService.getNumInCart());
    }

    @PostMapping("/getByUserId")
    public Result getByUserId(@RequestBody Goods goods) {
        if(shoppingCartService.getByUserId(goods.getId())){
            return Result.success();
        }else{
            return Result.error("购物车中没有该商品");
        }
    }

    @PostMapping("/addOne")
    public Result addOne(@RequestBody Goods goods) {
        shoppingCartService.addOne(goods);
        return Result.success();
    }

}
