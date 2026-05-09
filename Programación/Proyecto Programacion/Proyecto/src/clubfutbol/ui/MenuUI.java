package clubfutbol.ui;

import clubfutbol.gestor.gestorClub;
import clubfutbol.modelo.*;
import clubfutbol.utilidades.ConexionBD;
import clubfutbol.utilidades.DAOEntradas;
import clubfutbol.utilidades.GestorFicheros;
import java.io.IOException;
import java.sql.SQLException;

import clubfutbol.excepciones.*;

import java.util.List;
import java.util.Scanner;

public class MenuUI {

    private gestorClub gestor;
    private Scanner scanner;
    private GestorFicheros gestorFicheros;
    private DAOEntradas daoEntradas;
    private ConexionBD conexion;

    public MenuUI() {
        this.gestor = new gestorClub();
        this.scanner = new Scanner(System.in);
        this.gestorFicheros = new GestorFicheros();

        try {
            // Iniciamos la conexión y el DAO
            this.conexion = new ConexionBD();
            this.daoEntradas = new DAOEntradas(conexion);

            // Cargamos los datos desde la Base de Datos (UT12)
            List<entrada> entradasBD = daoEntradas.listarEntradas();
            for (entrada e : entradasBD) {
                gestor.anadirEntrada(e);
            }
            System.out.println("Base de datos conectada y datos cargados.");

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    /*
     * public MenuUI() {
     * this.gestor = new gestorClub();
     * this.scanner = new Scanner(System.in);
     * this.gestorFicheros = new GestorFicheros();
     * 
     * // Al arrancar, intentamos cargar el CSV
     * try {
     * List<entrada> entradasGuardadas = gestorFicheros.cargarEntradasCSV();
     * for (entrada e : entradasGuardadas) {
     * gestor.anadirEntrada(e);
     * }
     * System.out.println("Datos cargados correctamente.");
     * } catch (IOException e) {
     * System.out.println("No se pudo cargar el archivo de guardado o está vacío.");
     * }
     * }
     */

    /*
     * public MenuUI() {
     * this.gestor = new gestorClub();
     * this.scanner = new Scanner(System.in);
     * cargarDatosDePrueba(); // Metemos datos iniciales para no empezar en blanco
     * }
     */

    public void iniciar() {
        int opcion = -1;
        do {
            System.out.println("\n--- GESTIÓN DEL CLUB DE FÚTBOL ---");
            System.out.println("1. Registrar nuevo usuario normal");
            System.out.println("2. Ver entradas disponibles");
            System.out.println("3. Comprar entrada");
            System.out.println("4. Ver historial de compras de un usuario");
            System.out.println("5. Ver solo entradas con aforo (Stream)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, introduce un número válido.");
            }
        } while (opcion != 0);
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                registrarUsuarioConsola();
                break;
            case 2:
                mostrarEntradas();
                break;
            case 3:
                comprarEntradaConsola();
                break;
            case 4:
                consultarHistorialConsola();
                break;
            case 5:
                gestor.mostrarEntradasDisponiblesStream();
                break;
            case 0:
                try {
                    // Guardamos en CSV (Backup - UT10)
                    gestorFicheros.guardarEntradasCSV(gestor.getInventarioEntradas());

                    // Guardamos en Base de Datos (UT12)
                    for (entrada e : gestor.getInventarioEntradas()) {
                        daoEntradas.insertarEntrada(e);
                    }

                    conexion.close(); // Cerramos la conexión de forma segura
                    System.out.println("Datos sincronizados en BD y CSV. ¡Hasta pronto!");
                } catch (Exception e) {
                    System.out.println("Error al guardar: " + e.getMessage());
                }
                break;

            /*
             * try {
             * gestorFicheros.guardarEntradasCSV(gestor.getInventarioEntradas());
             * System.out.println("Datos guardados en CSV. Cerrando el programa");
             * } catch (IOException e) {
             * System.out.println("Error crítico: No se pudieron guardar los datos.");
             * }
             * break;
             */
            // System.out.println("Cerrando el programa");
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
        }
    }

    // --- MÉTODOS AUXILIARES DE LA INTERFAZ ---

    private void registrarUsuarioConsola() {
        System.out.print("Introduce DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Introduce Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce Email: ");
        String email = scanner.nextLine();

        // Creamos un usuario Normal por defecto para simplificar
        normal nuevoUsuario = new normal(dni, nombre, email);

        try {
            gestor.registrarUsuario(nuevoUsuario);
            System.out.println("¡Usuario registrado con éxito!");
        } catch (UsuarioYaExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    private void mostrarEntradas() {
        System.out.println("\n--- INVENTARIO DE ENTRADAS ---");
        List<entrada> inventario = gestor.getInventarioEntradas();
        if (inventario.isEmpty()) {
            System.out.println("No hay entradas a la venta ahora mismo.");
            return;
        }
        for (entrada e : inventario) {
            // Ahora imprimimos el objeto completo usando su toString()
            System.out.println(e.toString());
        }
    }

    /*
     * private void mostrarEntradas() {
     * System.out.println("\n--- INVENTARIO DE ENTRADAS ---");
     * List<entrada> inventario = gestor.getInventarioEntradas();
     * if (inventario.isEmpty()) {
     * System.out.println("No hay entradas a la venta ahora mismo.");
     * return;
     * }
     * for (entrada e : inventario) {
     * System.out.println("ID: " + e.getIdEntrada() + " | Aforo disponible: " +
     * e.getAforoDisponible());
     * }
     * }
     */

    private void comprarEntradaConsola() {
        System.out.print("Introduce el DNI del comprador: ");
        String dni = scanner.nextLine();
        System.out.print("Introduce el ID de la entrada: ");
        String idEntrada = scanner.nextLine();

        try {
            gestor.comprarEntrada(dni, idEntrada);
            System.out.println("¡Compra realizada correctamente!");
        } catch (UsuarioNoEncontradoException | EntradaNoEncontradaException | EntradaAgotadaException e) {
            System.out.println(e.getMessage()); // Mostramos el mensaje exacto del error
        }
    }

    private void consultarHistorialConsola() {
        System.out.print("Introduce el DNI del usuario a consultar: ");
        String dni = scanner.nextLine();

        try {
            List<entrada> compras = gestor.consultarHistorialCompras(dni);
            if (compras.isEmpty()) {
                System.out.println("El usuario aún no ha comprado ninguna entrada.");
            } else {
                System.out.println("\n--- HISTORIAL DE COMPRAS ---");
                for (entrada e : compras) {
                    System.out.println("- Entrada ID: " + e.getIdEntrada());
                }
            }
        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

}
