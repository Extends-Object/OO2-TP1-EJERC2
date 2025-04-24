package modelo;

public class TarjetaMastercard implements Tarjeta {

    @Override
    public float aplicarDescuento(float subtotalPlatos, float subtotalBebidas) {
        return ((subtotalPlatos * 2)/100);
    }
}