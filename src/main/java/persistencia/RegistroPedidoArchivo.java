package persistencia;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegistroPedidoArchivo implements RegistroPedido {

    private String rutaArchivo;

    public RegistroPedidoArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void registrarPedido(LocalDate fecha, float montoFinal) {

        File archivo = new File(this.rutaArchivo);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fecha.format(formato);

        String informacionVenta = (fechaFormateada + " || " + String.valueOf(montoFinal));

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(informacionVenta);
            salida.close();
            System.out.println("Se registró correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Error: no se pudo actualizar el archivo");
        }
    }
}
