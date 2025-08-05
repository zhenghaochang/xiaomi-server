package com.zhc.mapper;

import com.zhc.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {
    void insertOrder(List<Order> orderList);

    @Select("select * from xiaomi.order where user_id = #{userId} and order_id = #{orderId}")
    List<Order> getByOrderId(Order order);

    void update(Order order);

    @Delete("delete from xiaomi.order where order_id = #{orderIdLong}")
    void remove(Long orderIdLong);

    @Select("select * from xiaomi.order where user_id = #{userId} order by order_time desc")
    List<Order> getListOrderByTime(Integer userId);
}
