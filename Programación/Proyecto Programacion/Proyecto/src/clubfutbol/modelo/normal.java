package clubfutbol.modelo;

public class normal extends usuario {
    // Un usuario normal no necesita atributos extra por ahora, 
    // pero hereda el DNI, nombre y email.
    
    public normal(String dni, String nombre, String email) {
        super(dni, nombre, email);
    }
}
