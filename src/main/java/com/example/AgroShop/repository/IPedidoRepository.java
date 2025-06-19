package com.example.AgroShop.repository;

import com.example.AgroShop.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<Pedidos, Long> {
}
