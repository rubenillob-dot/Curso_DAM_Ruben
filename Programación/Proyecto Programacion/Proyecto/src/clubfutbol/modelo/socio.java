package clubfutbol.modelo;

public class socio extends usuario {
    private int numeroSocio;
    private int antiguedadAnios;

    public socio(String dni, String nombre, String email, int numeroSocio, int antiguedadAnios) {
        super(dni, nombre, email);
        this.numeroSocio = numeroSocio;
        this.antiguedadAnios = antiguedadAnios;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public int getAntiguedadAnios() {
        return antiguedadAnios;
    }

    public void setAntiguedadAnios(int antiguedadAnios) {
        this.antiguedadAnios = antiguedadAnios;
    }

    @Override
    public String toString() {
        return "socio [numeroSocio=" + numeroSocio + ", antiguedadAnios=" + antiguedadAnios + "]";
    }

    
}
