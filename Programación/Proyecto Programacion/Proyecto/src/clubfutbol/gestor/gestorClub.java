package clubfutbol.gestor;

import clubfutbol.modelo.*;
import clubfutbol.excepciones.*;
import java.util.*;

public class gestorClub {
    
    // Colecciones para cumplir con la UT9
    private Map<String, usuario> usuarios;
    private List<entrada> inventarioEntradas;
    private Map<String, List<entrada>> comprasPorUsuario;

    public gestorClub() {
        this.usuarios = new HashMap<>();
        this.inventarioEntradas = new ArrayList<>();
        this.comprasPorUsuario = new HashMap<>();
    }

    // --- GESTIÓN DE USUARIOS ---

    public void registrarUsuario(usuario usuario) throws UsuarioYaExisteException {
        if (usuarios.containsKey(usuario.getDni())) {
            throw new UsuarioYaExisteException("Error: El usuario con DNI " + usuario.getDni() + " ya está registrado.");
        }
        usuarios.put(usuario.getDni(), usuario);
        // Preparamos su lista de compras vacía
        comprasPorUsuario.put(usuario.getDni(), new ArrayList<>());
    }

    // --- GESTIÓN DE ENTRADAS ---

    public void anadirEntrada(entrada entrada) {
        inventarioEntradas.add(entrada);
    }

    // --- LÓGICA DE COMPRA ---

    public void comprarEntrada(String dni, String idEntrada) throws UsuarioNoEncontradoException, EntradaNoEncontradaException, EntradaAgotadaException {
        // 1. Validar Usuario
        if (!usuarios.containsKey(dni)) {
            throw new UsuarioNoEncontradoException("Error: No existe ningún usuario con el DNI " + dni);
        }

        // 2. Buscar Entrada
        entrada entradaDeseada = null;
        for (entrada e : inventarioEntradas) {
            if (e.getIdEntrada().equals(idEntrada)) {
                entradaDeseada = e;
                break;
            }
        }

        if (entradaDeseada == null) {
            throw new EntradaNoEncontradaException("Error: La entrada con ID " + idEntrada + " no existe en el catálogo.");
        }

        // 3. Comprobar Aforo
        if (entradaDeseada.getAforoDisponible() <= 0) {
            throw new EntradaAgotadaException("Lo sentimos, el aforo para la entrada " + idEntrada + " está completo.");
        }

        // 4. Efectuar la compra (restar aforo y añadir al historial)
        entradaDeseada.setAforoDisponible(entradaDeseada.getAforoDisponible() - 1);
        comprasPorUsuario.get(dni).add(entradaDeseada);
    }

    // --- CONSULTAS ---

    public List<entrada> consultarHistorialCompras(String dni) throws UsuarioNoEncontradoException {
        if (!usuarios.containsKey(dni)) {
            throw new UsuarioNoEncontradoException("Error: DNI " + dni + " no encontrado en el sistema.");
        }
        return comprasPorUsuario.get(dni);
    }
    
    public List<entrada> getInventarioEntradas() {
        return inventarioEntradas;
    }

    // --- FILTROS Y STREAMS (AMPLIACIÓN) ---

    public void mostrarEntradasDisponiblesStream() {
        System.out.println("\n--- ENTRADAS DISPONIBLES (Filtro Stream) ---");
        
        long count = inventarioEntradas.stream()
                .filter(entrada -> entrada.getAforoDisponible() > 0)
                .peek(entrada -> System.out.println("- ID: " + entrada.getIdEntrada() + " | Quedan: " + entrada.getAforoDisponible() + " -> " + entrada.toString()))
                .count();

        if (count == 0) {
            System.out.println("No hay ninguna entrada disponible en este momento.");
        }
    }


}