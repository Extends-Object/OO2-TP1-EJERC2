import exceptions.DatabaseConnectionException;
import java.time.LocalDate;
import java.util.List;

public class DispositivoElectronico {

    //private List<Pedido> listaPedidos;
    private RegistroPedido registro;

    public DispositivoElectronico(RegistroPedido registro) {
        this.registro = registro;
    }

    public float totalConDescuentoAplicado (Pedido pedido, Tarjeta tarjetaCredito, Propina propina, LocalDate fecha) throws DatabaseConnectionException {

        //SOLO PARA MOSTRAR EN TEST
        //this.listaPedidos.add(pedido);

        //CALCULO DE SUBTOTALES
        float subtotalBebidas = pedido.calcularSubtotalBebidas();
        float subtotalPlatos = pedido.calcularSubtotalPlatos();
        float totalSinDescuento = pedido.calcularSubtotal();

        //CALCULO DE TOTALES SIN Y CON DESCUENTO
        float totalConDescuento = totalSinDescuento - tarjetaCredito.aplicarDescuento(subtotalPlatos, subtotalBebidas);
        float totalConDescuentoYPropina = totalConDescuento + propina.aplicar(totalSinDescuento);

        //REGISTRAR EL PEDIDO
        this.registro.registrarPedido(fecha, totalConDescuentoYPropina);

        return totalConDescuentoYPropina;
        // Propina puede ser 0.02, 0.03, 0.05
    }

}