
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Adm
 */
public class conectaDAO {

    public Connection connectDB() {
        Connection conn = null;
        try {

           conn = DriverManager.getConnection("jdbc:mysql://localhost/uc11?user=root&password=Hunter25**&useSSL=false");

            return conn;
        } catch (SQLException erro) {
            
            return null;
        }

    }

}
