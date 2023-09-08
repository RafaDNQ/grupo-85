/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccesoADatos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class MateriaData {
    
    private Connection con = null ;
    
    private MateriaData(){
    
    con = Conexion.getConexion();
    
    }
    
    public void guardarMateria(Materia materia){
    
    String sql ="INSERT INTO materia( nombre, anno, estado) VALUES ( ?, ?, ?)";
    try{
     PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
     ps.setString(1, materia.getNombre());
     ps.setInt(2, materia.getAnno());
     ps.setBoolean(3, materia.isEstado());
     ps.executeUpdate();
     
    
    }
    catch(SQLException ex){
     JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia" + ex.getMessage());
    }
    
    
    
    }
    
    
    
    
}
