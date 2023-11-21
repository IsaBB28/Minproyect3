/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package directorio.conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author usuario
 */
public class ConexionDb {
    private static Connection conexion = null;
    private static final String HOST = "localhost";
    private static final String PUERTO = "5432";
    private static final String DB = "directorio";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";
    
    public static Connection getConexion(){
    
    try{
        
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://"+HOST+":"+PUERTO+"/"+DB;
        conexion = DriverManager.getConnection(url, USER, PASSWORD);
        
        JOptionPane.showMessageDialog(null, "conexion exitosa");
    } catch (Exception e){
        JOptionPane.showMessageDialog(null, "conexion fallida " + e.getMessage());
    }
    
    return conexion;
    }
    
    public static void closeConexion(){
    
        try{
            conexion.close();
        } catch (Exception e){
        
            JOptionPane.showMessageDialog(null, "desconexion fallida " + e.getMessage());
        }
    }
}
