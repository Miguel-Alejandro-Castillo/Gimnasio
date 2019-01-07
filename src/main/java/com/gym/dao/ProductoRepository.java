package com.gym.dao;

import com.gym.dto.ProductoVentaDTO;
import com.gym.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{

    List<Producto> findByBorradoIsFalse();

    @Query( value = "select new com.gym.dto.ProductoVentaDTO(p.id, p.nombre, p.costo, count(v.id), sum(v.total) ) " +
            "        from  Producto p join p.ventas v" +
            "        on p.borrado = false and (?1 is null or month(v.fecha) = ?1) and (?2 is null or year(v.fecha) = ?2) " +
            "        group by p.id" +
            "        order by p.nombre desc ")
    List<ProductoVentaDTO> listadoProductosVentas(Integer mes, Integer anio);
}
