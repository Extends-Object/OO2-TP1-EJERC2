public class DispositivoElectronico {


    public float totalConDescuentoAplicado (Pedido pedido, Tarjeta tarjetaCredito, Propina propina) {

        float totalConDescuentoYPropina = 0;

        float subtotalBebidas = pedido.calcularSubtotalBebidas();
        float subtotalPlatos = pedido.calcularSubtotalPlatos();
        float totalSinDescuento = pedido.calcularSubtotal();

        float totalConDescuento = totalSinDescuento - tarjetaCredito.aplicarDescuento(subtotalPlatos, subtotalBebidas);

        return totalConDescuentoYPropina = totalConDescuento + propina.aplicar(totalSinDescuento);		//Propina puede ser 0.02, 0.03, 0.05
    }

}