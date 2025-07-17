package com.example.AgroShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ImagenProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen")
    private Long Id;

    private String urlImagen;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    @JsonBackReference("imagen-producto")
    private Productos productos;

    public ImagenProducto() {

    }

    public ImagenProducto(Long id, String urlImagen) {
        Id = id;
        this.urlImagen = urlImagen;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
