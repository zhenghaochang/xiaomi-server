package com.zhc.entity.dto;

import lombok.Data;

@Data
public class GoodsSelectDto {
    private Integer categoryId;
    private Integer pageSize;
    private Integer currentPage;
    private String goodsName;
}
