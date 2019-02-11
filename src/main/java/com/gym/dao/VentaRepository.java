package com.gym.dao;

import com.gym.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long>{

    @Query( value = "select distinct year(v.fecha) as anio from  Venta v order by anio asc")
    List<Integer> aniosConAlMenosUnaVenta();

    @Query(value = "select * from venta where producto_id = ?1 order by fecha desc limit 10", nativeQuery = true)
    List<Venta> obtenerUltimasVentas(Long id_producto);
}
