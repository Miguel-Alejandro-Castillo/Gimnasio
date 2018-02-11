package com.gym.dao;
import java.util.List;

public interface GenericDAO<T>{
    public void save(T entity);
    public void update(T entity);
    public void delete(Long id);
    public T get(Long id);
    public List<T> list();
}