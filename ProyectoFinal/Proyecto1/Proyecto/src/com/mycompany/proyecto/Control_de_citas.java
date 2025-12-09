package com.mycompany.proyecto;

public class Control_de_citas {
    private int idCliente;
    private int idActividad;
    private String dia;
    private String hora;
    private Terapia terapia;
    private boolean confirmada;

    public Control_de_citas(int idCliente, int idActividad, String dia, String hora, Terapia terapia, boolean confirmada) {
        this.idCliente = idCliente;
        this.idActividad = idActividad;
        this.dia = dia;
        this.hora = hora;
        this.terapia = terapia;
        this.confirmada = confirmada;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Terapia getTerapia() {
        return terapia;
    }

    public void setTerapia(Terapia terapia) {
        this.terapia = terapia;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    @Override
    public String toString() {
        return "ID Cliente: " + idCliente +
               "\nID Actividad: " + idActividad +
               "\nDia: " + dia +
               "\nHora: " + hora +
               "\nTerapia: " + terapia +
               "\nEstado: " + (confirmada ? "Confirmada" : "Pendiente");
    }

    public void confirmarCita() {
        this.confirmada = true;
    }
}