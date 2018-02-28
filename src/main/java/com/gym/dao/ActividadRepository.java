package com.gym.dao;

import com.gym.model.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Negro on 12/2/2018.
 */
@Repository
public interface ActividadRepository extends JpaRepository<Actividad,Long> {
}
