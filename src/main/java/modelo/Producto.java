package modelo;

public abstract class Producto {

    private String nombre;
    private float precio;


    public Producto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    //public abstract boolean esPlato();

    public float getPrecio() {
        return precio;
    }
}