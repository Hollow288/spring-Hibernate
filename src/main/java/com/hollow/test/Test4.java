package com.hollow.test;

import com.hollow.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 刘继涛
 * @version 1.0
 * 测试延迟加载
 */
public class Test4 {
    public static void main(String[] args) {
        //创建Configuration
        Configuration configure = new Configuration().configure();
        //获取到SessionFactory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();

        Customer customer = session.get(Customer.class, 1);

//        System.out.println(customer);
        System.out.println(customer.getOrders());

        session.close();
    }
}
