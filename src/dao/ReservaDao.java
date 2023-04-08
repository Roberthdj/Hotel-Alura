package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelos.Reserva;

public class ReservaDao {

    private Connection conn;
    private int idReserva;

    public ReservaDao(Connection conexion) {
        this.conn = conexion;
    }

    public List<Reserva> listar() {

        List<Reserva> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = conn
                    .prepareStatement("SELECT * FROM reservas");

            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {

                    while (resultSet.next()) {
                        resultado.add(new Reserva(
                                resultSet.getInt("id"),
                                resultSet.getDate("fechaEntrada"),
                                resultSet.getDate("fechaSalida"),
                                resultSet.getDouble("valor"),
                                resultSet.getString("tipoHabitacion"),
                                resultSet.getString("formaPago")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public int guardar(Reserva reserva) {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String entrada = date.format(reserva.getFechaEntrada());
        String salida = date.format(reserva.getFechaSalida());

        try {

            PreparedStatement statement;
            statement = conn.prepareStatement(
                    "INSERT INTO RESERVAS "
                    + "(fechaEntrada, fechaSalida, valor, tipoHabitacion, formaPago)"
                    + " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setDate(1, Date.valueOf(entrada));
                statement.setDate(2, Date.valueOf(salida));
                statement.setDouble(3, reserva.getValor());
                statement.setString(4, reserva.getTipoHabitacion());
                statement.setString(5, reserva.getFormaPago());

                statement.execute();

                ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet) {

                    while (resultSet.next()) {
                        idReserva = resultSet.getInt(1);
                    }

                    return idReserva;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int eliminar(int idReserva) {

        try {

            PreparedStatement statement = conn.prepareStatement("DELETE FROM reservas WHERE id = ?");

            try (statement) {
                statement.setInt(0, idReserva);
                statement.execute();

                int updateCount = statement.getUpdateCount();

                return updateCount;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
