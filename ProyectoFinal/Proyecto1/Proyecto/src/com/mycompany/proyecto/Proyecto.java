package com.mycompany.proyecto;

import javax.swing.JOptionPane;

public class Proyecto {

    public static Clientes[] clientes = new Clientes[20];
    public static int contadorClientes = 0;

    public static Control_de_citas[] citas = new Control_de_citas[20];
    public static int contadorCitas = 0;

    public static Clases_funcionales[] clases = new Clases_funcionales[20];
    public static int contadorClases = 0;

    public static Informacion[] eventos = new Informacion[20];
    public static int contadorEventos = 0;

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
                    menuClientes();
                    break;
                case 1:
                    menuCitas();
                    break;
                case 2:
                    menuClasesFuncionales();
                    break;
                case 3:
                    menuInformacion();
                    break;
                default:
                    break;
            }

        } while (opcion != 4 && opcion != JOptionPane.CLOSED_OPTION);

        JOptionPane.showMessageDialog(null, "Programa finalizado.");
    }

    // CLIENTES
    public static void menuClientes() {
        String[] opciones = {"Registrar cliente", "Mostrar clientes", "Editar cliente", "Eliminar cliente", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú de Clientes",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0:
                    registrarCliente();
                    break;
                case 1:
                    mostrarClientes();
                    break;
                case 2:
                    editarCliente();
                    break;
                case 3:
                    eliminarCliente();
                    break;
                default:
                    break;
            }

        } while (opcion != 4 && opcion != JOptionPane.CLOSED_OPTION);
    }

    public static void registrarCliente() {
        if (contadorClientes < 20) {

            int id = contadorClientes + 1;
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente:"));

            int seguro = JOptionPane.showConfirmDialog(null, "¿Tiene seguro?");
            boolean conSeguro = (seguro == 0);

            clientes[contadorClientes++] = new Clientes(id, nombre, cedula, edad, conSeguro);

            JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");

        } else {
            JOptionPane.showMessageDialog(null, "Capacidad máxima de clientes alcanzada");
        }
    }

    public static void mostrarClientes() {
        if (contadorClientes == 0) {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados");
            return;
        }

        StringBuilder info = new StringBuilder("LISTA DE CLIENTES:\n\n");
        for (int i = 0; i < contadorClientes; i++) {
            info.append(clientes[i].toString());
            info.append("-----------------------\n");
        }

        JOptionPane.showMessageDialog(null, info.toString());
    }

    public static void editarCliente() {
        int idEditar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a editar:"));
        boolean encontrado = false;

        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getIdCliente() == idEditar) {
                encontrado = true;

                String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", clientes[i].getNombreCliente());
                int nuevaCedula = Integer.parseInt(JOptionPane.showInputDialog("Nueva cédula:", clientes[i].getCedula()));
                int nuevaEdad = Integer.parseInt(JOptionPane.showInputDialog("Nueva edad:", clientes[i].getEdad()));

                int seguro = JOptionPane.showConfirmDialog(null, "¿Tiene seguro?");
                boolean conSeguro = (seguro == 0);

                clientes[i].setNombreCliente(nuevoNombre);
                clientes[i].setCedula(nuevaCedula);
                clientes[i].setEdad(nuevaEdad);
                clientes[i].setConSeguro(conSeguro);

                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
        }
    }

    public static void eliminarCliente() {
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente a eliminar:"));
        int indice = -1;

        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getIdCliente() == idEliminar) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            return;
        }

        for (int i = indice; i < contadorClientes - 1; i++) {
            clientes[i] = clientes[i + 1];
        }

        clientes[contadorClientes - 1] = null;
        contadorClientes--;

        JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
    }

    // CITAS
    public static void menuCitas() {
        String[] opciones = {"Agendar Citas", "Mostrar Citas", "Confirmar cita", "Cancelar cita", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú de Citas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0:
                    agendarCita();
                    break;
                case 1:
                    mostrarCitas();
                    break;
                case 2:
                    confirmarCita();
                    break;
                case 3:
                    eliminarCita();
                    break;
                default:
                    break;
            }

        } while (opcion != 4 && opcion != JOptionPane.CLOSED_OPTION);
    }

    public static void agendarCita() {
        if (contadorCitas >= 20) {
            JOptionPane.showMessageDialog(null, "Capacidad máxima de citas alcanzada");
            return;
        }

        int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));
        boolean existeCliente = false;

        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getIdCliente() == idCliente) {
                existeCliente = true;
                break;
            }
        }

        if (!existeCliente) {
            JOptionPane.showMessageDialog(null, "No se puede agendar la cita porque el cliente no existe");
            return;
        }

        int idActividad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la actividad:"));
        String dia = JOptionPane.showInputDialog("Ingrese el día:");
        String hora = JOptionPane.showInputDialog("Ingrese la hora:");

        for (int i = 0; i < contadorCitas; i++) {
            if (citas[i].getDia().equalsIgnoreCase(dia)
                    && citas[i].getHora().equalsIgnoreCase(hora)) {
                JOptionPane.showMessageDialog(null, "Ya existe una cita en ese día y hora");
                return;
            }
        }

        Terapia[] terapias = Terapia.values();
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "Seleccione la terapia:",
                "Terapias",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                terapias,
                terapias[0]);

        Terapia terapia = terapias[seleccion];

        citas[contadorCitas++] = new Control_de_citas(idCliente, idActividad, dia, hora, terapia, existeCliente);

        JOptionPane.showMessageDialog(null, "Cita registrada correctamente");
    }

    public static void mostrarCitas() {
        if (contadorCitas == 0) {
            JOptionPane.showMessageDialog(null, "No hay citas registradas");
            return;
        }

        String info = "LISTA DE CITAS:\n\n";

        for (int i = 0; i < contadorCitas; i++) {
            info += citas[i].toString();
            info += "\n------------------------\n";
        }

        JOptionPane.showMessageDialog(null, info);
    }

    public static void eliminarCita() {
        int indice = -1;
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));

        for (int i = 0; i < contadorCitas; i++) {
            if (citas[i].getIdCliente() == idEliminar) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "No se encontró la cita");
            return;
        }

        for (int i = indice; i < contadorCitas - 1; i++) {
            citas[i] = citas[i + 1];
        }

        citas[contadorCitas - 1] = null;
        contadorCitas--;

        JOptionPane.showMessageDialog(null, "Cita eliminada correctamente");
    }

    public static void confirmarCita() {
        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));

        for (int i = 0; i < contadorCitas; i++) {
            if (citas[i].getIdCliente() == idBuscar) {
                citas[i].confirmarCita();
                JOptionPane.showMessageDialog(null, "Cita confirmada correctamente");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró la cita");
    }

    // CLASES FUNCIONALES
    public static void menuClasesFuncionales() {
        String[] opciones = {"Registrar clase", "Mostrar clases", "Eliminar clase", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú de Clases Funcionales",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0:
                    registrarClase();
                    break;
                case 1:
                    mostrarClases();
                    break;
                case 2:
                    eliminarClase();
                    break;
                default:
                    break;
            }

        } while (opcion != 3 && opcion != JOptionPane.CLOSED_OPTION);
    }

    public static void registrarClase() {
        if (contadorClases < 20) {
            int id = contadorClases + 1;
            String nombre = JOptionPane.showInputDialog("Nombre de la clase:");
            String horario = JOptionPane.showInputDialog("Horario:");

            int disp = JOptionPane.showConfirmDialog(null, "¿Está disponible?");
            boolean disponible = (disp == 0);

            clases[contadorClases++] = new Clases_funcionales(id, nombre, horario, disponible);

            JOptionPane.showMessageDialog(null, "Clase registrada correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Capacidad máxima alcanzada");
        }
    }

    public static void mostrarClases() {
        if (contadorClases == 0) {
            JOptionPane.showMessageDialog(null, "No hay clases registradas");
            return;
        }

        String info = "LISTA DE CLASES:\n\n";

        for (int i = 0; i < contadorClases; i++) {
            info += clases[i].toString();
            info += "-----------------------\n";
        }

        JOptionPane.showMessageDialog(null, info);
    }

    public static void eliminarClase() {
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la clase:"));
        int indice = -1;

        for (int i = 0; i < contadorClases; i++) {
            if (clases[i].getIdClase() == idEliminar) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Clase no encontrada");
            return;
        }

        for (int i = indice; i < contadorClases - 1; i++) {
            clases[i] = clases[i + 1];
        }

        clases[contadorClases - 1] = null;
        contadorClases--;

        JOptionPane.showMessageDialog(null, "Clase eliminada correctamente");
    }

    // INFORMACIÓN
    public static void menuInformacion() {
        String[] opciones = {"Registrar evento", "Mostrar eventos", "Eliminar evento", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú de Información",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0:
                    registrarEvento();
                    break;
                case 1:
                    mostrarEventos();
                    break;
                case 2:
                    eliminarEvento();
                    break;
                default:
                    break;
            }

        } while (opcion != 3 && opcion != JOptionPane.CLOSED_OPTION);
    }

    public static void registrarEvento() {
        if (contadorEventos < 20) {
            int id = contadorEventos + 1;
            String nombre = JOptionPane.showInputDialog("Nombre del evento:");
            String fecha = JOptionPane.showInputDialog("Fecha:");
            String descripcion = JOptionPane.showInputDialog("Descripción:");

            int act = JOptionPane.showConfirmDialog(null, "¿Evento activo?");
            boolean activo = (act == 0);

            eventos[contadorEventos++] = new Informacion(id, nombre, fecha, descripcion, activo);

            JOptionPane.showMessageDialog(null, "Evento registrado correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Capacidad máxima alcanzada");
        }
    }

    public static void mostrarEventos() {
        if (contadorEventos == 0) {
            JOptionPane.showMessageDialog(null, "No hay eventos registrados");
            return;
        }

        String info = "LISTA DE EVENTOS:\n\n";

        for (int i = 0; i < contadorEventos; i++) {
            info += eventos[i].toString();
            info += "-----------------------\n";
        }

        JOptionPane.showMessageDialog(null, info);
    }

    public static void eliminarEvento() {
        int idEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del evento:"));
        int indice = -1;

        for (int i = 0; i < contadorEventos; i++) {
            if (eventos[i].getIdEvento() == idEliminar) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Evento no encontrado");
            return;
        }

        for (int i = indice; i < contadorEventos - 1; i++) {
            eventos[i] = eventos[i + 1];
        }

        eventos[contadorEventos - 1] = null;
        contadorEventos--;

        JOptionPane.showMessageDialog(null, "Evento eliminado correctamente");
    }
}