package com.zhc.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsVo {
    private Integer id;
    private String goodsName;
    private String goodsAdvantage;
    private BigDecimal goodsPrice;
    private BigDecimal goodsPriceNew;
    private String goodsParameter;
}
