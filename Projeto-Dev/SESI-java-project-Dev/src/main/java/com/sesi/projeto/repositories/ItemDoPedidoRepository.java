package com.sesi.projeto.repositories;

import com.sesi.projeto.entities.ItemDoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDoPedidoRepository extends JpaRepository<ItemDoPedido, Long> {
}
