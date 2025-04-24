package modelo;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Producto> bebidas;
    private ArrayList<Producto> platos;


    public Menu() {
        this.bebidas = new ArrayList<>();
        this.platos = new ArrayList<>();
    }


    /*
    public void agregarAlMenu(modelo.Producto producto) {
        if(producto.esPlato()) {
            this.platos.add(producto);
        } else {
            this.bebidas.add(producto);
        }
    }
    */

}
