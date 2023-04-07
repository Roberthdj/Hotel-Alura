package factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionFactory {

    private final DataSource dataSource;
    
    private final String DATABASE = "hotel_alura";
    private final String URL = "jdbc:mysql://localhost/" + DATABASE + "?useTimeZone=true&serverTimeZone=UTC";
    private final String USER = "root";
    private final String PASSWORD = "Admin_root_1183";

    public ConexionFactory() {

        var comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(URL);
        comboPooledDataSource.setUser(USER);
        comboPooledDataSource.setPassword(PASSWORD);
        comboPooledDataSource.setMaxPoolSize(10);

        this.dataSource = comboPooledDataSource;
    }

    public Connection getConexion() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
