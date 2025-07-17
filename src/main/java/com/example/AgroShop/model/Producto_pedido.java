package com.example.AgroShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Entity
public class Producto_pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto_pedido")
    private Long idProductoPedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    @JsonBackReference("producto-productoPedido")
    private Productos productos;

    @ManyToOne
    @JoinColumn(name = "id_pedidos", nullable = false)
    @JsonBackReference("pedido-productoPedido")
    private Pedidos pedidos;

    @Column(nullable = false)
    private Integer cantidad;

    public Producto_pedido() {
    }

    public Producto_pedido(Long idProductoPedido, Productos productos, Pedidos pedidos, Integer cantidad) {
        this.idProductoPedido = idProductoPedido;
        this.productos = productos;
        this.pedidos = pedidos;
        this.cantidad = cantidad;
    }

    public Long getIdProductoPedido() {
        return idProductoPedido;
    }

    public void setIdProductoPedido(Long idProductoPedido) {
        this.idProductoPedido = idProductoPedido;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}