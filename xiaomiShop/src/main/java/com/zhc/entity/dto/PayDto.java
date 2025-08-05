package com.zhc.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class PayDto {
    private List<Integer> scIds;
    private String orderId;
}
