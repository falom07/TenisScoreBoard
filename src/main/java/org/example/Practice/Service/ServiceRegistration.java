package org.example.Practice.Service;

import org.example.Practice.DTO.UserDTO;
import org.example.Practice.Entity.Company;
import org.example.Practice.Entity.User;
import org.example.Practice.Entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ServiceRegistration {
    private static final SessionFactory sessionFactory;
    static {
        sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }
    public static int saveUser(UserDTO userDTO) {
        System.out.println(userDTO.getBirthday());
        int userId = -1;
        try (Session session = sessionFactory.openSession()) {


            session.beginTransaction();
            Company company = session.get(Company.class, userDTO.getCompany());
            User user = User.builder()
                    .username(userDTO.getUsername())
                    .company(company)
                    .build();
            UserInfo userInfo = UserInfo.builder()
//                    .user(user)
                    .address(userDTO.getAddress())
                    .birthday(userDTO.getBirthday())
                    .build();

            session.save(user);
            session.save(userInfo);
            userId = user.getId();
            session.getTransaction().commit();
        }
        return userId;
    }

}
