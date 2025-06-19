package com.example.AgroShop.service;

import com.example.AgroShop.model.Usuario;
import com.example.AgroShop.repository.iUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService implements iUsuarioService{
    private final iUsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(iUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setCorreo(usuario.getCorreo());
        nuevoUsuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
        nuevoUsuario.setNombre(usuario.getNombre());
        nuevoUsuario.setDireccion(usuario.getDireccion());
        nuevoUsuario.setLocalidad(usuario.getLocalidad());
        nuevoUsuario.setTelefono(usuario.getTelefono());

        usuarioRepository.save(nuevoUsuario);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }


    @Override
    public void editarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);

        if (usuarioExistente != null){
            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
            usuarioExistente.setLocalidad(usuarioActualizado.getLocalidad());
            usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setContraseña(usuarioActualizado.getContraseña());

            usuarioRepository.save(usuarioExistente);
        } else {
            throw new RuntimeException("Usuario no encontrado con el id: " + id);
        }
    }

    @Override
    public Usuario findByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByCorreo(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new org.springframework.security.core.userdetails.User(user.getCorreo(), user.getContraseña(), new ArrayList<>());
    }
}
