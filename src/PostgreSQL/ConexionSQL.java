package PostgreSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionSQL {
    private Connection conn = null;

    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USUARIO = "postgres";
    private final String CLAVE = "root";


    public void conectar() {
        try {
            Class.forName("org.postgresql.Driver"); 
            conn = DriverManager.getConnection(URL, USUARIO, CLAVE);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, " No se encontró el driver JDBC: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al conectar con PostgreSQL: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Connection getConnection() {
        return conn;
    }
    
    public static Connection obtenerConexion() throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/postgres";
        String USUARIO = "postgres";
        String CLAVE = "root";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver JDBC: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
