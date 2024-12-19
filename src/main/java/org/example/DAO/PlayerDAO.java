package org.example.DAO;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.Entity.Player;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlayerDAO implements CrudDAO<Player> {
    volatile AtomicInteger i = new AtomicInteger(0);
    private static final Object lock = new Object();
    private static volatile PlayerDAO instance;

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
        synchronized (lock) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

                session.beginTransaction();
                Long idPlayer = session.createQuery("select id from Player where name = :name", Long.class)
                        .setParameter("name", player.getName())
                        .uniqueResult();

                if (idPlayer == null) {
                    session.persist(player);
                }else{
                    player.setId(idPlayer);
                }
                session.getTransaction().commit();

        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error adding player " + player.getName(), e);
        }
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
