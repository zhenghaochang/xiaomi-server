package com.zhc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    private Integer id;

    private String goodsName;

    private String goodsDescription;

    private String goodsAdvantage;

    private BigDecimal goodsPrice;

    private Integer categoryId;

    private Integer goodsNum;

    private BigDecimal goodsPriceNew;

    private String goodsParameter;
}
