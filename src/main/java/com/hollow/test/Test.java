package com.hollow.test;

import com.hollow.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 刘继涛
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        //创建Configuration
        //这里默认加载的是hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        //如果我们配置文件的名字变了
//        Configuration configuration = new Configuration().configure("在这里指定名字");
        System.out.println(configuration);
        //获取SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();
        People people = new People();
        people.setName("张三");
        people.setMoney(1000.0);
        session.save(people);
        //这里因为我们java下的xml文件是读不到的，所以要在pom文件加设置
        //但是这里我按教程的加上后,又显示找不到hibernate.cfg.xml了，索性直接把映射类放到resources下
        session.beginTransaction().commit();
        session.close();
    }
}
