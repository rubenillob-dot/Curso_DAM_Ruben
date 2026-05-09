package clubfutbol.excepciones;

// Para controlar cuanta gente hay 

public class EntradaAgotadaException extends Exception {
    public EntradaAgotadaException(String mensaje) {
        super(mensaje);
    }
}
