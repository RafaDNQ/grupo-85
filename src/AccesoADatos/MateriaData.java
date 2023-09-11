
package AccesoADatos;

import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MateriaData {
    
    private Connection con = null ;
    
    private MateriaData(){
    
    con = Conexion.getConexion();
    
    }
    
    public void guardarMateria(Materia materia){
    
        String sql = "INSERT INTO materia( nombre, anno, estado) VALUES ( ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnno());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                JOptionPane.showInternalMessageDialog(null, "Materia guardada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia" + ex.getMessage());
        }
    }    
    
    public Materia buscarMateria(int idMateria) {
       
        String sql = "SELECT nombre,año FROM materia WHERE idmateria = ? AND estado = 1";
        Materia materia = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                materia = new Materia();
                materia.setIdMateria(idMateria);
                materia.setNombre(rs.getString("nombre"));  
                materia.setAnno(rs.getInt("Año"));
                materia.setEstado(true);

                JOptionPane.showMessageDialog(null, "Materia Encontrada");
            } else {
                JOptionPane.showMessageDialog(null, "No existe esa Materia");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia" + ex.getMessage());
        }
        return materia;
    }    
    
    //----------------------------------------------------------------------------------------------------
     
    public void modificarMateria (Materia materia) {
         
         
     }
     
    //----------------------------------------------------------------------------------------------------
    
     public void eliminarMateria (int id) {
         
         
     }
    
    //----------------------------------------------------------------------------------------------------
     
     public List<Materia> listarMaterias() {
         
        List<Materia> listaMaterias = new ArrayList<>();
        
        
        
        
       return listaMaterias;  
     }
     
}    
    

