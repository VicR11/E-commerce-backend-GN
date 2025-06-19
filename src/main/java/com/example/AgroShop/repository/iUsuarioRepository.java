package com.example.AgroShop.repository;

import com.example.AgroShop.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository <Usuario, Long> {
    Usuario findByCorreo(String correo);
}
