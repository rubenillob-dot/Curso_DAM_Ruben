package clubfutbol.modelo;

import java.time.LocalDate;

public abstract class entrada {
    private String idEntrada; // Actuará como el identificador único es una especie de codigo de barras
    private double precioBase;
    private LocalDate fecha;
    private int aforoDisponible;

    public entrada(String idEntrada, double precioBase, LocalDate fecha, int aforoDisponible) {
        this.idEntrada = idEntrada;
        this.precioBase = precioBase;
        this.fecha = fecha;
        this.aforoDisponible = aforoDisponible;
    }

    public String getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(String idEntrada) {
        this.idEntrada = idEntrada;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getAforoDisponible() {
        return aforoDisponible;
    }

    public void setAforoDisponible(int aforoDisponible) {
        this.aforoDisponible = aforoDisponible;
    }

    @Override
    public String toString() {
        return "entrada [idEntrada=" + idEntrada + ", precioBase=" + precioBase + ", fecha=" + fecha
                + ", aforoDisponible=" + aforoDisponible + "]";
    }
    
    
    
}
