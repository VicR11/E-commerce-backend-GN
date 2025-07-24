package com.example.AgroShop.repository;


import com.example.AgroShop.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Productos, Long> {
    Productos findByNombre (String nombre);
    List<Productos> findByNombreContainingIgnoreCase(String nombre);
    /*findBy → inicia una consulta basada en una propiedad.
    Nombre → el campo de la entidad (nombre).
    Containing → equivale a LIKE %valor% en SQL.
    IgnoreCase → ignora mayúsculas/minúsculas.
    */


}
