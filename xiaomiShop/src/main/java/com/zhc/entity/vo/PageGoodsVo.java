package com.zhc.entity.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PageGoodsVo {
    private Long total;
    private List<GoodsVo> goods;
}
