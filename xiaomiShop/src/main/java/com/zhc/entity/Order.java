package com.zhc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private Integer id;
    private String orderId;
    private Integer userId;
    private Integer goodsId;
    private Integer goodsNumber;
    private BigDecimal goodsPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime orderTime;
    private Integer status;
    private String goodsName;
}
