package com.example.AgroShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Entity
public class Usuario {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String localidad;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String contraseña;

    public Usuario() {
    }

    public Usuario(String nombre, String direccion, String localidad, String telefono, String correo, String contraseña) {

        this.nombre = nombre;
        this.direccion = direccion;
        this.localidad = localidad;
        this.telefono = telefono;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}