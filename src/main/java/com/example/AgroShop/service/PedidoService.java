package com.example.AgroShop.service;

import com.example.AgroShop.model.Pedidos;
import com.example.AgroShop.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService implements IPedidoService{

    private IPedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedidos> obtenerPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedidos obtenerPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarPedido(Pedidos pedido) {
        pedidoRepository.save(pedido);
    }

    @Override
    public void actualizarPedido(Long id, Pedidos pedido) {
        Pedidos pedidoExistente = pedidoRepository.findById(id).orElse(null);

        if (pedidoExistente != null){
            pedidoExistente.setFechaPedido(pedido.getFechaPedido());
            pedidoExistente.setFechaSalida(pedido.getFechaSalida());
            pedidoExistente.setDireccionEntrega(pedido.getDireccionEntrega());
            pedidoExistente.setValorTotal(pedido.getValorTotal());

            pedidoRepository.save(pedidoExistente);
        }else{
            throw new RuntimeException("Pedido no encontrado con el id " + id);
        }
    }

    @Override
    public void borrarPedido(Long id) {
            pedidoRepository.deleteById(id);
    }
}
