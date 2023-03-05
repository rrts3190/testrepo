package org.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedTut {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Student student = new Student();
        Certificate certi = new Certificate();
        certi.setCertiName("NIIT");
        certi.setScore(80);
        student.setName("Klaus");
        student.setCity("Delhi");
        student.setCerti(certi);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }
}
