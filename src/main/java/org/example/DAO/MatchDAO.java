package org.example.DAO;

import org.example.Entity.Match;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MatchDAO implements CrudDAO<Match> {
    private static volatile MatchDAO instance;
    private MatchDAO() {}
    public static MatchDAO getInstance() {
        if (instance == null) {
            synchronized (MatchDAO.class) {
                if (instance == null) {
                    instance = new MatchDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public Match add(Match match) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();


            session.persist(match);

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return match;
    }

    @Override
    public List<Match> readAll() {
        return List.of();
    }

    @Override
    public Match readOne(String code) {
        return null;
    }

    @Override
    public void update(Match match) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            System.out.println(match);
            session.merge(match);
            System.out.println(match);

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
