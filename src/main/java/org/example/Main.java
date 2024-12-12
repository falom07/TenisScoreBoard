package org.example;


import org.example.Entity.Match;
import org.example.Entity.Player;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        extracted();
    }

    private static void extracted() {

        try(SessionFactory sessionFactory = HibernateUtil.getSessionFactory()
                ;Session session = sessionFactory.openSession()){
            session.beginTransaction();
//            Match match = session.get(Match.class, 3);
            Player player = session.get(Player.class, 1);
            System.out.println(player);

            session.getTransaction().commit();

        }

    }

}