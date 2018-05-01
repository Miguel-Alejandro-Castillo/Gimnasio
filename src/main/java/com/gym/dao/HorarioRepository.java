package com.gym.dao;

import com.gym.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
    //Horario findByHorario_inicioAndHorario_finAndIdNot(String horario_inicio, String horario_fin, Long id);
}
