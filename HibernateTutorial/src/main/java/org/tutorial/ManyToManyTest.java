package org.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class ManyToManyTest
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Employee employee = new Employee();
        employee.setName("Ramesh");

        Employee employee2 = new Employee();
        employee2.setName("Aman");

        Project project = new Project();
        project.setProjectName("Akela");
        project.setEmployees(Arrays.asList(employee2, employee));
        Project project2 = new Project();
        project2.setProjectName("VS");

        project.setEmployees(Arrays.asList(employee2, employee));
        employee.setProjects(Arrays.asList(project, project2));




        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(project2);
        session.save(project);
        session.save(employee2);
        session.save(employee);
        tx.commit();
        session.close();

    }
}
