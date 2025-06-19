package com.example.AgroShop.service;

import com.example.AgroShop.model.Productos;
import com.example.AgroShop.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productosRepository;

    public ProductoService(IProductoRepository productosRepository){
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> obtenerProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos obtenerPorId(Long id) {
        return productosRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarProducto(Productos producto) {
        productosRepository.save(producto);
    }

    @Override
    public void actualizarProducto(Long id, Productos producto) {
        Productos productosExistente = productosRepository.findById(id).orElse(null);

        if (productosExistente != null){
            productosExistente.setNombre(producto.getNombre());
            productosExistente.setPrecio(producto.getPrecio());
            productosExistente.setDescripcion(producto.getDescripcion());
            productosExistente.setCantidad(producto.getCantidad());
            productosExistente.setImagen(producto.getImagen() != null ? producto.getImagen() : productosExistente.getImagen());

            productosRepository.save(productosExistente);
        }else{
            throw new RuntimeException("Producto no encontrado con el id " + id);
        }
    }

    @Override
    public void borrarProducto(Long id) {
        productosRepository.deleteById(id);
    }

    @Override
    public Productos obtenerPorNombre(String nombre) {
        return productosRepository.findByNombre(nombre);
    }
}
