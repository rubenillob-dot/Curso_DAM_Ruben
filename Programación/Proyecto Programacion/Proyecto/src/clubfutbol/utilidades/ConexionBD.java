package clubfutbol.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String DB_URL = "jdbc:sqlite:clubfutbol.db";
    private Connection connection;

    public ConexionBD() throws SQLException {
        this.connection = DriverManager.getConnection(DB_URL);
        crearTablas();
    }

    public Connection getConnection() {
        return connection;
    }

    private void crearTablas() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            // Creamos una única tabla para todas las entradas
            stmt.execute("CREATE TABLE IF NOT EXISTS entrada (" +
                         "id_entrada TEXT PRIMARY KEY, " +
                         "tipo TEXT NOT NULL, " +
                         "precio_base REAL NOT NULL, " +
                         "fecha TEXT NOT NULL, " +
                         "aforo INTEGER NOT NULL, " +
                         "equipo_rival TEXT, " +
                         "competicion TEXT, " +
                         "asiento TEXT, " +
                         "hora_inicio TEXT, " +
                         "idioma_guia TEXT, " +
                         "zona_acceso TEXT)");
        }
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
