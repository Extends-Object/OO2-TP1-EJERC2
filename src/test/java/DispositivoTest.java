import exceptions.DatabaseConnectionException;
import modelo.*;
import org.junit.jupiter.api.Test;
import persistencia.RegistroPedido;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class DispositivoTest {

    @Test
    public void pagoConVisaTest () {      //SIEMPRE SON VOID Y NO RECIBEN PARAMETROS

        //Set up
        Pedido pedido = new Pedido();
        pedido.cargarPlato(new Plato("Tallarines", 3560), 2);       //La suma da 8900.5
        pedido.cargarBebida(new Bebida("Seven up", (float)1780.5), 1);

        Tarjeta tarjeta = new TarjetaVisa();        //El descuento con Visa da 53.415

        RegistroPedido registro = new RegistroPedidoFake();

        DispositivoElectronico dispositivo = new DispositivoElectronico(registro);
        LocalDate fechaPedido = LocalDate.now();
        float montoFinal;

        //Total con el descuento da 8847.085
        //modelo.Propina es de 445.025
        //Total mas la propina da 9292.11

        //Exercise
        try {
            montoFinal = dispositivo.totalConDescuentoAplicado(pedido, tarjeta, Propina.CINCO_PORCIENTO, fechaPedido);
        } catch (DatabaseConnectionException e) {
            throw new RuntimeException(e);
        }

        //Verify
        assertEquals(9292.11F, montoFinal, "El monto calculado no es correcto.");
        assertFalse(((RegistroPedidoFake) registro).getListaPedidos().isEmpty());

        //SOLO PARA VER QUE ES LO QUE SE GUARDO EN LA MEMORIA
        System.out.println(((RegistroPedidoFake) registro).getListaPedidos());
    }


    @Test
    public void pagoConMastercardTest () {

        //Set up
        Pedido pedido = new Pedido();
        pedido.cargarPlato(new Plato("Tallarines", 3560), 2);       //Total sin descuento 8900.5
        pedido.cargarBebida(new Bebida("Seven up", (float)1780.5), 1);

        Tarjeta tarjeta = new TarjetaMastercard();        //El descuento con Master da 142.4

        RegistroPedido registro = new RegistroPedidoFake();
        DispositivoElectronico dispositivo = new DispositivoElectronico(registro);

        LocalDate fechaPedido = LocalDate.now();
        float montoFinal;

        //Total con el descuento da 8758.1
        //modelo.Propina es de 267.015
        //Total con descuento mas la propina da 9025.115

        //Exercise
        try {
            montoFinal = dispositivo.totalConDescuentoAplicado(pedido, tarjeta, Propina.TRES_PORCIENTO, fechaPedido);
        } catch (DatabaseConnectionException e) {
            throw new RuntimeException(e);
        }

        //Verify
        assertEquals(9025.114F, montoFinal, "El monto calculado no es correcto.");
        assertFalse(((RegistroPedidoFake) registro).getListaPedidos().isEmpty());

        //SOLO PARA VER QUE ES LO QUE SE GUARDO EN LA MEMORIA
        System.out.println(((RegistroPedidoFake) registro).getListaPedidos());

    }


    @Test
    public void pagoConComarca () {

        //Set up
        Pedido pedido = new Pedido();
        pedido.cargarPlato(new Plato("Tallarines", 3560), 2);       //Total sin descuento 8900.5
        pedido.cargarBebida(new Bebida("Seven up", (float)1780.5), 1);

        Tarjeta tarjeta = new TarjetaComarca();        //El descuento con Comarca da 178.01
        RegistroPedido registro = new RegistroPedidoFake();

        DispositivoElectronico dispositivo = new DispositivoElectronico(registro);
        LocalDate fechaPedido = LocalDate.now();
        float montoFinal;

        //Total con el descuento da 8722.49
        //modelo.Propina es de 178.01
        //Total con descuento mas la propina da 8900.5

        //Exercise
        try {
            montoFinal = dispositivo.totalConDescuentoAplicado(pedido, tarjeta, Propina.DOS_PORCIENTO, fechaPedido);
        } catch (DatabaseConnectionException e) {
            throw new RuntimeException(e);
        }

        //Verify
        assertEquals(8900.5F, montoFinal, "El monto calculado no es correcto");
        assertFalse(((RegistroPedidoFake) registro).getListaPedidos().isEmpty());

        //SOLO PARA VER QUE ES LO QUE SE GUARDO EN LA MEMORIA
        System.out.println(((RegistroPedidoFake) registro).getListaPedidos());

    }


    @Test
    public void pagoConGenerica () {

        //Set up
        Pedido pedido = new Pedido();
        pedido.cargarPlato(new Plato("Tallarines", 3560), 2);       //Total sin descuento 8900.5
        pedido.cargarBebida(new Bebida("Seven up", (float)1780.5), 1);

        Tarjeta tarjeta = new TarjetaGenerica();        //No tiene descuento

        RegistroPedido registro = new RegistroPedidoFake();

        DispositivoElectronico dispositivo = new DispositivoElectronico(registro);
        LocalDate fechaPedido = LocalDate.now();
        float montoFinal;

        //modelo.Propina es de 445.025
        //Total con descuento mas la propina da 9345.525

        //Exercise
        try {
            montoFinal = dispositivo.totalConDescuentoAplicado(pedido, tarjeta, Propina.CINCO_PORCIENTO, fechaPedido);
        } catch (DatabaseConnectionException e) {
            throw new RuntimeException(e);
        }

        //Verify
        assertEquals(9345.525F, montoFinal, "El monto final no es correcto");
        assertFalse(((RegistroPedidoFake) registro).getListaPedidos().isEmpty());


        //SOLO PARA VER QUE ES LO QUE SE GUARDO EN LA MEMORIA
        System.out.println(((RegistroPedidoFake) registro).getListaPedidos());
    }

    @Test
    public void notificarTest(){
        //Set up
        String emisor = "your.recipient@email.com";
        String destinatario = "john.doe@your.domain";
        String asunto = "Solicitud de pedido";
        String cuerpo = "Usted se ha solicitado un pedido.";

        Notificador notificador = new NotificadorFake();           //INSTANCIO EL NOTIFICADOR

        //Exercise
        notificador.notificar(emisor, destinatario, asunto, cuerpo);

        //Verify
        assertTrue(((NotificadorFake) notificador).seNotifico(), "El pedido no fue notificado.");

        //Solo imprime la lista del notificador fake por consola
        System.out.println(((NotificadorFake) notificador).getMensajesEnviados());
    }


}
