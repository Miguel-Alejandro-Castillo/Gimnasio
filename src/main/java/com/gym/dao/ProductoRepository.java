package com.gym.dao;

import com.gym.dto.ProductoVentaDTO;
import com.gym.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{

    List<Producto> findByBorradoIsFalse();


    @Query( value = "select new com.gym.dto.ProductoVentaDTO(p.id, p.nombre, p.costo, count(v.id), sum(v.total) ) " +
            "        from  Producto p join p.ventas v" +
            "        on p.borrado = false" +
            "        group by p.id" +
            "        order by p.nombre desc ")
    List<ProductoVentaDTO> listadoProductosVentasTodo();


    @Query( value = "select new com.gym.dto.ProductoVentaDTO(p.id, p.nombre, p.costo, count(v.id), sum(v.total) ) " +
            "        from  Producto p join p.ventas v" +
            "        on p.borrado = false and (month(v.fecha) = ?1) and (year(v.fecha) = ?2) " +
            "        group by p.id" +
            "        order by p.nombre desc ")
    List<ProductoVentaDTO> listadoProductosVentasAnioMes(Integer mes, Integer anio);

    @Query( value = "select new com.gym.dto.ProductoVentaDTO(p.id, p.nombre, p.costo, count(v.id), sum(v.total) ) " +
            "        from  Producto p join p.ventas v" +
            "        on p.borrado = false and (year(v.fecha) = ?1) " +
            "        group by p.id" +
            "        order by p.nombre desc ")
    List<ProductoVentaDTO> listadoProductosVentasAnio(Integer anio);

    @Query(value = "select * from producto p where p.nombre = 'GASTO GENERAL' or p.nombre = 'PAGO DISTRIBUIDOR' or p.nombre = 'RETIRO DE EFECTIVO'",nativeQuery = true)
    List<Producto> obtenerEgresos();

    @Query(value = "select * from producto p where p.nombre = 'INGRESO DE EFECTIVO'",nativeQuery = true)
    Producto obtenerIngreso();

    @Query( value = "select sum(v.total) " +
            "        from venta v " +
            "        where and (year(v.fecha) = ?1)",nativeQuery = true)
    BigDecimal obtenerTotalAnio(Integer anio);

    @Query( value = "select sum(v.total) " +
            "        from venta v " +
            "        where (month(v.fecha) = ?1) and (year(v.fecha) = ?2)",nativeQuery = true)
    BigDecimal obtenerTotalAnioMes(Integer mes, Integer anio);

    @Query( value = "select sum(v.total) " +
            "        from venta v " +
            "        where (date(v.fecha) = CURRENT_DATE )",nativeQuery = true)
    BigDecimal obtenerTotalHoy();


    /*
    @Query(value = "select p.id, p.nombre, p.costo, count(v.id), count(v.total) from producto p inner join venta v on p.id = v.producto_id where p.borrado = false group by p.id order by p.nombre desc", nativeQuery = true)
    List<ProductoVentaDTO> listadoProductosVentasTodo();
    */

}
