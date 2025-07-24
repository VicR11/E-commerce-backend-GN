package com.example.AgroShop.controller;

import com.example.AgroShop.JwtUtil;
import com.example.AgroShop.model.Usuario;
import com.example.AgroShop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {


       /* if(userDetails != null && passwordEncoder.matches(usuario.getContraseña(), userDetails.getPassword())){
            String token = jwtUtil.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(token);
        }*///se utiliza el try para atrapar el error 403 y mostrar el mensaje para cada error
        try {
            UserDetails userDetails = usuarioService.loadUserByUsername(usuario.getCorreo());
            if (userDetails != null) {
                if (passwordEncoder.matches(usuario.getContraseña(), userDetails.getPassword())) {
                    String token = jwtUtil.generateToken(userDetails.getUsername());
                    return ResponseEntity.ok(token);
                }
                return ResponseEntity.status(401).body("Contraseña incorrecta");
            }
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Usuario no existente");
        }
        return ResponseEntity.status(401).body("Crednciales incorrectas");
    }

}
