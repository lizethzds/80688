package mx.uv.c80688;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import mx.uv.Conexion;
import mx.uv.Usuario;

public class DAO {
    private static Conexion c = new Conexion();

    public static List<Usuario> dameUsuarios(){
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        List<Usuario> resultado = new ArrayList<>();
        conn = c.getConnection();
        try {
            String sql = "SELECT * from  usuarios80688 ";
            stm = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Usuario u = new Usuario(rs.getString("id"), rs.getString("nombre"), rs.getString("password")
                resultado.add(u);
            }
        } catch (Exception e) {
            System.out.println("Driver :" + e);
        } finally{
            if(rs !=null)
            try{
                rs.close();
            } catch (SQLException e){
                System.out.println(e);
            }
            rs=null;
            if(stmt !=null){
                try{
                    stmt.close();
                }catch(Exception e){
                    System.out.println(e);
                }
                stmt = null;
            }
        }
        return null;
    }


    public static String crearUsuario(Usuario u){


        PreparedStatement stmt = null;
        Connection conn =  null;
        conn = c.getConnection();
        try {
            String sql = "INSERT INTO usuarios (id, nombre, password) values (?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getId());
            stmt.setString(2, u.getNombre());
            stmt.setString(3, u.getPassword());
            if (stmt.executeUpdate(sql)>0)
            msj = "usuario agregado";
            else{
                msj = "usuario no agregado";
            }

        } catch (Exception e) { 
                System.out.println("Driver :" + e);
            } finally{
                if(rs !=null)
                try{
                    rs.close();
                } catch (SQLException e){
                    System.out.println(e);
                }
                rs=null;
                if(stmt !=null){
                    try{
                        stmt.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    stmt = null;
                }
        }
        return null;
    }
}
