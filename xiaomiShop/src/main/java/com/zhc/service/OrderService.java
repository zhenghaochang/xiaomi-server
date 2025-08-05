package com.zhc.service;

import com.zhc.entity.Order;
import com.zhc.entity.dto.PayDto;

import java.util.List;

public interface OrderService {
    void insertOrder(List<Order> orderList);

    List<Order> getByOrderId(String orderId);

    void pay(PayDto payDto);

    void remove(String orderId);

    List<List<Order>> getCardList();
}
