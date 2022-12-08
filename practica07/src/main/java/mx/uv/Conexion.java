package mx.uv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static String url ="jdbc:mysql://127.0.0.1:3306/BDejemplo";
    private static String driverName ="com.mysql.jdbc.Driver"; 
    private static String userName ="root";

    //variable de conexion
    private static Connection connection = null;


    public static Connection getConnection(){
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            System.out.prinln(e);
        } catch(ClassNotFoundException e){
            System.out.println("Driver:" + e);
        }
        return null;
    }
}
