package MysqlFormulario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/proyectobd?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "1234";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa a MySQL.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        Connection con = conectar();
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
