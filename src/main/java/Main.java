import exceptions.DatabaseConnectionException;

import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {


            //************************************* Crear la informacion para un pedido ********************************
            Pedido pedido = new Pedido();
            pedido.cargarPlato(new Plato("Tallarines", 3560), 2);
            pedido.cargarBebida(new Bebida("Seven up", (float) 1780.5), 1);

            Tarjeta tarjeta = new TarjetaGenerica();        //No tiene descuento

            LocalDate fecha = LocalDate.of(2025, 02, 24);


            //****************************** REGISTRAR EN EL ARCHIVO ***************************************************
            String rutaArchivoVentas = "C:\\Users\\retur\\OneDrive\\Escritorio\\UNRN\\TERCER AÑO\\PRIMER CUATRIMESTRE\\OBJETOS 2\\ArchivosJava\\Ventas.txt";
            RegistroPedido archivoVentas = new RegistroPedidoArchivo(rutaArchivoVentas);        //CREACION DEL PEDIDO

            DispositivoElectronico dispositivo1 = new DispositivoElectronico(archivoVentas);

            try {
                dispositivo1.totalConDescuentoAplicado(pedido, tarjeta, Propina.CINCO_PORCIENTO, fecha);
            } catch (DatabaseConnectionException e) {
                System.out.println(e.getMessage());
            }


            //****************************** REGISTRAR EN BASE DE DATOS ************************************************
            RegistroPedido bdVentas = new RegistroPedidoBD();

            DispositivoElectronico dispositivo2 = new DispositivoElectronico(bdVentas);

            try {
                dispositivo2.totalConDescuentoAplicado(pedido, tarjeta, Propina.CINCO_PORCIENTO, fecha);
            } catch (DatabaseConnectionException e) {
                System.out.println(e.getMessage());
            }


            //****************************** ENVIO DE EMAIL ************************************************************


            String emisor = "your.recipient@email.com";
            String destinatario = "john.doe@your.domain";
            String asunto = "Solicitud de pedido";
            String cuerpo = "Usted ha solicitado un pedido.";

            Notificador notificador = new NotificadorEmail();           //INSTANCIO EL NOTIFICADOR

            notificador.notificar(emisor, destinatario, asunto, cuerpo);
        }
}
