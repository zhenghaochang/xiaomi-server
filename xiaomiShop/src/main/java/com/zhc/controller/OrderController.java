package com.zhc.controller;


import com.zhc.common.constant.OrderConstant;
import com.zhc.common.context.BaseContext;
import com.zhc.common.result.Result;
import com.zhc.entity.Goods;
import com.zhc.entity.Order;
import com.zhc.entity.dto.PayDto;
import com.zhc.entity.vo.ShoppingCartVo;
import com.zhc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/insertOrder")
    public Result<String> insertOrder(@RequestBody List<ShoppingCartVo> selectList) {
        /*System.out.println(selectList);
        return Result.success();*/
        if(selectList.size()!=0){
            Long orderIdLong = Math.abs(UUID.randomUUID().getMostSignificantBits());
            String orderId = String.valueOf(orderIdLong);
            List<Order> orderList = new ArrayList<>();
            for (ShoppingCartVo sc : selectList) {
                Order order = new Order();
                order.setOrderId(orderId);
                order.setGoodsId(sc.getGoodsId());
                order.setUserId(sc.getUserId());
                order.setGoodsNumber(sc.getNumber());
                order.setGoodsName(sc.getGoodsName());
                order.setGoodsPrice(sc.getGoodsPrice());
                order.setOrderTime(LocalDateTime.now());
                order.setStatus(OrderConstant.NO_PAY);
                orderList.add(order);
            }
            orderService.insertOrder(orderList);
            return Result.success(String.valueOf(orderId));
        }else{
            return Result.error("无订单");
        }
    }

    @GetMapping("/getByOrderId")
    public Result<List<Order>> getByOrderId(@RequestParam("orderId") String orderId) {
        List<Order> list = orderService.getByOrderId(orderId);
        return Result.success(list);
    }

    @PostMapping("/pay")
    public Result pay(@RequestBody PayDto payDto) {
        orderService.pay(payDto);
        return Result.success();
    }

    @GetMapping("/remove")
    public Result remove(@RequestParam("orderId") String orderId) {
        orderService.remove(orderId);
        return Result.success();
    }

    @GetMapping("/getCardList")
    public Result<List<List<Order>>> getCardList() {
        List<List<Order>> cardList = orderService.getCardList();
        return Result.success(cardList);
    }



}
