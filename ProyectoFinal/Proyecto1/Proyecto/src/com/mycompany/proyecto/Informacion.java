package com.mycompany.proyecto;

public class Informacion {
    private int idEvento;
    private String nombreEvento;
    private String fecha;
    private String descripcion;
    private boolean activo;

    public Informacion(int idEvento, String nombreEvento, String fecha, String descripcion, boolean activo) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    // Getters y setters
    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "ID Evento: " + idEvento +
               "\nNombre: " + nombreEvento +
               "\nFecha: " + fecha +
               "\nDescripción: " + descripcion +
               "\nActivo: " + (activo ? "Sí" : "No") + "\n";
    }
}
