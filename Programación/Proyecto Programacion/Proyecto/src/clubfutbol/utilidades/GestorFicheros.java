package clubfutbol.utilidades;

import clubfutbol.modelo.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorFicheros {

    private static final String ARCHIVO_ENTRADAS = "entradas.csv";

    // --- MÉTODOS PARA GUARDAR DATOS ---

    public void guardarEntradasCSV(List<entrada> inventario) throws IOException {
        // El bloque try-with-resources cierra automáticamente el archivo al terminar
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_ENTRADAS))) {
            // Guardamos una cabecera opcional para que se lea mejor en Excel
            pw.println("TIPO,ID,PRECIO,FECHA,AFORO,EXTRA1,EXTRA2,EXTRA3");
            
            for (entrada e : inventario) {
                if (e instanceof entradaPartido) {
                    entradaPartido ep = (entradaPartido) e;
                    pw.printf("PARTIDO,%s,%.2f,%s,%d,%s,%s,%s\n", 
                        ep.getIdEntrada(), ep.getPrecioBase(), ep.getFecha().toString(), 
                        ep.getAforoDisponible(), ep.getEquipoRival(), ep.getCompeticion(), ep.getAsiento());
                } else if (e instanceof entradaTour) {
                    entradaTour et = (entradaTour) e;
                    pw.printf("TOUR,%s,%.2f,%s,%d,%s,%s,%s\n", 
                        et.getIdEntrada(), et.getPrecioBase(), et.getFecha().toString(), 
                        et.getAforoDisponible(), et.getHoraInicio(), et.getIdiomaGuia(), et.getZonaAcceso());
                }
            }
        }
    }

    // --- MÉTODOS PARA LEER DATOS ---

    public List<entrada> cargarEntradasCSV() throws IOException {
        List<entrada> entradasCargadas = new ArrayList<>();
        File archivo = new File(ARCHIVO_ENTRADAS);

        if (!archivo.exists()) {
            return entradasCargadas; // Si es la primera vez y no hay archivo, devolvemos lista vacía
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine(); // Leemos y saltamos la primera línea (cabecera)
            
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length < 8) continue; // Por seguridad, si la línea está mal formada, la saltamos

                String tipo = datos[0];
                String id = datos[1];
                double precio = Double.parseDouble(datos[2].replace(",", ".")); 
                LocalDate fecha = LocalDate.parse(datos[3]);
                int aforo = Integer.parseInt(datos[4]);

                if (tipo.equals("PARTIDO")) {
                    entradasCargadas.add(new entradaPartido(id, precio, fecha, aforo, datos[5], datos[6], datos[7]));
                } else if (tipo.equals("TOUR")) {
                    entradasCargadas.add(new entradaTour(id, precio, fecha, aforo, datos[5], datos[6], datos[7]));
                }
            }
        }
        return entradasCargadas;
    }
}
