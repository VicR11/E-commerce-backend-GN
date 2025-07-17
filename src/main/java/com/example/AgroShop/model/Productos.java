package com.example.AgroShop.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Entity
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false)
    @Min(value = 0, message = "El precio no puede ser negativo")
    private double precio;
    @Column(nullable = false, length = 80)
    private String descripcion;
    @Column(nullable = false)
    private Integer cantidad;
    /*@Column(nullable = false, length = 254)
    private String imagen;*/

    @OneToMany(mappedBy = "productos", cascade = CascadeType.ALL)
    @JsonManagedReference("producto-productoPedido")
    private List<Producto_pedido> producto_pedido;

    @OneToMany(mappedBy = "productos", cascade = CascadeType.ALL)
    @JsonManagedReference("imagen-producto")
    private List<ImagenProducto> ImagenesProducto;

    public Productos() {
    }

    public Productos(String nombre, double precio, String descripcion, Integer cantidad, List<Producto_pedido> producto_pedido, List<ImagenProducto> imagenesProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.producto_pedido = producto_pedido;
        this.ImagenesProducto = imagenesProducto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Min(value = 0, message = "El precio no puede ser negativo")
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(@Min(value = 0, message = "El precio no puede ser negativo") double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public List<Producto_pedido> getProducto_pedido() {
        return producto_pedido;
    }

    public void setProducto_pedido(List<Producto_pedido> producto_pedido) {
        this.producto_pedido = producto_pedido;
    }

    public List<ImagenProducto> getImagenesProducto() {
        return ImagenesProducto;
    }

    public void setImagenesProducto(List<ImagenProducto> imagenesProducto) {
        ImagenesProducto = imagenesProducto;
    }
}