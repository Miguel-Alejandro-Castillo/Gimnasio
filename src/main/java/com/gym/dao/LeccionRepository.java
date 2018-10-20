package com.gym.dao;

import com.gym.model.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alejandro on 20/10/2018.
 */
@Repository
public interface LeccionRepository extends JpaRepository<Leccion,Long> {
}
