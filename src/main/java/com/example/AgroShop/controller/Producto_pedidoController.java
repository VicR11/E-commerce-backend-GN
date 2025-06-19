package com.example.AgroShop.controller;

import com.example.AgroShop.model.Producto_pedido;
import com.example.AgroShop.service.IProducto_pedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/productopedido")
public class Producto_pedidoController {

    private final IProducto_pedidoService productoPedidoService;

    @Autowired
    public Producto_pedidoController(IProducto_pedidoService productoPedidoService) {
        this.productoPedidoService = productoPedidoService;
    }

    @GetMapping
    public List<Producto_pedido> obtenerTodas(){
        return productoPedidoService.listarTodas();
    }

    @GetMapping("/{id}")
    public Producto_pedido obtenerPorId(@PathVariable Long id_producto_pedido){
        return productoPedidoService.buscarPorId(id_producto_pedido);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarPorId(@PathVariable Long id_producto_pedido){
        productoPedidoService.eliminarPorId(id_producto_pedido);
    }

    @GetMapping("/pedido/{id}")
    public List<Producto_pedido> obtenerPedidoPorId(@PathVariable Long idPedido){
        return productoPedidoService.findById_pedidos(idPedido);
    }

    @GetMapping("/producto/{id}")
    public List<Producto_pedido> obtenerProductosPorId(@PathVariable Long idProducto){
        return productoPedidoService.findById_producto(idProducto);
    }

    @PostMapping("/{id_pedido}/asignar")
    public void asignarProductosPedido(@PathVariable Long id_pedido, @RequestBody HashMap<Long, Integer> idsProductos) {
        productoPedidoService.asignarProductosPedido(id_pedido, idsProductos);
    }




//    @PostMapping("/{id_pedido}/asignar/{id_producto}")
//    public void asignarProductoPedido(@PathVariable Long id_pedido, @PathVariable Long id_producto){
//        productoPedidoService.asignarProductoPedido(id_pedido, id_producto);
//    }
}
