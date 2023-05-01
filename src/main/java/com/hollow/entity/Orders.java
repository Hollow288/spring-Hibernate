package com.hollow.entity;

import lombok.Data;

/**
 * @author 刘继涛
 * @version 1.0
 */

@Data
public class Orders {
    private Integer id;
    private String name;
    //因为每个订单要对应一个顾客的信息
    private Customer customer;
}
