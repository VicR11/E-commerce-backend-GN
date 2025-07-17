package com.example.AgroShop.repository;

import com.example.AgroShop.model.ImagenProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenRepository extends JpaRepository<ImagenProducto, Long> {
}
