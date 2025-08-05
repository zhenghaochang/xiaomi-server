package com.zhc.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShoppingCartVo {
    private Integer id;
    private String goodsName;
    private Integer goodsId;
    private BigDecimal goodsPrice;
    private Integer number;
    private Integer userId;
    private BigDecimal xiaoji;
}
