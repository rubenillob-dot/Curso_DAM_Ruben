package clubfutbol.modelo;

public class vip extends usuario {
    private String nivelVip; // Ejemplo: "Plata", "Oro", "Platino"
    private String empresaAsociada; // Por si son entradas de empresa o marcas

    public vip(String dni, String nombre, String email, String nivelVip, String empresaAsociada) {
        super(dni, nombre, email);
        this.nivelVip = nivelVip;
        this.empresaAsociada = empresaAsociada;
    }

    public String getNivelVip() {
        return nivelVip;
    }

    public void setNivelVip(String nivelVip) {
        this.nivelVip = nivelVip;
    }

    public String getEmpresaAsociada() {
        return empresaAsociada;
    }

    public void setEmpresaAsociada(String empresaAsociada) {
        this.empresaAsociada = empresaAsociada;
    }

    @Override
    public String toString() {
        return "vip [nivelVip=" + nivelVip + ", empresaAsociada=" + empresaAsociada + "]";
    }

    
}
