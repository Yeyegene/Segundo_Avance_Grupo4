/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto;

public class Clientes {
    private int idCliente;
    private String nombreCliente;
    private int cedula;
    private int edad;
    private boolean conSeguro;

 
    public Clientes(int idCliente, String nombreCliente, String cedula, int edad, boolean conSeguro) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.cedula = Integer.parseInt(cedula);
        this.edad = edad;
        this.conSeguro = conSeguro;
    }

    // Getters y Setters 
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isConSeguro() {
        return conSeguro;
    }

    public void setConSeguro(boolean conSeguro) {
        this.conSeguro = conSeguro;
    }

    // Método toString
    @Override
    public String toString() {
        return "ID: " + idCliente +
                "\nNombre: " + nombreCliente +
                "\nCédula: " + cedula +
                "\nEdad: " + edad +
                "\nSeguro: " + (conSeguro ? "Sí" : "No") +
                "\n";
    }
}