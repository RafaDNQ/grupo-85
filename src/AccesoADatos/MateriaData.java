/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Usuario
 */
public class MateriaData {

    private Connection con = null;

    public MateriaData() {

        con = Conexion.getConexion();

    }

    //------------------------------------------------------------------------------------------------------------- 
    public void guardarMateria(Materia materia) {

        String sql = "INSERT INTO materia( nombre, anno, estado) VALUES ( ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnno());
            ps.setBoolean(3, materia.isEstado());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys();) {
                if (rs.next()) {
                    materia.setIdMateria(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Materia guardada con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido guardar la materia ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }

    }

    //------------------------------------------------------------------------------------------------------------- 
    public Materia buscarMateria(int id) {
        Materia materia = null;
        String sql = "SELECT * FROM materia where idMateria=? AND estado=1;";
        try (PreparedStatement stp = con.prepareStatement(sql);) {
            stp.setInt(1, id);
             ResultSet rs = stp.executeQuery();
            if (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnno(rs.getInt("anno"));
                materia.setEstado(rs.getBoolean("estado"));
            } else {
                System.out.println("Materia no encontrada");
                JOptionPane.showMessageDialog(null, "No existe la materia");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + e.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
        return materia;
    }

    //------------------------------------------------------------------------------------------------------------- 
    public List<Materia> listarMaterias() {
        Materia materia = null;
        List<Materia> listaMaterias = new ArrayList<>();
        String sql = "SELECT * FROM `materia` WHERE activo = 1";
        try (PreparedStatement stp = con.prepareStatement(sql); ResultSet rs = stp.executeQuery();) {
            while (rs.next()) {
                materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnno(rs.getInt("anno"));
                materia.setEstado(rs.getBoolean("estado"));
                listaMaterias.add(materia);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + e.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
        return listaMaterias;
    }

    //------------------------------------------------------------------------------------------------------------- 
    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre=?,anno=? WHERE idMateria=?";
        try (PreparedStatement stp = con.prepareStatement(sql);) {
            stp.setString(1, materia.getNombre());
            stp.setInt(2, materia.getAnno());
            stp.setInt(3, materia.getIdMateria());
            stp.executeUpdate();
            int exito = stp.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Materia existosamente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + e.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    //------------------------------------------------------------------------------------------------------------- 
    public void eliminarMateria(int id) {
        String sql = "UPDATE materia SET estado = 0 WHERE idMateria = ?";
        try (PreparedStatement stp = con.prepareStatement(sql);) {
            stp.setInt(1, id);
            int comprobacion = stp.executeUpdate();
            if (comprobacion == 1) {
                JOptionPane.showMessageDialog(null, "Eliminacion exitosa!!", "Eliminacion", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido eliminar", "Eliminacion", JOptionPane.WARNING_MESSAGE);

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + e.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } 
    }

    //------------------------------------------------------------------------------------------------------------- 
    private void cerrarConexion(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al cerror la conexion" + ex.getMessage(), "Error Conexion", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }

    }
    //------------------------------------------------------------------------------------------------------------- 

}
