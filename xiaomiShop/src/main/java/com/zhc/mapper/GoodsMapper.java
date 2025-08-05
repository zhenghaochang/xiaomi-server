package com.zhc.mapper;

import com.github.pagehelper.Page;
import com.zhc.entity.Goods;
import com.zhc.entity.GoodsCategory;
import com.zhc.entity.dto.GoodsSelectDto;
import com.zhc.entity.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<GoodsVo> findHotGoodsOrderByNum(List<Integer> categoryId);

    List<GoodsVo> findGoodsOrderByNum(Integer categoryId);

    @Select("select * from xiaomi.goods_category")
    List<GoodsCategory> getCategoryList();

    Page<GoodsVo> getPageGoods(GoodsSelectDto selectParam);

    @Select("select id,goods_name,goods_advantage,goods_price,goods_price_new,goods_parameter from xiaomi.goods where id = #{id}")
    GoodsVo getById(Integer id);

    List<Goods> findByIds(List<Integer> goodsIds);
}
