package com.gym.dao;

import com.gym.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PagoRepository extends JpaRepository<Pago,Long> {

    @Query( value = "select meses.MONTH as mes, coalesce( sum(p.monto),0) as total "+
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
    " left join pagos p on(meses.MONTH = month(p.momento_pago) and year(p.momento_pago) = ?1 ) "+
    " group by meses.MONTH"+
    " order by meses.MONTH ", nativeQuery = true)
    List<Object []>  findGananciasByAnio( Integer anio);

    @Query( value = "select day(p.momento_pago) as dia, sum(p.monto) as total from pagos p where month(p.momento_pago) = ?2 and  year(p.momento_pago) = ?1 group by dia order by dia", nativeQuery = true)
    List<Object []> findGananciasByAnioAndMes(Integer anio, Integer mes);

}
