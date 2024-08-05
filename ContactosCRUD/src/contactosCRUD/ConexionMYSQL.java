package contactosCRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jquezada
 */
public class ConexionMYSQL {

    String db = "empleados";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "2022";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cn;

    public Connection conectar() {
        try {
            Class.forName(driver);
            cn = (Connection) DriverManager.getConnection(url + db, user, password);
            System.out.println("Estamos conectados con exito.");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error en la conexion :" + ex);
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    public void desconectar() {
        try {
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
