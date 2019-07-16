package com.vastika.training.java.jdbc1.basics;

import java.util.List;

public interface CrudeRepository<T> {
    List<T> findAll();
    T findById( int id);
    boolean update(T t);
}
