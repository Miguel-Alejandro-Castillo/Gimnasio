package com.gym.dao;

import com.gym.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Alejandro on 4/12/2017.
 */
public class GenericDaoImplHibernate<T>  implements GenericDao<T> {
    private SessionFactory sessionFactory;

    public GenericDaoImplHibernate() {
        sessionFactory= HibernateUtil.getSessionFactory();
    }

    protected SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }
    @Override
    public void save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    @Override
    public void update(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        T entity = (T) session.get(getEntityClass(), id);
        if (entity != null) {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public T get(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        T entity = (T) session.get(getEntityClass(), id);
        session.getTransaction().commit();
        return entity;

    }

    @Override
    public List<T> list() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT e FROM " + getEntityClass().getName() + " e");
        List<T> entities = query.list();
        session.getTransaction().commit();
        return entities;
    }
    private Class<T> getEntityClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}