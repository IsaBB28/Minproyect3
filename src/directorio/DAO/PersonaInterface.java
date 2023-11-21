/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package directorio.DAO;

import directorio.modelo.Personas;
import java.util.List;

/**
 *
 * @author usuario
 */
public interface PersonaInterface {
    
    public boolean insertar(Personas persona);
    
    public boolean actualizar(Personas persona);
    
    public boolean eliminar(String identificacion);
    
    public List<Personas> listar();
    
    public Personas buscar(String identificacion);
}
