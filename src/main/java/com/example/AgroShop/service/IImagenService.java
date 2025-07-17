package com.example.AgroShop.service;

import com.example.AgroShop.model.ImagenProducto;

import java.util.List;

public interface IImagenService {
    ImagenProducto obtenerPorId(Long id);
    List<ImagenProducto> obtenerImagenes();
    void guardarImagen(ImagenProducto imagenProducto);
    void actualizarImagen(Long id, ImagenProducto imagenProducto);
    void borrarImagen(Long id);
}
