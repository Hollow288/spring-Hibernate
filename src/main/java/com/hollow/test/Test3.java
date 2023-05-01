package com.hollow.test;

import com.hollow.entity.Account;
import com.hollow.entity.Course;
import com.hollow.entity.Customer;
import com.hollow.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 刘继涛
 * @version 1.0
 */
public class Test3 {
    public static void main(String[] args) {
        //创建Configuration
        Configuration configure = new Configuration().configure();
        //获取到SessionFactory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        //获取session
        Session session = sessionFactory.openSession();
        //创建course对象
        Course course = new Course();
        course.setName("Java");

        Account account = new Account();
        account.setName("张三");

        Set<Course> courses = new HashSet<>();
        courses.add(course);

        account.setCourses(courses);

        session.save(course);
        session.save(account);

        session.beginTransaction().commit();

        session.close();

    }
}
