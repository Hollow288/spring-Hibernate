package com.hollow.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 刘继涛
 * @version 1.0
 */

@Getter
@Setter
public class Orders {
    private Integer id;
    private String name;
    //因为每个订单要对应一个顾客的信息
    private Customer customer;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Orders{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
