package org.example.DAO;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.Entity.Match;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MatchDAO implements CrudDAO<Match> {
    private static volatile MatchDAO instance;

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
    public Match add(Match match,Session session) {

        try {
            session.beginTransaction();


            session.persist(match);

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding match ", e);
        }
        return match;
    }
    @Override
    public List<Match> readAll(Session session) {
        return List.of();
    }


    public List<Match> readAllWithSize(int sizeList, int numFirstData,Session session) {
        List<Match> matchList;
        try {
            session.beginTransaction();

            matchList = session.createQuery(
                    "select m from Match m " +
                            "join fetch m.player1 " +
                            "join fetch m.player2 " +
                            "join fetch m.winner",Match.class)
                        .setMaxResults(sizeList)
                        .setFirstResult((numFirstData - 1) * sizeList)
                        .list();

            session.getTransaction().commit();
        }catch (Exception e){
            throw new RuntimeException("Error reading all matches ", e);
        }
        return matchList;
    }



    @Override
    public Match readOne(String code,Session session) {
        return null;
    }

    @Override
    public void update(Match match,Session session) {
        try {
            session.beginTransaction();

            System.out.println(match);
            session.merge(match);
            System.out.println(match);

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error update match ", e);
        }

    }

    public List<Match> readAllByNameWithSize(String nameFilter, int sizeList, int numFirstData,Session session) {
        List<Match> matchList;
        try {
            session.beginTransaction();


            matchList = session.createQuery(
                      "select m from Match m" +
                                " join fetch m.player1 p1" +
                                " join fetch m.player2 p2" +
                                " join fetch m.winner" +
                                " where LOWER(p1.name) LIKE :nameFilter or LOWER(p2.name) LIKE :nameFilter",Match.class)
                        .setParameter("nameFilter", "%" + nameFilter.toLowerCase() + "%")
                        .setMaxResults(sizeList)
                        .setFirstResult((numFirstData - 1) * sizeList)
                        .list();

            session.getTransaction().commit();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error take match by name " + nameFilter, e);
        }
        return matchList;
    }

    public Long countDataInTable(Session session) {
        Long result;
        try{
            session.beginTransaction();

            result = session.createQuery("select count (m.id) from Match m",Long.class)
                    .getSingleResult();

            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error counting matches ", e);
        }
        return result;
    }
}
