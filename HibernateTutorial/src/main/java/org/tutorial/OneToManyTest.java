package org.tutorial;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class OneToManyTest
{
    public static void main(String[] args)
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Question question = new Question();
        Answer answer = new Answer();
        answer.setAnswer("Java is programming language");
        answer.setQuestion(question);

        Answer answer2 = new Answer();
        answer2.setAnswer("Java is programming language2");
        answer2.setQuestion(question);

        question.setQuestion("What is java?");
        question.setAnswers(Arrays.asList(answer, answer2));
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(question);
        session.save(answer2);
        session.save(answer);
        tx.commit();
        session.close();

    }
}
