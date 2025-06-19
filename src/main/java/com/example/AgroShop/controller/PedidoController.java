package com.example.AgroShop.controller;

import com.example.AgroShop.model.Pedidos;
import com.example.AgroShop.service.IPedidoService;
import com.example.AgroShop.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedidos> listarPedidos(){
        return pedidoService.obtenerPedidos();
    }

    @GetMapping("/{id}")
    public Pedidos obtenerPorId(@PathVariable Long id){
        return pedidoService.obtenerPorId(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarPedido(@RequestBody Pedidos pedido){
        pedidoService.guardarPedido(pedido);
        return ResponseEntity.ok("Pedido agregado con éxito");
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> actualizarPedido(@PathVariable Long id, @RequestBody Pedidos pedido){
        pedidoService.actualizarPedido(id, pedido);
        return ResponseEntity.ok("Pedido editado con exito");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarPedido(@PathVariable Long id){
        pedidoService.borrarPedido(id);
        return ResponseEntity.ok("Pedido borrado con exito");
    }
}
