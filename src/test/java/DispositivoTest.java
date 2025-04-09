import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DispositivoTest {

    @Test
    public void pagoConVisaTest () {      //SIEMPRE SON VOID Y NO RECIBEN PARAMETROS

        //Set up
        Pedido pedido = new Pedido();
        pedido.cargarPlato(new Plato("Tallarines", 3560), 2);       //La suma da 8900.5
        pedido.cargarBebida(new Bebida("Seven up", (float)1780.5), 1);

        Tarjeta tarjeta = new TarjetaVisa();        //El descuento con Visa da 53.415

        //DispositivoElectronico dispositivo = new DispositivoElectronico();

        //Total con el descuento da 8847.085
        //Propina es de 445.025
        //Total mas la propina da 9292.11

        //Exercise
        //float montoFinal = dispositivo.totalConDescuentoAplicado(pedido, tarjeta, Propina.CINCO_PORCIENTO);

        //Verify
        //assertEquals(9292.11F, montoFinal, "ERROR");
    }


    @Test
    public void pagoConMastercardTest () {

        //Set up
        Pedido pedido = new Pedido();
        pedido.cargarPlato(new Plato("Tallarines", 3560), 2);       //Total sin descuento 8900.5
        pedido.cargarBebida(new Bebida("Seven up", (float)1780.5), 1);

        Tarjeta tarjeta = new TarjetaMastercard();        //El descuento con Master da 142.4

        //DispositivoElectronico dispositivo = new DispositivoElectronico();

        //Total con el descuento da 8758.1
        //Propina es de 267.015
        //Total con descuento mas la propina da 9025.115

        //Exercise
        //float montoFinal = dispositivo.totalConDescuentoAplicado(pedido, tarjeta, Propina.TRES_PORCIENTO);

        //Verify
        //assertEquals(9025.114F, montoFinal, "ERROR");
    }


    @Test
    public void pagoConComarca () {

        //Set up
        Pedido pedido = new Pedido();
        pedido.cargarPlato(new Plato("Tallarines", 3560), 2);       //Total sin descuento 8900.5
        pedido.cargarBebida(new Bebida("Seven up", (float)1780.5), 1);

        Tarjeta tarjeta = new TarjetaComarca();        //El descuento con Comarca da 178.01

        //DispositivoElectronico dispositivo = new DispositivoElectronico();

        //Total con el descuento da 8722.49
        //Propina es de 178.01
        //Total con descuento mas la propina da 8900.5

        //Exercise
        //float montoFinal = dispositivo.totalConDescuentoAplicado(pedido, tarjeta, Propina.DOS_PORCIENTO);

        //Verify
        //assertEquals(8900.5F, montoFinal, "ERROR");
    }


    @Test
    public void pagoConGenerica () {

        //Set up
        Pedido pedido = new Pedido();
        pedido.cargarPlato(new Plato("Tallarines", 3560), 2);       //Total sin descuento 8900.5
        pedido.cargarBebida(new Bebida("Seven up", (float)1780.5), 1);

        Tarjeta tarjeta = new TarjetaGenerica();        //No tiene descuento

        //DispositivoElectronico dispositivo = new DispositivoElectronico();

        //Propina es de 445.025
        //Total con descuento mas la propina da 9345.525

        //Exercise
        //float montoFinal = dispositivo.totalConDescuentoAplicado(pedido, tarjeta, Propina.CINCO_PORCIENTO);

        //Verify
        //assertEquals(9345.525F, montoFinal, "ERROR");
    }


}
