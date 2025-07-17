package com.example.AgroShop.service;

import com.example.AgroShop.model.ImagenProducto;
import com.example.AgroShop.repository.IImagenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagenService implements IImagenService{

    IImagenRepository imagenRepository;

    @Override
    public ImagenProducto obtenerPorId(Long id) {
        return imagenRepository.findById(id).orElse(null);
    }

    @Override
    public List<ImagenProducto> obtenerImagenes() {
        return imagenRepository.findAll();
    }

    @Override
    public void guardarImagen(ImagenProducto imagenProducto) {
            imagenRepository.save(imagenProducto);
    }

    @Override
    public void actualizarImagen(Long id, ImagenProducto imagenProducto) {
        ImagenProducto imagenActual = imagenRepository.findById(id).orElse(null);
        if(imagenActual != null){
            imagenActual.setUrlImagen(imagenProducto.getUrlImagen());
            imagenRepository.save(imagenActual);
        }

    }

    @Override
    public void borrarImagen(Long id) {
         imagenRepository.deleteById(id);
    }
}
