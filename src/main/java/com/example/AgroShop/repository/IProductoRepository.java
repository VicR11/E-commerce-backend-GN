package com.example.AgroShop.repository;


import com.example.AgroShop.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Productos, Long> {
    Productos findByNombre (String nombre);
}
