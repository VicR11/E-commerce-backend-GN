package com.example.AgroShop.service;

import com.example.AgroShop.model.Productos;

import java.util.List;

public interface IProductoService {
    List<Productos> obtenerProductos();
    Productos obtenerPorId(Long id);
    void guardarProducto(Productos producto);
    void actualizarProducto(Long id, Productos producto);
    void borrarProducto(Long id);
    List<Productos> obtenerPorNombres(String nombre);
    Productos obtenerPorNombre(String nombre);
}
