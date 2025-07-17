package com.example.AgroShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Entity
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos")
    private Long Id;

    @Column(nullable = false)
    private LocalDate fechaPedido;

    @Column(nullable = false)
    private LocalDate fechaSalida;

    @Column(nullable = false)
    private String direccionEntrega;

    @Column(nullable = false)
    private double valorTotal;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference
    private Usuario usuario;

    @OneToMany(mappedBy = "pedidos", cascade = CascadeType.ALL)
    @JsonManagedReference("pedido-productoPedido")
    private List<Producto_pedido> productosPedidos;

    public Pedidos() {
    }

    public Pedidos(Long Id, LocalDate fechaPedido, LocalDate fechaSalida, String direccionEntrega, double valorTotal, Usuario usuario, List<Producto_pedido> productosPedidos) {
        this.Id = Id;
        this.fechaPedido = fechaPedido;
        this.fechaSalida = fechaSalida;
        this.direccionEntrega = direccionEntrega;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.productosPedidos = productosPedidos;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Producto_pedido> getProductosPedidos() {
        return productosPedidos;
    }

    public void setProductosPedidos(List<Producto_pedido> productosPedidos) {
        this.productosPedidos = productosPedidos;
    }
}
