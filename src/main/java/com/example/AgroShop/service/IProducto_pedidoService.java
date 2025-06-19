package com.example.AgroShop.service;

import com.example.AgroShop.model.Producto_pedido;

import java.util.HashMap;
import java.util.List;

public interface IProducto_pedidoService {

    Producto_pedido guardarRelacion (Producto_pedido producto_pedido);

    List<Producto_pedido> listarTodas();

    Producto_pedido buscarPorId(Long id);

    void eliminarPorId(Long id);

    List<Producto_pedido> findById_pedidos(Long idPedido);

    List<Producto_pedido> findById_producto(Long idProducto);

    void asignarProductosPedido(Long idPedido, HashMap<Long, Integer> idProductos);

    void asignarProductoPedido(Long idPedido, Long idProductos, Integer cantidad);

}
