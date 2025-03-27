import java.util.ArrayList;

public class Pedido {

    //ArrayList<Producto> listaSeleccionados;

    ArrayList<Producto> listaPlatos;
    ArrayList<Producto> listaBebidas;

    private float subtotalPlatos;
    private float subtotalBebidas;
    private float total;



    public Pedido() {
        this.listaPlatos = new ArrayList<>();
        this.listaBebidas = new ArrayList<>();

        this.subtotalPlatos = 0;
        this.subtotalBebidas = 0;
        this.total = 0;
    }


    //Primero se crea el pedido

    public void cargarPlato (Producto plato, int cantidad){
        for (int i = 0; i < cantidad; i++) {
            this.listaPlatos.add(plato);
        }
    }

    public void cargarBebida (Producto bebida, int cantidad){
        for (int i = 0; i < cantidad; i++) {
            this.listaBebidas.add(bebida);
        }
    }



    //Ahora calcular los costos

    public float calcularSubtotalPlatos(){
        this.subtotalPlatos = 0;
        for(Producto producto : listaPlatos){
            this.subtotalPlatos += producto.getPrecio();
        }
        return this.subtotalPlatos;
    }


    public float calcularSubtotalBebidas(){
        this.subtotalBebidas = 0;
        for(Producto producto : listaBebidas){
            this.subtotalBebidas+= producto.getPrecio();
        }
        return this.subtotalBebidas;
    }


    public float calcularSubtotal() {
        return this.total = this.calcularSubtotalPlatos() + this.calcularSubtotalBebidas();
    }
}