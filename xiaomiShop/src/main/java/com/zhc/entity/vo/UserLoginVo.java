package com.zhc.entity.vo;

import lombok.Data;

@Data
public class UserLoginVo {
    /**
     *
     */

    private Integer id;

    /**
     *
     */
    private String username;



    /**
     *
     */
    private String name;


    /**
     * 购物车中的商品数量
     */
    private Integer numInCart;

    /**
     *
     */
    private String token;
}
