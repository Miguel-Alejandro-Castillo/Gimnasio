package com.gym.dao;
import com.gym.model.Cobro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CobroRepository extends JpaRepository<Cobro,Long> {

    List<Cobro> findByProfesorId(Long profesorId);
}
