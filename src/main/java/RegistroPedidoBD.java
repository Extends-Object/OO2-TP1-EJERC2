import exceptions.DatabaseConnectionException;
import persistencia.ConnectionManager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class RegistroPedidoBD implements RegistroPedido{

    @Override
    public void registrarPedido(LocalDate fecha, float montoFinal) throws DatabaseConnectionException {
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO ventas (fecha, monto) " + "VALUES (?, ?)");

            statement.setDate(1, Date.valueOf(fecha));
            statement.setFloat(2, montoFinal);

            int cantidad = statement.executeUpdate();
            System.out.println(cantidad);

            if (cantidad == 0) {
                System.out.println("Error al insertar el registro.");
            }

        } catch (SQLException e) {
            System.out.println("Error al procesar la sentencia.");
            throw new DatabaseConnectionException("Error en la conexión: " + e.getMessage());
        } finally {
            ConnectionManager.disconnect();
        }
    }
}
