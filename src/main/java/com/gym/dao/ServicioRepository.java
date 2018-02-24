package com.gym.dao;

import com.gym.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alejandro on 12/2/2018.
 */
@Repository
public interface ServicioRepository extends JpaRepository<Servicio,Long> {
}
