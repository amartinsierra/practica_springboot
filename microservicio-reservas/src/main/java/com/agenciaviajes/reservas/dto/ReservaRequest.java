package com.agenciaviajes.reservas.dto;

/**
 * DTO para recibir los datos de una nueva reserva.
 */
public class ReservaRequest {

    private int idVuelo;
    private String nombre;
    private String dni;
    private int totalPersonas;

    public ReservaRequest() {
    }

    public ReservaRequest(int idVuelo, String nombre, String dni, int totalPersonas) {
        this.idVuelo = idVuelo;
        this.nombre = nombre;
        this.dni = dni;
        this.totalPersonas = totalPersonas;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTotalPersonas() {
        return totalPersonas;
    }

    public void setTotalPersonas(int totalPersonas) {
        this.totalPersonas = totalPersonas;
    }
}
