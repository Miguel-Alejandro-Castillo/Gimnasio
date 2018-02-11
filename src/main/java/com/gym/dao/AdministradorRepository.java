package com.gym.dao;

import com.gym.model.Administrador;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alejandro on 10/2/2018.
 */
@Repository
public interface AdministradorRepository  extends PagingAndSortingRepository<Administrador,Long> {

}
