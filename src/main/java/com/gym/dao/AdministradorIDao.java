package com.gym.dao;

import com.gym.model.Administrador;

/**
 * Created by Alejandro on 11/2/2018.
 */
public interface AdministradorIDao extends GenericDao<Administrador> {
    public Administrador get(String username,String password);
}
