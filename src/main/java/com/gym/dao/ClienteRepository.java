package com.gym.dao;

import com.gym.model.Cliente;
import com.gym.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    List<Cliente> findByBorrado(boolean isBorrado);

    @Query(value = "select p from Cliente c join c.pagos p on c.id = ?1 and p.id = ?2")
    Pago findPagoByIdClienteAndIdPago(Long idCliente, Long idPago);
}
