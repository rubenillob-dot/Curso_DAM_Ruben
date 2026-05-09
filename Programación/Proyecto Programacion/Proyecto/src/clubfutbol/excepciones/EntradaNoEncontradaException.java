package clubfutbol.excepciones;

// Para cuando se introduce un ID de entrada que no existe

public class EntradaNoEncontradaException extends Exception {
    public EntradaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
