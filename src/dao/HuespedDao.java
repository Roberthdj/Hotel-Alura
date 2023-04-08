package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modelos.Huesped;

public class HuespedDao {

    private Connection conn;

    public HuespedDao(Connection conexion) {
        this.conn = conexion;
    }

    public List<Huesped> listar() {

        List<Huesped> resultado = new ArrayList<>();

        try {
            final PreparedStatement statement = conn
                    .prepareStatement("SELECT * FROM huespedes");

            try (statement) {
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {

                    while (resultSet.next()) {
                        resultado.add(new Huesped(
                                resultSet.getInt("id"),
                                resultSet.getInt("id_reserva"),
                                resultSet.getString("nombre"),
                                resultSet.getString("apellido"),
                                resultSet.getDate("fechaNacimiento"),
                                resultSet.getString("nacionalidad"),
                                resultSet.getString("telefono")
                        ));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultado;
    }

    public void guardar(Huesped huesped) {
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String nacimiento = date.format(huesped.getFechaNacimiento());

        try {
            PreparedStatement statement;

            statement = conn.prepareStatement(
                    "INSERT INTO HUESPEDES "
                    + "(id_reserva, nombre, apellido, fechaNacimiento, nacionalidad, telefono)"
                    + " VALUES (?, ?, ?, ?, ?, ?)"
            );

            try (statement) {

                statement.setInt(1, huesped.getId_reserva());
                statement.setString(2, huesped.getNombre());
                statement.setString(3, huesped.getApellido());
                statement.setDate(4, Date.valueOf(nacimiento));
                statement.setString(5, huesped.getNacionalidad());
                statement.setString(6, huesped.getTelefono());

                statement.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
