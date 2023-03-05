package org.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MergeUpdateDiff
{
    public static void main(String[] args) throws InterruptedException {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session1 = sessionFactory.openSession();
        Student student1 = session1.get(Student.class, 1);

        Transaction tx = session1.beginTransaction();
        tx.commit();
        session1.close();


        //Thread.sleep(3000);
        Session session2 = sessionFactory.openSession();
        Student student2 = session2.get(Student.class, 1);
        Transaction tx2 = session2.beginTransaction();
        //student2.setName("tiwari6");
        student1.setName("tiwari60");
        session2.update(student1); // org.hibernate.NonUniqueObjectException
       // session2.merge(student1); //run successfully
        tx2.commit();
        session2.close();
        sessionFactory.close();

    }




}
