package Conexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Prueba {
    int Id;
    String Nombre;
    
    protected PreparedStatement ejecutador;
    ConexionBD Conexion;
    
    public Prueba(){
        Conexion = new ConexionBD(
        "com.mysql.jdbc.Driver", //Driver de conexión
        "jdbc:mysql://localhost/Prueba", //Conexion especificando la Base de Datos
        "root", //Usuario
        "" //Contraseña
        );
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public void Insertar(){
        String ejecutar_sp_insertar;
        try{
            ejecutar_sp_insertar = "call SP_INSERTAR_INFO(?,?)";
            ejecutador = Conexion.Retornar_Conexion().prepareStatement(ejecutar_sp_insertar);
            ejecutador.setInt(1, Id);
            ejecutador.setString(2, Nombre);
            ejecutador.executeUpdate();
        }
        catch(SQLException sql){
            sql.printStackTrace();
        }
    }
    public void Eliminar(int Llave){
        String ejecutar_sp_eliminar;
        try{
            ejecutar_sp_eliminar = "call SP_ELIMINAR_INFO(?)";
            ejecutador = Conexion.Retornar_Conexion().prepareStatement(ejecutar_sp_eliminar);
            ejecutador.setInt(1, Llave);
            ejecutador.executeUpdate();
        }
        catch(SQLException sql){
            sql.printStackTrace();
        }
    }
    public void Editar(){
        String ejecutador_sp_editar;
        try{
            ejecutador_sp_editar = "call SP_EDITAR_INFO(?,?)";
            ejecutador = Conexion.Retornar_Conexion().prepareStatement(ejecutador_sp_editar);
            ejecutador.setInt(1, Id);
            ejecutador.setString(2, Nombre);
            ejecutador.executeUpdate();
        }
        catch(SQLException sql){
            sql.printStackTrace();
        }
    }
}
