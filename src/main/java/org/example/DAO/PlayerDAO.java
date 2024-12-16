package org.example.DAO;

import org.example.Entity.Player;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PlayerDAO implements CrudDAO<Player> {
    volatile AtomicInteger i = new AtomicInteger(0);
    private static final Object lock = new Object();
    private static volatile PlayerDAO instance;
    private PlayerDAO() {}
    public static PlayerDAO getInstance() {
        if (instance == null) {
            synchronized (PlayerDAO.class) {
                if (instance == null) {
                    instance = new PlayerDAO();
                }
            }
        }
        return instance;
    }


    @Override
    public Player add(Player player) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            synchronized (lock) {
                var hasPlayer = session.createQuery("select name from Player where name = :name", String.class)
                        .setParameter("name", player.getName())
                        .uniqueResultOptional();

                if (hasPlayer.isEmpty()) {
                    session.persist(player);
                }

            }
            session.getTransaction().commit();
        }

        return player;
    }

    @Override
    public List<Player> readAll() {
        return List.of();
    }

    @Override
    public Player readOne(String code) {
        return null;
    }

    @Override
    public void update(Player o) {

    }
}
