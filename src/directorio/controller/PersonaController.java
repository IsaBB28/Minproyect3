/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package directorio.controller;

import directorio.DAO.PersonaDao;
import directorio.modelo.Personas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class PersonaController {
    
    DefaultTableModel modelo;
    
    public boolean guardar(String identificacion, String direccionUno, String direccionDos, String nombres, String apellidos, String tipoContacto, 
            String telefonoUno, String referenciaUno, String telefonoDos, String referenciaDos, String cumpleaños){
        
        boolean resp = false;
        
        Personas persona = new Personas();
        
        PersonaDao personaDao = new PersonaDao();
        
        persona.setIdentification(identificacion);
        persona.setAdressOne(direccionUno);
        persona.setAdressTwo(direccionDos);
        persona.setName(nombres);
        persona.setLastname(apellidos);
        persona.setPersonType(tipoContacto);
        persona.setContactNumberOne(telefonoUno);
        persona.setTypeContactNumberOne(referenciaUno);
        persona.setContactNumberTwo(telefonoDos);
        persona.setTypeContactNumberTwo(referenciaDos);
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try{
            LocalDate fecha = LocalDate.parse(cumpleaños, formato);
            persona.setBirthDate(fecha);
            personaDao.insertar(persona);
            
            resp = true;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "formato de fecha invalido " + e.getMessage());
        }
        
        return resp;
    }
    
    public boolean editar(String identificacion, String direccionUno, String direccionDos, String nombres, String apellidos, String tipoContacto, 
            String telefonoUno, String referenciaUno, String telefonoDos, String referenciaDos, String cumpleaños){
        
        boolean resp = false;
        
        Personas persona = new Personas();
        
        PersonaDao personaDao = new PersonaDao();
        
        persona.setIdentification(identificacion);
        persona.setAdressOne(direccionUno);
        persona.setAdressTwo(direccionDos);
        persona.setName(nombres);
        persona.setLastname(apellidos);
        persona.setPersonType(tipoContacto);
        persona.setContactNumberOne(telefonoUno);
        persona.setTypeContactNumberOne(referenciaUno);
        persona.setContactNumberTwo(telefonoDos);
        persona.setTypeContactNumberTwo(referenciaDos);
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        try{
            LocalDate fecha = LocalDate.parse(cumpleaños, formato);
            persona.setBirthDate(fecha);
            personaDao.actualizar(persona);
            resp = true;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "formato de fecha invalido " + e.getMessage());
        }
        
        return resp;
    }

    public Personas buscar(String identificacion){
        Personas persona;
        PersonaDao personaDao = new PersonaDao();
        
        persona = personaDao.buscar(identificacion);
        
        return persona;
    }
    
    public boolean eliminar(String identificacion){
        boolean resp = false;
        
        PersonaDao personaDao = new PersonaDao();
        
        if(personaDao.eliminar(identificacion)){
            resp = true;
        }
        
        return resp;
    }

    public DefaultTableModel mostrar(){
        List<Personas> lista = new ArrayList<>();
        
        PersonaDao personaDao = new PersonaDao();
        
        lista.addAll(personaDao.listar());
        
        String[] title = {"Identificacion", "nombres", "apellidos", "direccion uno", "direccion dos", "tipo de contacto", "telefono uno", 
            "referencia telefono uno", "telefono dos", "referencia telefono dos", "fecha de nacimiento"};
        modelo = new DefaultTableModel(null, title);
        
        String[] registro = new String[11];
        
        for (Personas item : lista) {
            registro[0] = item.getIdentification();
            registro[1] = item.getName();
            registro[2] = item.getLastname();
            registro[3] = item.getAdressOne();
            registro[4] = item.getAdressTwo();
            registro[5] = item.getPersonType();
            registro[6] = item.getContactNumberOne();
            registro[7] = item.getTypeContactNumberOne();
            registro[8] = item.getContactNumberTwo();
            registro[9] = item.getTypeContactNumberTwo();
            registro[10] = item.getBirthDate().toString();
            
            modelo.addRow(registro);
        }
        
        return modelo;
        
    }
}
