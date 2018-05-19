package com.gym.dao;

import com.gym.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface HorarioRepository extends JpaRepository<Horario,Long> {
    Horario findByHoraInicioAndHoraFinAndIdNot(String horaInicio, String horaFin, long id);
}
