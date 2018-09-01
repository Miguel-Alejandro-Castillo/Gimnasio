package com.gym.dao;

import com.gym.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago,Long> {

    @Query( value = "select distinct year(p.momentoPago) as anio from Pago p order by anio asc")
    List<Integer> aniosConAlMenosUnPago();


    @Query( value = "select year(p.momentoPago) as anio, sum(p.montoPagado) as total" +
                    " from pagos p" +
                    " where (?1 is null or month(p.momentoPago) = ?1) and (?2 is null or p.actividad_id = ?2)" +
                    " group by anio" +
                    " order by anio", nativeQuery = true)
    List<Object[]> gananciasAnuales(Integer mes, Long idActividad);

    @Query( value = "select meses.nombre as  mes, coalesce( sum(p.montoPagado),0) as total"+
            " from  "+
            " (select 1 numero, 'Enero' nombre" +
            " union select 2, 'Febrero'"+
            " union select 3, 'Marzo'"+
            " union select 4, 'Abril'"+
            " union select 5, 'Mayo'"+
            " union select 6, 'Junio'"+
            " union select 7, 'Julio'" +
            " union select 8, 'Agosto'" +
            " union select 9, 'Agosto'" +
            " union select 10, 'Octubre'" +
            " union select 11, 'Noviembre'" +
            " union select 12, 'Diciembre'" +
            " ) as meses "+
            " left join pagos p on (meses.numero = month(p.momentoPago)) and (?1 is null or year(p.momentoPago) = ?1) and ( ?2 is null or p.actividad_id = ?2) "+
            " group by meses.numero", nativeQuery = true)
    List<Object[]> gananciasMensuales(Integer anio, Long idActividad);



    @Query(value = " select dias.dia, coalesce( sum(p.montoPagado), 0) total " +
                   " from (select day(a.Date) dia " +
                   "       from (select last_day(date_add(makedate(:anio, 1), interval (:mes)-1 month)) - interval (a.a + (10 * b.a) + (100 * c.a)) day as Date " +
                   "            from (select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9) as a " +
                   "                  cross join (select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9) as b " +
                   "                  cross join (select 0 as a union all select 1 union all select 2 union all select 3 union all select 4 union all select 5 union all select 6 union all select 7 union all select 8 union all select 9) as c " +
                   "           ) a " +
                   "       where a.Date between date_add(date_add(last_day(date_add(makedate(:anio, 1), interval (:mes)-1 month)), interval 1 day), interval - 1 month) and last_day(date_add(makedate(:anio, 1), interval (:mes)-1 month)) order by dia " +
                   "      ) dias " +
                   "     left join pagos p on dias.dia = day(p.momentoPago) and year(p.momentoPago) = :anio and month(p.momentoPago) = :mes and (:idActividad is null or p.actividad_id = :idActividad) " +
                   " group by dias.dia " +
                   " order by dias.dia;", nativeQuery = true)
    List<Object[]> gananciasDiarias(@Param("anio") Integer anio, @Param("mes") Integer mes, @Param("idActividad") Long idActividad);

}
