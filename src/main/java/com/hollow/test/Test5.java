package com.hollow.test;

import com.hollow.entity.Customer;
import com.hollow.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author 刘继涛
 * @version 1.0
 * 测试在配置文件加where  然后在这里查询全部
 */
public class Test5 {
    public static void main(String[] args) {
        //创建Configuration
        Configuration configure = new Configuration().configure();
        //获取到SessionFactory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();

        String hql = "from People";
        Query query = session.createQuery(hql);
        List<People> list = query.list();
        for (People people : list) {
            System.out.println(people);
        }

        session.beginTransaction().commit();

        session.close();
    }
}
