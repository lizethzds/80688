package mx.uv.c80688;


import static spark.Spark.*;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public static Gson gson = new Gson();
private static Map<String, Usuario> usuarios = new HashMap<>();




public class App {
    public static void main(String[] args) {

        port(port:80);
        System.out.prinln("Hello World");
        Usuario u1 = new Usuario("1","Pedro", "1234");
        Usuario u2 = new Usuario("2","Pablo", "7890");

        usuarios.put(u1.getId(),u1);
        usuarios.put(u2.getId(), u2);

        before((req,res)-> res.type(contentType:"application/json"));


        get("/", (req,res)-> gson.toJson(usuarios));
//crear la clase Usuario 

        post("/",(req,res)->{
            String datosCliente = req.body();
            Usuario u = gson.fromJson(datosCliente, Usuario.class);
            usuarios.put(u.getId(), u);
          //  return "listo, se ingreso el usuario"+ u.getId();

          return DAO.crearUsuario(u);



        }
        );

       

            
}