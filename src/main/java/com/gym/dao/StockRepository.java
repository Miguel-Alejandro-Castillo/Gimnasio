package com.gym.dao;

import com.gym.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Query(value = "SELECT * FROM stocks WHERE stocks.producto_id = ?1 ORDER BY stocks.fechaIngreso DESC LIMIT 1",
    nativeQuery = true)
    List<Stock> obtenerUltimoStock(Long id_producto);
}
