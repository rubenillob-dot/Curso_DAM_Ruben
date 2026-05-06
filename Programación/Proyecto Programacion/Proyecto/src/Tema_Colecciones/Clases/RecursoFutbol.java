package Tema_Colecciones.Clases;

public abstract class RecursoFutbol {
    protected String codigoRegistro;
    protected String nombreArticulo;
    protected int temporada;
    protected int stockAlmacen;

    public RecursoFutbol(String codigoRegistro, String nombreArticulo, int temporada, int stockAlmacen) {
        this.codigoRegistro = codigoRegistro;
        this.nombreArticulo = nombreArticulo;
        this.temporada = temporada;
        this.stockAlmacen = stockAlmacen;
    }

    public String getCodigoRegistro() {
        return codigoRegistro;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public int getStockAlmacen() {
        return stockAlmacen;
    }

}
