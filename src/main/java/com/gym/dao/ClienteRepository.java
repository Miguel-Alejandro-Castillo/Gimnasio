package com.gym.dao;

import com.gym.model.Administrador;
import com.gym.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alejandro on 12/2/2018.
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
