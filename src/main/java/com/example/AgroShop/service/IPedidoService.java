package com.example.AgroShop.service;

import com.example.AgroShop.model.Pedidos;

import java.util.List;

public interface IPedidoService {
    List<Pedidos> obtenerPedidos();
    Pedidos obtenerPorId(Long id);
    void guardarPedido(Pedidos pedido);
    void actualizarPedido(Long id, Pedidos pedido);
    void borrarPedido(Long id);
}
