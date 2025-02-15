package com.Api.crudApi;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String nombre;
    private float precio;
    private LocalDate fecha;
    @Transient
    private int tiempo;

    public Producto() {
    }

    public Producto(Integer id, String nombre, float precio, LocalDate fecha) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Producto(String nombre, float precio, LocalDate fecha) {
        this.nombre = nombre;
        this.precio = precio;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
