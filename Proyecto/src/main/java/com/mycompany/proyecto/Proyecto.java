/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto;

import javax.swing.JOptionPane;

public class Proyecto {
    public static void main(String[] args) {

        String[] opciones = {"Clientes", "Control de citas", "Clases funcionales", "Información", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Clientes");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Control de citas");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Clases funcionales");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Información");
                    break;
                default:
                    break;
            }

        } while (opcion != 4 && opcion != JOptionPane.CLOSED_OPTION);

        JOptionPane.showMessageDialog(null, "Programa finalizado.");
    }
}
