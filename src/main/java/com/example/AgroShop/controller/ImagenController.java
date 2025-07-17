package com.example.AgroShop.controller;

import com.example.AgroShop.model.ImagenProducto;
import com.example.AgroShop.model.Pedidos;
import com.example.AgroShop.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/imagenes")
public class ImagenController {

    ImagenService imagenService;

    @Autowired
    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @GetMapping
    public List<ImagenProducto> listarImagenes(){
        return imagenService.obtenerImagenes();
    }

    @GetMapping("/{id}")
    public ImagenProducto obtenerPorId(@PathVariable Long id){

        return imagenService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarImagen(@RequestBody ImagenProducto imagenProducto){
        imagenService.guardarImagen(imagenProducto);
        return ResponseEntity.ok("Imagen agregada con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> actualizarImagen(@PathVariable Long id, @RequestBody ImagenProducto imagenProducto){
        imagenService.actualizarImagen(id, imagenProducto);
        return ResponseEntity.ok("Imagen editada con exito");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarImagen(@PathVariable Long id){
        imagenService.borrarImagen(id);
        return ResponseEntity.ok("Imagen borrada con exito");
    }
}
