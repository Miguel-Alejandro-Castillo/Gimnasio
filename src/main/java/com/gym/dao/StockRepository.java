package com.gym.dao;


import com.gym.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query(value = "DELETE FROM stocks WHERE stocks.id = ?1",nativeQuery = true)
    Void borrarStockById(Long id_stock);

    @Query(value = "SELECT * FROM stocks WHERE stocks.producto_id = ?1 ORDER BY stocks.fechaIngreso DESC LIMIT 1",
    nativeQuery = true)
    List<Stock> obtenerUltimoStock(Long id_producto);

    @Query(value = "SELECT COUNT(*) FROM venta INNER JOIN stocks ON venta.producto_id = stocks.producto_id WHERE\n" +
            "venta.producto_id = ?1 AND venta.fecha >\n" +
            "(SELECT s.fechaIngreso from stocks s ORDER BY s.fechaIngreso DESC LIMIT 1)",nativeQuery = true)
    Integer vendidosDesdeElUltimoStock(Long id_producto);

    @Query(value = "SELECT * FROM stocks WHERE stocks.producto_id = ?1 ORDER BY stocks.fechaIngreso",
            nativeQuery = true)
    List<Stock> obtenerStocks(Long id_producto);

}
