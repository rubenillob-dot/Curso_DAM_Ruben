package clubfutbol.utilidades;

import clubfutbol.modelo.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAOEntradas {

    private ConexionBD conexionBD;

    public DAOEntradas(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    // --- GUARDAR EN LA BASE DE DATOS ---
    public void insertarEntrada(entrada e) throws SQLException {
        String sql = "INSERT OR REPLACE INTO entrada " +
                     "(id_entrada, tipo, precio_base, fecha, aforo, equipo_rival, competicion, asiento, hora_inicio, idioma_guia, zona_acceso) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexionBD.getConnection().prepareStatement(sql)) {
            ps.setString(1, e.getIdEntrada());
            ps.setDouble(3, e.getPrecioBase());
            ps.setString(4, e.getFecha().toString());
            ps.setInt(5, e.getAforoDisponible());

            if (e instanceof entradaPartido) {
                entradaPartido ep = (entradaPartido) e;
                ps.setString(2, "PARTIDO");
                ps.setString(6, ep.getEquipoRival());
                ps.setString(7, ep.getCompeticion());
                ps.setString(8, ep.getAsiento());
                ps.setNull(9, Types.VARCHAR);
                ps.setNull(10, Types.VARCHAR);
                ps.setNull(11, Types.VARCHAR);
            } else if (e instanceof entradaTour) {
                entradaTour et = (entradaTour) e;
                ps.setString(2, "TOUR");
                ps.setNull(6, Types.VARCHAR);
                ps.setNull(7, Types.VARCHAR);
                ps.setNull(8, Types.VARCHAR);
                ps.setString(9, et.getHoraInicio());
                ps.setString(10, et.getIdiomaGuia());
                ps.setString(11, et.getZonaAcceso());
            }
            ps.executeUpdate();
        }
    }

    // --- LEER DE LA BASE DE DATOS ---
    public List<entrada> listarEntradas() throws SQLException {
        String sql = "SELECT * FROM entrada";
        List<entrada> lista = new ArrayList<>();

        try (Statement stmt = conexionBD.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String tipo = rs.getString("tipo");
                String id = rs.getString("id_entrada");
                double precio = rs.getDouble("precio_base");
                LocalDate fecha = LocalDate.parse(rs.getString("fecha"));
                int aforo = rs.getInt("aforo");

                if ("PARTIDO".equals(tipo)) {
                    entradaPartido ep = new entradaPartido(id, precio, fecha, aforo,
                            rs.getString("equipo_rival"), rs.getString("competicion"), rs.getString("asiento"));
                    lista.add(ep);
                } else if ("TOUR".equals(tipo)) {
                    entradaTour et = new entradaTour(id, precio, fecha, aforo,
                            rs.getString("hora_inicio"), rs.getString("idioma_guia"), rs.getString("zona_acceso"));
                    lista.add(et);
                }
            }
        }
        return lista;
    }
}
