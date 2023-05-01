package com.hollow.test;

import com.hollow.entity.Customer;
import com.hollow.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 刘继涛
 * @version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        //创建Configuration
        Configuration configure = new Configuration().configure();
        //获取到SessionFactory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();
        //创建Customer对象
        Customer customer = new Customer();
        customer.setName("张三");

        //创建 Orders
        Orders orders = new Orders();
        orders.setName("订单1");

        //建立关联关系
        orders.setCustomer(customer);

        //保存
        session.save(customer);
        session.save(orders);

        //提交事务
        session.beginTransaction().commit();

        session.close();
    }
}
