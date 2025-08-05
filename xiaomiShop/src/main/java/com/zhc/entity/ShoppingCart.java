package com.zhc.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * 
 * @TableName shopping_cart
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    /**
     * 购物车id
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品id
     */
    private Integer goodsId;

    /**
     * 商品数量
     */
    private Integer number;

    /**
     * 金额
     */
    private BigDecimal goodsPrice;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 用户id
     */
    private Integer userId;
}