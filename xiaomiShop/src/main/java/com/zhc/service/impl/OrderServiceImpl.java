package com.zhc.service.impl;

import com.zhc.common.context.BaseContext;
import com.zhc.entity.Order;
import com.zhc.entity.ShoppingCart;
import com.zhc.entity.dto.PayDto;
import com.zhc.mapper.OrderMapper;
import com.zhc.mapper.ShoppingCartMapper;
import com.zhc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void insertOrder(List<Order> orderList) {
        System.out.println(orderList);
        orderMapper.insertOrder(orderList);
    }

    @Override
    public List<Order> getByOrderId(String orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(BaseContext.getCurrentId());
        List<Order> list = orderMapper.getByOrderId(order);
        return list;
    }

    @Override
    public void pay(PayDto payDto) {
        String orderId = payDto.getOrderId();
        List<Integer> scIds = payDto.getScIds();
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(BaseContext.getCurrentId());
        order.setStatus(1);
        orderMapper.update(order);
/*        System.out.println(payDtoList);*/
        shoppingCartMapper.deleteAfterPay(scIds,BaseContext.getCurrentId());
    }

    @Override
    public void remove(String orderId) {
        Long orderIdLong = Long.valueOf(orderId);
        orderMapper.remove(orderIdLong);
    }

    @Override
    public List<List<Order>> getCardList() {
        Integer userId = BaseContext.getCurrentId();
        List<Order> orderList = orderMapper.getListOrderByTime(userId);
        /*for (Order order : orderList) {
            String s = String.valueOf(order.getOrderId());
            order.setOrderId(s);
        }*/
        // 按 orderId 分组
        Map<String, List<Order>> orderMap = orderList.stream()
                .collect(Collectors.groupingBy(Order::getOrderId,LinkedHashMap::new,Collectors.toList()));
        List<List<Order>> groupedOrders = new ArrayList<>(orderMap.values());
        return groupedOrders;
    }
}
