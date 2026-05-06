package Tema_Colecciones.Clases;

public class Usuario {
    private String numeroDocumento;
    private String nombreCompleto;

    public Usuario(String numeroDocumento, String nombreCompleto) {
        this.numeroDocumento = numeroDocumento;
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

}