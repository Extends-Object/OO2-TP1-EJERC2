package modelo;

public class TarjetaVisa implements Tarjeta {

    @Override
    public float aplicarDescuento(float subtotalPlatos, float subtotalBebidas) {
        return ((subtotalBebidas * 3)/100);
    }

}