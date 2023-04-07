package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import modelos.Reserva;

public class ReservaDao {

    private Connection conn;
    private int idReserva;

    public ReservaDao(Connection conexion) {
        this.conn = conexion;
    }    
    
    public int guardar(Reserva reserva) {

        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String Entrada = date.format(reserva.getFechaEntrada());
        String Salida = date.format(reserva.getFechaSalida());

        try {

            PreparedStatement statement;
            statement = conn.prepareStatement(
                    "INSERT INTO RESERVAS "
                    + "(fechaEntrada, fechaSalida, valor, tipoHabitacion, formaPago)"
                    + " VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                statement.setDate(1, Date.valueOf(Entrada));
                statement.setDate(2, Date.valueOf(Salida));
                statement.setDouble(3, reserva.getValor());
                statement.setString(4, reserva.getTipoHabitacion());
                statement.setString(5, reserva.getFormaPago());

                statement.execute();

                ResultSet resultSet = statement.getGeneratedKeys();

                try (resultSet) {
                    while (resultSet.next()) {
                        idReserva = resultSet.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }              
        return idReserva;
    }
}