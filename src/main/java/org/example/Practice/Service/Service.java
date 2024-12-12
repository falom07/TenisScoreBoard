package org.example.Practice.Service;

import lombok.NoArgsConstructor;
import org.example.Practice.Entity.Chat;
import org.example.Practice.Entity.Company;
import org.example.Practice.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Service {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

        public static List<User> getAllUsers() {
            try (Session session = sessionFactory.openSession()) {

                Chat chat = session.get(Chat.class, 1);
                Company company = session.get(Company.class, 1);
                System.out.println();
                return chat.getChatList().stream()
                        .map(chatUser -> User.builder()
                                .id(chatUser.getUser().getId())
                                .username(chatUser.getUser().getUsername())
                                .company(chatUser.getUser().getCompany())
                                .build())
                        .collect(Collectors.toList());
            }
        }

    }

