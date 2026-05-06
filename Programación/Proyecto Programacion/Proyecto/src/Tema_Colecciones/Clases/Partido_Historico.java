package Tema_Colecciones.Clases;

public class Partido_Historico extends RecursoFutbol {
    private String torneo;
    private String jugadorEstrella;

    public Partido_Historico(String codigoRegistro, String nombreArticulo, int temporada, int stockAlmacen,
            String torneo, String jugadorEstrella) {
        super(codigoRegistro, nombreArticulo, temporada, stockAlmacen);
        this.torneo = torneo;
        this.jugadorEstrella = jugadorEstrella;
    }

    public String getTorneo() {
        return torneo;
    }

    public String getJugadorEstrella() {
        return jugadorEstrella;
    }

}
