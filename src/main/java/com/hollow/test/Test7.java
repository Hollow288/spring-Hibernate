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
 * HQL语句
 */
public class Test7 {
    public static void main(String[] args) {
        //创建Configuration
        Configuration configure = new Configuration().configure();
        //获取到SessionFactory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();

        // 查对象 注意这里写的People是类名,注意大小写
//        String hql = "from People";
//        Query query = session.createQuery(hql);
//        List<People> list = query.list();
//        for (People people : list) {
//            System.out.println(people);
//        }


        //分页
//        1. setFirstResult() 设置起始下标
//        2. setMaxResult() 设置截取长度
//        String hql = "from People";
//        Query query = session.createQuery(hql);
//        query.setFirstResult(1);
//        query.setMaxResults(3);
//        List<People> list = query.list();
//        for (People people : list) {
//            System.out.println(list);
//        }

        //where 查询
//        String hql = "from People where id = 3";
//        Query query = session.createQuery(hql);
//        //.list取出的是一个集合，此时集合只有一个对象，通过下标0取出对象,没有对象就会报错
////        People people = (People) query.list().get(0);
//        //这样不会报错
//        People people = (People) query.uniqueResult();
//        System.out.println(people);


        //模糊查询
//        String hql = "from People where name like '%三%'";
//        Query query = session.createQuery(hql);
//        List<People> list = query.list();
//        for (People people : list) {
//            System.out.println(people);
//        }

        //排序
//        String hql = "from People order by id";
//        Query query = session.createQuery(hql);
//        List<People> list = query.list();
//        for (People people : list) {
//            System.out.println(people);
//        }

        //查单个属性
//        String hql = "select name from People where id = 4";
//        Query query = session.createQuery(hql);
//        String name = (String)query.uniqueResult();
//        System.out.println(name);

        //占位符
//        String hql = "from People where name = :name";
//        Query query = session.createQuery(hql);
//        //不推荐使用这个 一会儿问问chatgpt为什么 答案是使用Query.setParameter()方法来设置查询参数
//        query.setString("name","张三");
//        List<People> list = query.list();
//        for (People people : list) {
//            System.out.println(list);
//        }

        //级联查询
        String hql = "from Customer where name = :name";
        Query query = session.createQuery(hql);
        query.setString("name","张三");
        Customer customer = (Customer)query.uniqueResult();
        String hql2 = "from Orders where customer = :customer";
        Query query2 = session.createQuery(hql2);
        query2.setEntity("customer",customer);
        List<Orders> list = query2.list();

        System.out.println(list);
//        for (Orders orders : list) {
//            System.out.println(list);
//        }


        session.close();
    }
}
