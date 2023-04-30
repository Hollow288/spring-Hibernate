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
    private Set<Orders> orders;
}
