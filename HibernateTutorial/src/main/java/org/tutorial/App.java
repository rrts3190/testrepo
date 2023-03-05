package org.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        /*Student student = new Student();
        student.setName("Klaus");
        student.setCity("Delhi");
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();*/

        Session getSession = sessionFactory.openSession();
        getSession.beginTransaction();
        Student getStudent = getSession.load(Student.class, 104);
       // System.out.println("----------------------------------------");
        getSession.close();

        Session getSession2 = sessionFactory.openSession();
        getSession2.beginTransaction();
        Student getStudent3 = getSession2.load(Student.class, 104);
       // System.out.println(getStudent3);
        getSession2.close();



        /*Session repeatInsertSession = sessionFactory.openSession();
        Transaction repeatTx = repeatInsertSession.beginTransaction();
        getStudent.setName("Lily");
        repeatInsertSession.persist(getStudent);
        repeatTx.commit();
        repeatInsertSession.close();*/

    }
}
