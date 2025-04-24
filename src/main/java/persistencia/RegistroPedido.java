package persistencia;

import exceptions.DatabaseConnectionException;

import java.time.LocalDate;

public interface RegistroPedido {

    public void registrarPedido(LocalDate fecha, float montoFinal) throws DatabaseConnectionException;
}
