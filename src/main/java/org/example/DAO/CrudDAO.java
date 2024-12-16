package org.example.DAO;

import java.util.List;

public interface CrudDAO<T> {
    T add(T t) ;
    List<T> readAll() ;
    T readOne(String code);
    void update(T t);
}
