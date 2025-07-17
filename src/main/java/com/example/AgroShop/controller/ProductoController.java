package com.example.AgroShop.controller;


import com.example.AgroShop.model.ImagenProducto;
import com.example.AgroShop.model.Productos;
import com.example.AgroShop.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Productos> listarProductos(){
        return productoService.obtenerProductos();
    }

    @GetMapping("/{id}")
    public Productos obtenerPorId(@PathVariable Long id){
        return productoService.obtenerPorId(id);
    }


    @PostMapping(consumes = "application/json")
    public ResponseEntity<String> guardarProducto(@RequestBody Productos producto){
        if (producto.getImagenesProducto() != null) {
            for (ImagenProducto imagen : producto.getImagenesProducto()) {
                imagen.setProductos(producto); // Aquí se establece la relación de el producto a cada imagen, El producto en este punto no tiene id, pero Hibernate se encargará de asignarlo y de usarlo para las imágenes por el cascade
            }
        }
        productoService.guardarProducto(producto);
        return ResponseEntity.ok("Producto agregado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody Productos producto){
        productoService.actualizarProducto(id, producto);
        return ResponseEntity.ok("Producto editado con exito");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarProducto(@PathVariable Long id){
        productoService.borrarProducto(id);
        return ResponseEntity.ok("Producto borrado con exito");
    }

    @GetMapping("/nombre/{nombre}")
    public Productos obtenerProductoPorNombre(@PathVariable String nombre){
        return productoService.obtenerPorNombre(nombre);
    }
}
