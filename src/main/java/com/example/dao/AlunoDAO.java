package com.example.dao;

import com.example.model.Aluno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AlunoDAO {
    private final SessionFactory sessionFactory;

    public AlunoDAO() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void save(Aluno aluno) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(aluno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Aluno> list() {
        Session session = sessionFactory.openSession();
        List<Aluno> alunos = session.createQuery("from Aluno", Aluno.class).list();
        session.close();
        return alunos;
    }

    public List<Aluno> findByNomeStartingWith(String letra) {
        Session session = sessionFactory.openSession();
        List<Aluno> alunos = session.createQuery("from Aluno where nome like :letra", Aluno.class)
                .setParameter("letra", letra + "%").list();
        session.close();
        return alunos;
    }
}
