public class TarjetaComarca implements Tarjeta{

    @Override
    public float aplicarDescuento(float subtotalPlatos, float subtotalBebidas) {
        return (((subtotalPlatos + subtotalBebidas) * 2)/100);
    }
}
