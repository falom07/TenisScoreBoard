package org.example;




import org.example.DTO.MatchPlayer;
import org.example.DTO.MatchScore;
import org.example.Entity.Match;
import org.example.Practice.Entity.User;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;

import javax.swing.*;
import java.sql.SQLException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            System.out.println(session.createQuery("select count (m.id) from Match m",Long.class)
                    .getSingleResult());

            session.getTransaction().commit();
        }

//        List<String> listMatch = new ArrayList<>(List.of("Anton", "Vara", "Kola", "Loha", "Vita", "Arsen","Lola"));
//        int pageNumber = 2;
//        int pageSize = 3;
//
//        if(listMatch.size() < pageNumber*pageSize) {
//            listMatch.subList((pageNumber - 1)  * pageSize, listMatch.size()).forEach(System.out::println);
//        }else{
//            listMatch.subList((pageNumber - 1) * pageSize,(pageNumber * pageSize) - 1 ).forEach(System.out::println);
//        }


    }


}