package com.gym.dao;

import com.gym.model.Administrador;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * Created by Alejandro on 11/2/2018.
 */
public class AdministradorDaoImplHibernateIDao extends GenericDaoImplHibernate<Administrador> implements AdministradorIDao {
    @Override
    public Administrador get(String username, String password) {
        Session session=this.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT a FROM Administrador a WHERE username = :username AND password = :password");
        query.setParameter("username",username);
        query.setParameter("password", password);
        Administrador administrador = (Administrador)query.uniqueResult();
        session.getTransaction().commit();
        return administrador;
    }
}