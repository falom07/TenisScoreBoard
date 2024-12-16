package org.example;


import org.example.Entity.Player;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            save("Loha", session);
            save("Lova", session);
            save("Lina", session);
            save("Soha", session);
            save("Voha", session);
            getByName("Loha", session);

            session.getTransaction().commit();
        }
    }

    private static void save(String playerName,Session session) throws SQLException {
        Player player = Player.builder()
                .name(playerName)
                .build();
//        try(Session session = HibernateUtil.getSessionFactory().openSession()){
//            session.beginTransaction();

            session.persist(player);

//            session.getTransaction().commit();



    }

    private static void update(Long id) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            session.beginTransaction();
            Player player = Player.builder().id(id).build();
//            Player player = session.get(Player.class, id);
            player.setName("Change");
            session.merge(player);
            System.out.println(player);

            session.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("end");

    }

    private static void getAll(Session session) throws SQLException {


            List<Player> list = session.createQuery("select p from Player p", Player.class).list();

            list.forEach(System.out::println);

    }
    private static void getByName(String name,Session session) throws SQLException {
        session.createQuery("select p from Player p where p.name like('L%')", Player.class )
                .list()
                .forEach(System.out::println);

    }

}