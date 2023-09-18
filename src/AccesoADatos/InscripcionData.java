package AccesoADatos;

import Entidades.Alumno;
import Entidades.Inscripcion;
import Entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {

    private final Connection con;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {

        con = Conexion.getConexion();
    }

    //-------------------------------------------------------------------------------------------------------------      
    public void guardarInscripcion(Inscripcion insc) {
        String sql = "INSERT INTO inscripcion( nota, idAlumno, idMateria)"
                + " VALUES (?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getAlumno().getIdAlumno());
            ps.setInt(3, insc.getMateria().getIdMateria());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys();) {
                if (rs.next()) {
                    insc.setIdIncripto(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Inscripcion guardada con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido guardar la Inscripcion ", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 

    }

    //-------------------------------------------------------------------------------------------------------------      
    public List<Inscripcion> obtenerInscripciones() {
        Inscripcion insc = null;
        List<Inscripcion> listaInscripciones = new ArrayList<>();
        String sql = "SELECT * FROM `inscripcion` WHERE 1";
        try (PreparedStatement stp = con.prepareStatement(sql); ResultSet rs = stp.executeQuery();) {
            while (rs.next()) {
                insc = new Inscripcion();
                insc.setIdIncripto(rs.getInt("idInscripto"));
                insc.setNota(rs.getDouble("nota"));
                insc.setAlumno(aluData.buscarAlumno(rs.getInt("idAlumno")));
                insc.setMateria(matData.buscarMateria(rs.getInt("idMateria")));
                listaInscripciones.add(insc);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 

        return listaInscripciones;
    }

    //-------------------------------------------------------------------------------------------------------------      
    public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {

        List<Inscripcion> listaInscripcionesPorAlumnos = new ArrayList<>();
        Inscripcion insc = null;
        List<Inscripcion> listaInscripciones = new ArrayList<>();
        String sql = "SELECT * FROM `inscripcion` WHERE idAlumno = ? ";
        try (PreparedStatement stp = con.prepareStatement(sql); ResultSet rs = stp.executeQuery();) {
            stp.setInt(1, idAlumno);
            while (rs.next()) {
                insc = new Inscripcion();
                insc.setIdIncripto(rs.getInt("idInscripto"));
                insc.setNota(rs.getDouble("nota"));
                insc.setAlumno(aluData.buscarAlumno(rs.getInt("idAlumno")));
                insc.setMateria(matData.buscarMateria(rs.getInt("idMateria")));
                listaInscripciones.add(insc);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 

        return listaInscripcionesPorAlumnos;
    }

    //-------------------------------------------------------------------------------------------------------------      
    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        List<Materia> materiasCursadas = new ArrayList<>();
        Materia mat = null;
        String sql = "SELECT inscripcion.idMateria, nombre, anno FROM inscripcion JOIN materia "
                + "ON(inscripcion.idMateria=materia.idMateria) WHERE inscripcion.idAlumno = ?;";
        try (PreparedStatement stp = con.prepareStatement(sql);) {
            stp.setInt(1, idAlumno);
            ResultSet rs = stp.executeQuery();
            while (rs.next()) {
                mat=new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnno(rs.getInt("anno"));
                materiasCursadas.add(mat);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 

        return materiasCursadas;
    }

    //-------------------------------------------------------------------------------------------------------------   
    public List<Materia> obtenerMateriasNOCursadas(int idAlumno) {
        List<Materia> listaMateriasNOCursadas = new ArrayList<>();
        Materia mat = null;
        String sql = "SELECT M.idMateria, M.nombre, M.anno\n"
                + "FROM Materia M\n"
                + "WHERE M.idMateria NOT IN (\n"
                + "    SELECT I.idMateria\n"
                + "    FROM Inscripcion I\n"
                + "    WHERE I.idAlumno = ?\n"
                + ");";
        try (PreparedStatement stp = con.prepareStatement(sql); ) {
            stp.setInt(1, idAlumno);
            ResultSet rs = stp.executeQuery();
            while (rs.next()) {
                 mat=new Materia();
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnno(rs.getInt("anno"));
                listaMateriasNOCursadas.add(mat);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 

        return listaMateriasNOCursadas;
    }

    //-------------------------------------------------------------------------------------------------------------     
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "DELETE FROM `inscripcion` WHERE idAlumno = ? AND idMateria = ?;";
         try (PreparedStatement stp = con.prepareStatement(sql);) {
             
             stp.setInt(1, idAlumno);
             stp.setInt(2, idMateria);
             int repultado = stp.executeUpdate();
            if (repultado == 1) {
                JOptionPane.showMessageDialog(null, "incripcion borrada");
            } else {
                JOptionPane.showMessageDialog(null, "error alborrar incripcion");
            }
         
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 
        

    }

//-------------------------------------------------------------------------------------------------------------     
    public void actualizarNota(int idAlumno, int idMateria, double nota) {

        String sql = "UPDATE `inscripcion` SET `nota`= ? WHERE idAlumno = ? AND idMateria = ?;";
        try (PreparedStatement stp = con.prepareStatement(sql);) {
            stp.setDouble(1, nota);
            stp.setInt(2, idAlumno);
            stp.setInt(3, idMateria);
            int repultado = stp.executeUpdate();
            if (repultado == 1) {
                JOptionPane.showMessageDialog(null, "nota actualizada");
            } else {
                JOptionPane.showMessageDialog(null, "error al actualizar nota");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 

    }

//-------------------------------------------------------------------------------------------------------------     
    public List<Alumno> obtenerAlumnoXMateriaMateria(int idMateria) {
        List<Alumno> listaAlumnoXMateriaMateria = new ArrayList<>();
        Alumno alu = null;
        String sql = "SELECT a.idAlumno, a.dni, a.apellido, a.nombre, a.fechaNacimiento, a.estado FROM `inscripcion`  "
                + "JOIN alumno a ON(a.idAlumno=inscripcion.idAlumno)  "
                + "JOIN materia m ON(m.idMateria=inscripcion.idMateria) WHERE inscripcion.idMateria= ?;" ;
         try (PreparedStatement stp = con.prepareStatement(sql);ResultSet rs = stp.executeQuery();) {
         stp.setInt(1, idMateria);
         while(rs.next()){
         alu= new Alumno();
         alu.setIdAlumno(rs.getInt("idAlumno"));
         alu.setDni(rs.getInt("dni"));
         alu.setApellido(rs.getString("apellido"));
         alu.setNombre(rs.getString("nombre"));
         alu.setFechaDeNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
         alu.setEstado(rs.getBoolean("estado"));
         listaAlumnoXMateriaMateria.add(alu);
         
         }
         
         }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error SQL contacte administrador" + ex.getMessage(), "Error Conexion base de datos sql", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } 

        return listaAlumnoXMateriaMateria;
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

}
