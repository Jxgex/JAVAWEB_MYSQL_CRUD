package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * Autor: Jorge Eduardo Martínez Mohedano
 * Fecha: 08-01-2021
 * Descripción: Singleton para la conexión de con la base de datos.
 */
public class ConexionBD {
   String Drive;
   String User;
   String Password;
   String Url;
   Connection Conexion;
   //Constructor de la clase, recibe los datos por parámetros
   //para ser asignados a los atributos de la clase al momento
   //de crear un objeto.
   public ConexionBD(String Controlador, String url, String user, String password){
       this.Drive = Controlador;
       this.Url = url;
       this.User = user;
       this.Password = password;
   }
   //Método encargado del retorno de la cadena 
   //de conexión de la base de datos.
   public Connection Retornar_Conexion(){
       try {
           Class.forName(Drive);
           Conexion = DriverManager.getConnection(Url,User,Password);
           return Conexion;
       } 
       catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       } 
       catch(SQLException ex){
           ex.printStackTrace();
       }
       return null;
   }
}
