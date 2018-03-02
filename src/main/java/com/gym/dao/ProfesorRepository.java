package com.gym.dao;

import com.gym.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by negro
 */
@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
}
