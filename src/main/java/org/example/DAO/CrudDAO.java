package org.example.DAO;

import org.hibernate.Session;

import java.util.List;

public interface CrudDAO<T> {
    T add(T t, Session session) ;
    List<T> readAll(Session session) ;
    T readOne(String code,Session session);
    void update(T t,Session session);
}
