package com.hollow.entity;

import lombok.Data;

import java.util.Set;

/**
 * @author 刘继涛
 * @version 1.0
 */

@Data
public class Customer {
    private Integer id;
    private String name;
    //一个顾客要对应许多订单，所以用set
    private Set<Orders> orders;
}
