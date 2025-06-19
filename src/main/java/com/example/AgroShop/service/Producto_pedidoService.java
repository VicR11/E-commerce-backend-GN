package com.example.AgroShop.service;

import com.example.AgroShop.model.Pedidos;
import com.example.AgroShop.model.Producto_pedido;
import com.example.AgroShop.model.Productos;
import com.example.AgroShop.repository.IProducto_pedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Producto_pedidoService implements IProducto_pedidoService {

    private IProductoService productoService;
    private IPedidoService pedidoService;
    private IProducto_pedidoRepository productoPedidoRepository;

    @Autowired
    public Producto_pedidoService(IProductoService productoService, IPedidoService pedidoService, IProducto_pedidoRepository productoPedidoRepository) {
        this.productoService = productoService;
        this.pedidoService = pedidoService;
        this.productoPedidoRepository = productoPedidoRepository;
    }

    @Override
    public Producto_pedido guardarRelacion(Producto_pedido producto_pedido) {
        return productoPedidoRepository.save(producto_pedido);
    }

    @Override
    public List<Producto_pedido> listarTodas() {
        return productoPedidoRepository.findAll();
    }

    @Override
    public Producto_pedido buscarPorId(Long id) {
        return productoPedidoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
        productoPedidoRepository.deleteById(id);
    }

    @Override
    public List<Producto_pedido> findById_pedidos(Long idPedido) {
        return productoPedidoRepository.findByPedidosId(idPedido);
    }

    @Override
    public List<Producto_pedido> findById_producto(Long idProducto) {
        return productoPedidoRepository.findByProductosId(idProducto);
    }


    @Override
    @Transactional
    public void asignarProductoPedido(Long idPedido, Long idProducto, Integer cantidad) {
        Productos producto = productoService.obtenerPorId(idProducto);
        Pedidos pedidos = pedidoService.obtenerPorId(idPedido);

        if (pedidos != null && producto != null && cantidad > 0){
            Producto_pedido relacion = new Producto_pedido();
            relacion.setPedidos(pedidos);
            relacion.setProductos(producto);
            relacion.setCantidad(cantidad);
            productoPedidoRepository.save(relacion);
        }else{
            throw new RuntimeException("Pedido" + idPedido+ "o producto" + idProducto + "no econtrado" );
        }
    }

    @Override
    public void asignarProductosPedido(Long idPedido, HashMap<Long, Integer> idsProductos) {
        for (Map.Entry<Long, Integer> entry : idsProductos.entrySet()) {
            Long idProducto = entry.getKey();
            Integer cantidad = entry.getValue();
            asignarProductoPedido(idPedido, idProducto, cantidad); // o con cantidad si hace falta
        }

    }


}
