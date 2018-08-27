package com.gym.dao;

import com.gym.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
@Repository
public interface PagoRepository extends JpaRepository<Pago,Long> {

    @Query( value = "select meses.MONTH as mes, coalesce( sum(p.montoPagado),0) as total "+
     " from  "+
            " (select 1 as MONTH " +
            " union select 2 as MONTH"+
            " union select 3 as MONTH"+
            " union select 4 as MONTH"+
            " union select 5 as MONTH"+
            " union select 6  as MONTH"+
            " union select 7 as MONTH" +
            " union select 8  as MONTH" +
            " union select 9 as MONTH" +
            " union select 10 as MONTH" +
            " union select 11 as MONTH" +
            " union select 12 as MONTH" +
    " ) as meses "+
    " left join pagos p on(meses.MONTH = month(p.momentoPago) and year(p.momentoPago) = ?1 ) "+
    " group by meses.MONTH"+
    " order by meses.MONTH ", nativeQuery = true)
    List<Object []>  findGananciasByAnio( Integer anio);

    @Query( value = "select day(p.momentoPago) as dia, sum(p.montoPagado) as total from pagos p where month(p.momentoPago) = ?2 and  year(p.momentoPago) = ?1 group by dia order by dia", nativeQuery = true)
    List<Object []> findGananciasByAnioAndMes(Integer anio, Integer mes);

    @Query( value = "select meses.MONTH as mes, coalesce( sum(p.montoPagado),0) as total "+
            " from  "+
            " (select 1 as MONTH " +
            " union select 2 as MONTH"+
            " union select 3 as MONTH"+
            " union select 4 as MONTH"+
            " union select 5 as MONTH"+
            " union select 6  as MONTH"+
            " union select 7 as MONTH" +
            " union select 8  as MONTH" +
            " union select 9 as MONTH" +
            " union select 10 as MONTH" +
            " union select 11 as MONTH" +
            " union select 12 as MONTH" +
            " ) as meses "+
            " left join pagos p  on(meses.MONTH = month(p.momentoPago) and year(p.momentoPago) = ?1 and p.id = ?2 ) "+
            " group by meses.MONTH"+
            " order by meses.MONTH ", nativeQuery = true)
    List<Object[]> findGananciasByAnioAndIdActividad(Integer anio, Integer idActividad);

    @Query( value = "select day(p.momentoPago) as dia, sum(p.montoPagado) as total from pagos p where month(p.momentoPago) = ?2 and  year(p.momentoPago) = ?1 and p.id = ?3 group by dia order by dia", nativeQuery = true)
    List<Object[]> findGananciasByAnioAndMesAndIdActividad(Integer anio, Integer mes, Integer idActividad);

    /*
    @Query( value = "select distinct year(p.momentoPago) as anio from Pago p where p.montoPagado > 0 order by anio asc")
    List<Integer> aniosConAlMenosUnPago();

    @Query( value = " select year(p.momentoPago) as anio, sum(p.montoPagado) as total" +
                    " from Pago p" +
                    " where p.montoPagado > 0 and (?1 is null or month(p.momentoPago) = ?1) and (?2 is null or p.actividad_id = ?2)" +
                    " group by anio" +
                    " order by anio")
    Map<Integer, BigDecimal> gananciasAnuales(Integer mes, Long idActividad);



    @Query( value = "select meses.mes as mes, coalesce( sum(p.montoPagado),0) as total "+
            " from  "+
            " (select 1 as mes " +
            " union select 2 as mes"+
            " union select 3 as mes"+
            " union select 4 as mes"+
            " union select 5 as mes"+
            " union select 6 as mes"+
            " union select 7 as mes" +
            " union select 8 as mes" +
            " union select 9 as mes" +
            " union select 10 as mes" +
            " union select 11 as mes" +
            " union select 12 as mes" +
            " ) as meses "+
            " left join pagos p  on(meses.mes = month(p.momentoPago) and (?1 is null or year(p.momentoPago) = ?1) and ( ?2 is null or p.actividad_id = ?2) "+
            " group by meses.mes"+
            " order by meses.mes", nativeQuery = true)
    Map<Integer, BigDecimal> gananciasMensuales(Integer anio, Long idActividad);


    Map<Integer, BigDecimal> gananciasDiarias(Integer anio, Integer mes, Long idActividad);
    */
}
