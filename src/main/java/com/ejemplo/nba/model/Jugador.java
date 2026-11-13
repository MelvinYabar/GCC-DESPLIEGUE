package com.ejemplo.nba.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public class Jugador {

    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El equipo es obligatorio")
    private String equipo;

    @NotBlank(message = "La posicion es obligatoria")
    private String posicion;

    @DecimalMin(value = "0.0", message = "Los puntos no pueden ser negativos")
    @DecimalMax(value = "100.0", message = "Los puntos no pueden superar 100")
    private double puntosPorPartido;

    public Jugador() {
    }

    public Jugador(Long id, String nombre, String equipo, String posicion, double puntosPorPartido) {
        this.id = id;
        this.nombre = nombre;
        this.equipo = equipo;
        this.posicion = posicion;
        this.puntosPorPartido = puntosPorPartido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public double getPuntosPorPartido() {
        return puntosPorPartido;
    }

    public void setPuntosPorPartido(double puntosPorPartido) {
        this.puntosPorPartido = puntosPorPartido;
    }
}
