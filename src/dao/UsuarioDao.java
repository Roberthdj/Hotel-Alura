package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDao {

    private final Connection conn;

    public UsuarioDao(Connection conn) {
        this.conn = conn;
    }

    public boolean buscarUsuario(String usuario, String contrasena) {
  
        try {
            final PreparedStatement statement = conn
                    .prepareStatement("SELECT * FROM usuarios WHERE usuario = ? AND contrasena = ?");

            try (statement) {
                statement.setString(1, usuario);
                statement.setString(2, contrasena);
                statement.execute();

                final ResultSet resultSet = statement.getResultSet();

                try (resultSet) {

                    while (resultSet.next()) {
                        if(resultSet.getString("usuario").equals(usuario) 
                                && resultSet.getString("contrasena").equals(contrasena)){
                            
                            return true;
                            
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         return false;
    }
}
