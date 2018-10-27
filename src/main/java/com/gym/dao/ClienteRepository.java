package com.gym.dao;

import com.gym.dto.PagoClienteDTO;
import com.gym.model.Cliente;
import com.gym.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    List<Cliente> findByBorrado(boolean isBorrado);

    @Query(value = "select p from Cliente c join c.pagos p on c.id = ?1 and p.id = ?2")
    Pago findPagoByIdClienteAndIdPago(Long idCliente, Long idPago);

    @Query( value = "select p.montoAPagar from Cliente c join c.pagos p on c.id = ?1 and p.id = ?2")
    BigDecimal findMontoAPagarByIdPago(Long idCliente, Long idPago);

    @Query( value = "select new com.gym.dto.PagoClienteDTO(concat(c.nombre, ' ', c.apellido), p.actividad.nombre, p.momentoPago, p.montoAPagar, p.montoPagado, p.fechaDesde, p.fechaHasta) " +
            " from Cliente c join c.pagos p " +
            " on (?1 is null or month(p.momentoPago) = ?1) and (?2 is null or p.actividad.id = ?2) " +
            " order by p.momentoPago desc")
    List<PagoClienteDTO> listadoGananciasAnuales(Integer mes, Long idActividad);

    @Query( value = " select new com.gym.dto.PagoClienteDTO(concat(c.nombre, ' ', c.apellido), p.actividad.nombre, p.momentoPago, p.montoAPagar, p.montoPagado, p.fechaDesde, p.fechaHasta)" +
            " from Cliente c join c.pagos p" +
            " on (?1 is null or year(p.momentoPago) = ?1) and ( ?2 is null or p.actividad.id = ?2) " +
            " order by p.momentoPago desc ")
    List<PagoClienteDTO> listadoGananciasMensuales(Integer anio, Long idActividad);

    @Query(value = " select new com.gym.dto.PagoClienteDTO(concat(c.nombre, ' ', c.apellido), p.actividad.nombre, p.momentoPago, p.montoAPagar, p.montoPagado, p.fechaDesde, p.fechaHasta)" +
            " from Cliente c join c.pagos p" +
            " on year(p.momentoPago) = ?1 and month(p.momentoPago) = ?2 and (?3 is null or p.actividad.id = ?3) " +
            " order by p.momentoPago desc " )
    List<PagoClienteDTO> listadoGananciasDiarias(Integer anio, Integer mes, Long idActividad);

}
