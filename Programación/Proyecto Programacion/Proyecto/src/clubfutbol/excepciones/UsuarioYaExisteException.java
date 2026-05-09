package clubfutbol.excepciones;

// Para cuando intentamos registrar un DNI duplicado

public class UsuarioYaExisteException extends Exception {
    public UsuarioYaExisteException(String mensaje) {
        super(mensaje);
    }
}
