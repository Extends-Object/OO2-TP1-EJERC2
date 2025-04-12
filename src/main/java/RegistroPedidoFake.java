import exceptions.DatabaseConnectionException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistroPedidoFake implements RegistroPedido{

    private final List<String> listaPedidos = new ArrayList<>();

    @Override
    public void registrarPedido(LocalDate fecha, float montoFinal) throws DatabaseConnectionException {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fecha.format(formato);

        this.listaPedidos.add("Fecha: " + fechaFormateada + ", Monto: " + String.valueOf(montoFinal));

        //simular registro de un pedido

    }

    //PARA IMPRIMIR EN EL TEST
    public List<String> getListaPedidos() {
        return listaPedidos;
    }
}
