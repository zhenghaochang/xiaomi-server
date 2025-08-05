package com.zhc.mapper;

import com.zhc.entity.Goods;
import com.zhc.entity.Order;
import com.zhc.entity.ShoppingCart;
import com.zhc.entity.dto.PayDto;
import com.zhc.entity.vo.ShoppingCartVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    @Select("select COUNT(*) from xiaomi.shopping_cart where user_id=#{userId}")
    Integer findNumByUserId(Integer userId);

    @Insert("insert into xiaomi.shopping_cart (goods_name, goods_id, number, goods_price, create_time, user_id) " +
            "value (#{goodsName},#{goodsId},#{number},#{goodsPrice},#{createTime},#{userId}) ")
    void insert(ShoppingCart shoppingCart);

    @Select("select id, goods_name, goods_id, number, goods_price, user_id from xiaomi.shopping_cart where user_id = #{userId}")
    List<ShoppingCart> getGoodsList(Integer userId);

    @Update("update xiaomi.shopping_cart set number = #{number} where goods_id = #{goodsId}")
    void update(ShoppingCart shoppingCart);

    @Delete("delete from xiaomi.shopping_cart where goods_id = #{goodsId} and user_id = #{userId}")
    void delete(ShoppingCart shoppingCart);

    @Select("select count(*) from xiaomi.shopping_cart where user_id = #{userId}")
    Integer getNumInCart(Integer userId);

    @Select("select * from xiaomi.shopping_cart where user_id = #{userId} and goods_id = #{goodsId}")
    ShoppingCart getByUserId(Integer userId,Integer goodsId);

    @Update("update xiaomi.shopping_cart set number = number+1 where goods_id = #{goodsId} and user_id = #{userId}")
    void addOne(Integer goodsId, Integer userId);

    void deleteAfterPay(List<Integer> scIds,Integer userId);
}
