package com.zhc.mapper;

import com.zhc.entity.Favorite;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    @Insert("insert into xiaomi.favorite (user_id, goods_id) VALUE " +
            "(#{userId},#{goodsId})")
    void insert(Favorite favorite);

    @Select("select goods_id from xiaomi.favorite where user_id = #{userId}")
    List<Integer> getByUserId(Integer userId);

    @Select("select * from xiaomi.favorite where user_id = #{userId} and goods_id = #{goodsId}")
    Favorite find(Favorite favorite);

    @Delete("delete from xiaomi.favorite where goods_id = #{goodsId} and user_id = #{userId}")
    void remove(Favorite favorite);
}
