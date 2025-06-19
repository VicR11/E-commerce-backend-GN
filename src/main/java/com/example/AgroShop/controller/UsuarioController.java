package com.example.AgroShop.controller;

import com.example.AgroShop.model.Usuario;
import com.example.AgroShop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listaUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping ("/{id}")
    public Usuario obtenerPorId(@PathVariable Long id){
        return usuarioService.obtenerUsuario(id);
    }

    @PostMapping
    public ResponseEntity<String> guardarUsuario(@RequestBody Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok("Registro realizado con éxito!");
    }

    @DeleteMapping ("/borrar/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.ok("Usuario eliminado con éxito!");
    }

    @PutMapping ("/editar/{id}")
    public ResponseEntity<String> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado){
        usuarioService.editarUsuario(id, usuarioActualizado);
        return ResponseEntity.ok("Usuario actualizado con éxito!");
    }

    @GetMapping ("/correo/{correo}")
    public Usuario obtenerPorCorreo(@PathVariable String correo){
        return usuarioService.findByCorreo(correo);
    }
}
