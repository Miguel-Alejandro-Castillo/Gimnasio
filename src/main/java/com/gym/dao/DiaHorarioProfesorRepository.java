package com.gym.dao;

import com.gym.model.DiaHorarioProfesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaHorarioProfesorRepository extends JpaRepository<DiaHorarioProfesor,Long> {
}
