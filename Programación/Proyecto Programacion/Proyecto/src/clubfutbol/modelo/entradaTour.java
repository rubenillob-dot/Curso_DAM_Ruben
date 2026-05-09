package clubfutbol.modelo;
import java.time.LocalDate;

public class entradaTour extends entrada {
    private String horaInicio;
    private String idiomaGuia;
    private String zonaAcceso; // Ejemplo: "Museo", "Vestuarios", "Todo"

    public entradaTour(String idEntrada, double precioBase, LocalDate fecha, int aforoDisponible, 
                       String horaInicio, String idiomaGuia, String zonaAcceso) {
        super(idEntrada, precioBase, fecha, aforoDisponible);
        this.horaInicio = horaInicio;
        this.idiomaGuia = idiomaGuia;
        this.zonaAcceso = zonaAcceso;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getIdiomaGuia() {
        return idiomaGuia;
    }

    public void setIdiomaGuia(String idiomaGuia) {
        this.idiomaGuia = idiomaGuia;
    }

    public String getZonaAcceso() {
        return zonaAcceso;
    }

    public void setZonaAcceso(String zonaAcceso) {
        this.zonaAcceso = zonaAcceso;
    }

    @Override
    public String toString() {
        return "entradaTour [horaInicio=" + horaInicio + ", idiomaGuia=" + idiomaGuia + ", zonaAcceso=" + zonaAcceso
                + "]";
    }

    
}