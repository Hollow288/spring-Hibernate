package com.hollow.test;

import com.hollow.entity.Customer;
import com.hollow.entity.Orders;
import com.hollow.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

/**
 * @author 刘继涛
 * @version 1.0
 * 测试级联关系
 * 可以在customer里面设置
 *         <!--级联删除：这里可以添加一个cascade="delete" 来设置级联删除-->
 *         <!--就是删除记录时如果有外键，就把那张表关联的也删了-->
 */
public class Test6 {
    public static void main(String[] args) {
        //创建Configuration
        Configuration configure = new Configuration().configure();
        //获取到SessionFactory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();

        Customer customer = session.get(Customer.class, 1);
        //我们直接删会报错因为有外键原因
//        session.delete(customer);

        //我们需要这样删除
        Iterator<Orders> iterator = customer.getOrders().iterator();

        //这样先把orders取出来都删了
        while (iterator.hasNext()) {
            session.delete(iterator.next());
        }

        //再删customer
        session.delete(customer);
        session.beginTransaction().commit();

        session.close();
    }
}
