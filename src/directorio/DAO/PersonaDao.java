/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package directorio.DAO;

import directorio.conexionDB.ConexionDb;
import directorio.modelo.Personas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class PersonaDao implements PersonaInterface{
    
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean insertar(Personas persona) {
        boolean resp = false;
        
        try{
        
            String sql = """
                         INSERT INTO public.persona(
                          identification, birthdate, name, lastname, adress_one, adress_two, person_type, contact_number_one, type_contact_number_one, contact_number_two, type_contact_number_two)
                          VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);""";
            
            ps = ConexionDb.getConexion().prepareStatement(sql);
            ps.setString(1, persona.getIdentification());
            ps.setDate(2, Date.valueOf(persona.getBirthDate()));
            ps.setString(3, persona.getName());
            ps.setString(4, persona.getLastname());
            ps.setString(5, persona.getAdressOne());
            ps.setString(6, persona.getAdressTwo());
            ps.setString(7, persona.getPersonType());
            ps.setString(8, persona.getContactNumberOne());
            ps.setString(9, persona.getTypeContactNumberOne());
            ps.setString(10, persona.getContactNumberTwo());
            ps.setString(11, persona.getTypeContactNumberTwo());
            
            if(ps.executeUpdate()>0){
                resp = true;
                JOptionPane.showMessageDialog(null, "Guardado Exitoso");
            }
            
            ps.close();
            ConexionDb.closeConexion();
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo Problemas " + e.getMessage());
        }
        
        return resp;
    }

    @Override
    public boolean actualizar(Personas persona) {
        boolean resp = false;
        
        try{
        
            String sql = """
                         UPDATE public.persona
                          	SET name=?, lastname=?, adress_one=?, adress_two=?, person_type=?, contact_number_one=?, type_contact_number_one=?, contact_number_two=?, type_contact_number_two=?, birthdate=?
                          	WHERE identification=?;""";
            
            ps = ConexionDb.getConexion().prepareStatement(sql);
            ps.setString(11, persona.getIdentification());
            ps.setDate(10, Date.valueOf(persona.getBirthDate()));
            ps.setString(1, persona.getName());
            ps.setString(2, persona.getLastname());
            ps.setString(3, persona.getAdressOne());
            ps.setString(4, persona.getAdressTwo());
            ps.setString(5, persona.getPersonType());
            ps.setString(6, persona.getContactNumberOne());
            ps.setString(7, persona.getTypeContactNumberOne());
            ps.setString(8, persona.getContactNumberTwo());
            ps.setString(9, persona.getTypeContactNumberTwo());
            
            if(ps.executeUpdate()>0){
                resp = true;
                JOptionPane.showMessageDialog(null, "Actualizado Exitoso");
            }
            
            ps.close();
            ConexionDb.closeConexion();
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo Problemas " + e.getMessage());
        }
        
        return resp;
    }

    @Override
    public boolean eliminar(String identificacion) {
        boolean resp = false;
        
        try {
            String delete = "delete from persona where identification = ?;";
            ps = ConexionDb.getConexion().prepareStatement(delete);
            ps.setString(1, identificacion);
            
            
            if (ps.executeUpdate()>0) {
                resp = true;
                JOptionPane.showMessageDialog(null, "Eliminacion Exitosa");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo Problemas " + e.getMessage());
        }
        
        return resp;
    }

    @Override
    public List<Personas> listar() {
        
        List<Personas> registros = new ArrayList<>();
        
        try {
            String consulta = "select * from persona";
            ps = ConexionDb.getConexion().prepareStatement(consulta);

            rs = ps.executeQuery();

            while (rs.next()) {
                registros.add(new Personas(rs.getDate(11).toLocalDate(), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10)));
            }

            rs.close();
            ps.close();
            ConexionDb.closeConexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo Problemas " + e.getMessage());
        }

        return registros;
    }

    @Override
    public Personas buscar(String identificacion) {

        Personas persona = null;
        
        try {
            String consulta = "select * from persona where identification=?;";

                ps = ConexionDb.getConexion().prepareStatement(consulta);
                ps.setString(1, identificacion);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    persona = new Personas(rs.getDate(11).toLocalDate(), rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron datos");
                }
                
                rs.close();
                ps.close();
                ConexionDb.closeConexion();
                
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Hubo Problemas " + e.getMessage());
        }
        
        return persona;
    }
    
}
