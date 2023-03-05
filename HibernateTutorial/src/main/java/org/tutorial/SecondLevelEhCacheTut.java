package org.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SecondLevelEhCacheTut
{
    public static void main(String[] args) throws InterruptedException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Student student1 = session1.get(Student.class, 1);
        System.out.println(student1);
        session1.close();
        Session session2 = sessionFactory.openSession();
        Student student2 = session2.get(Student.class, 1);
        System.out.println(student2);
        session2.close();

    }




}
