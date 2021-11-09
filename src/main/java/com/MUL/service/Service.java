package com.MUL.service;

import java.util.List;

public interface  Service<E,T> {
    void save(E entity);
    List<E> getAll();
    E findById(T id);
    void update (E entity);

    void deleteById(T id);
}
