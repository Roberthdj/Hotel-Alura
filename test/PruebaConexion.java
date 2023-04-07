
import factory.ConexionFactory;
import java.sql.Connection;
import java.sql.SQLException;


public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        ConexionFactory factory = new ConexionFactory();
        Connection conn = factory.getConexion();
        System.out.println("Exito!!");
        conn.close();
    }
    
}
