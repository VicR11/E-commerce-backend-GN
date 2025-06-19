package com.example.AgroShop.repository;

import com.example.AgroShop.model.Producto_pedido;
import com.example.AgroShop.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProducto_pedidoRepository extends JpaRepository<Producto_pedido, Long> {
    List<Producto_pedido> findByPedidosId(Long id);

    List<Producto_pedido> findByProductosId(Long id);
}
