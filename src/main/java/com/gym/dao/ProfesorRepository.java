package com.gym.dao;

import com.gym.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by negro
 */
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
    List<Profesor> findByBorrado(boolean isBorrado);
}
