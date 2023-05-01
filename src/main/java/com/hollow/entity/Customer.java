package com.hollow.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * @author 刘继涛
 * @version 1.0
 */

@Getter
@Setter
public class Customer {
    private Integer id;
    private String name;
    //一个顾客要对应许多订单，所以用set
    private Set<Orders> orders;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
