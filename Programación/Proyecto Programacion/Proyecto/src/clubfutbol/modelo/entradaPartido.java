package clubfutbol.modelo;

import java.time.LocalDate;

public class entradaPartido extends entrada {
    private String equipoRival;
    private String competicion; // Ejemplo: "LaLiga", "Champions"
    private String asiento;

    public entradaPartido(String idEntrada, double precioBase, LocalDate fecha, int aforoDisponible, 
                          String equipoRival, String competicion, String asiento) {
        
        super(idEntrada, precioBase, fecha, aforoDisponible); // Llama al constructor padre
        this.equipoRival = equipoRival;
        this.competicion = competicion;
        this.asiento = asiento;
    }

    public String getEquipoRival() {
        return equipoRival;
    }

    public void setEquipoRival(String equipoRival) {
        this.equipoRival = equipoRival;
    }

    public String getCompeticion() {
        return competicion;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    @Override
    public String toString() {
        return "entradaPartido [equipoRival=" + equipoRival + ", competicion=" + competicion + ", asiento=" + asiento
                + "]";
    }
    
    
}
