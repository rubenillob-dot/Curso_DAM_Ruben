package clubfutbol.excepciones;

// Para cuando alguien intenta comprar sin estar registrado

public class UsuarioNoEncontradoException extends Exception {
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
