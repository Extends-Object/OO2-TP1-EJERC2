import exceptions.DatabaseConnectionException;

import java.time.LocalDate;

public class DispositivoElectronico {

    private RegistroPedido registro;

    public DispositivoElectronico(RegistroPedido registro) {
        this.registro = registro;
    }

    public void totalConDescuentoAplicado (Pedido pedido, Tarjeta tarjetaCredito, Propina propina, LocalDate fecha) throws DatabaseConnectionException {

        float totalConDescuentoYPropina = 0;

        float subtotalBebidas = pedido.calcularSubtotalBebidas();
        float subtotalPlatos = pedido.calcularSubtotalPlatos();
        float totalSinDescuento = pedido.calcularSubtotal();

        float totalConDescuento = totalSinDescuento - tarjetaCredito.aplicarDescuento(subtotalPlatos, subtotalBebidas);
        totalConDescuentoYPropina = totalConDescuento + propina.aplicar(totalSinDescuento);

        this.registro.registrarPedido(fecha, totalConDescuentoYPropina);

        //return totalConDescuentoYPropina = totalConDescuento + propina.aplicar(totalSinDescuento);		//Propina puede ser 0.02, 0.03, 0.05
    }

}