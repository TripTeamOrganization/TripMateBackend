package com.backend.tripmate.flights.interfaces.rest.resources;

public class FlightResource {
    private int idVuelo;
    private String nombreAerolinea;
    private String fechaHoraVuelo;
    private int numeroAsiento;
    private String destino;
    private float precio;
    private String descuento;
    private int idTipoVuelo;

    // Getters and Setters
    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public String getFechaHoraVuelo() {
        return fechaHoraVuelo;
    }

    public void setFechaHoraVuelo(String fechaHoraVuelo) {
        this.fechaHoraVuelo = fechaHoraVuelo;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public int getIdTipoVuelo() {
        return idTipoVuelo;
    }

    public void setIdTipoVuelo(int idTipoVuelo) {
        this.idTipoVuelo = idTipoVuelo;
    }
}
