package com.ValbuenaAbogados.crudValbuena;

import jakarta.persistence.*;

@Entity
@Table
public class Abogado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String especialidad;
    private String direccion;
    private int unusuario_id_usuario;
    @Transient
    private int tiempo;

    public Abogado() {
    }

    public Abogado(Integer id, String dni, String nombre, String apellidos, String telefono, String especialidad, String direccion, int unusuario_id_usuario) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.direccion = direccion;
        this.unusuario_id_usuario = unusuario_id_usuario;
    }

    public Abogado(String dni, String nombre, String apellidos, String telefono, String especialidad, String direccion, int unusuario_id_usuario) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.direccion = direccion;
        this.unusuario_id_usuario = unusuario_id_usuario;
    }

    public Integer getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getUnusuario_id_usuario() {
        return unusuario_id_usuario;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setUnusuario_id_usuario(int unusuario_id_usuario) {
        this.unusuario_id_usuario = unusuario_id_usuario;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
