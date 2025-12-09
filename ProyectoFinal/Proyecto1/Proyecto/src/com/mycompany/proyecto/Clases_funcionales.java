package com.mycompany.proyecto;

public class Clases_funcionales {
    private int idClase;
    private String nombreClase;
    private String horario;
    private boolean disponible;

    public Clases_funcionales(int idClase, String nombreClase, String horario, boolean disponible) {
        this.idClase = idClase;
        this.nombreClase = nombreClase;
        this.horario = horario;
        this.disponible = disponible;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "ID Clase: " + idClase +
               "\nNombre: " + nombreClase +
               "\nHorario: " + horario +
               "\nDisponible: " + (disponible ? "Sí" : "No") + "\n";
    }
}