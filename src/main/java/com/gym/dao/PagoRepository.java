package com.gym.dao;

import com.gym.model.Pago;
import com.gym.util.MesGanancia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago,Long> {
    @Query( value = "SELECT meses.MONTH AS mes, coalesce( SUM(p.monto),0) AS total "+
     " FROM  "+
            " (SELECT 1 AS MONTH " +
            " UNION SELECT 2 AS MONTH"+
            " UNION SELECT 3 AS MONTH"+
            " UNION SELECT 4 AS MONTH"+
            " UNION SELECT 5 AS MONTH"+
            " UNION SELECT 6  AS MONTH"+
            " UNION SELECT 7 AS MONTH" +
            " UNION SELECT 8  AS MONTH" +
            " UNION SELECT 9 AS MONTH" +
            " UNION SELECT 10 AS MONTH" +
            " UNION SELECT 11 AS MONTH" +
            " UNION SELECT 12 AS MONTH" +
    " ) AS meses "+
    " LEFT JOIN pagos p ON(meses.MONTH = MONTH(p.momento_pago) AND YEAR(p.momento_pago) = :anio ) "+
    " GROUP BY meses.MONTH"+
    " ORDER BY meses.MONTH ", nativeQuery = true)
    List<MesGanancia> findGananciasByAnio(@Param("anio") Integer anio);
}
