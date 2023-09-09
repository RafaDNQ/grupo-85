package AccesoADatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import Entidades.Alumno;
import java.util.ArrayList;
import java.util.List;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {

        con = Conexion.getConexion();
    }

    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumno(dni,apellido,nombre,fechaNac,estado)"
                + "VALUE (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaDeNacimiento()));
            ps.setBoolean(5, alumno.isEstado());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys();) {
                if (rs.next()) {

                    alumno.setIdAlumno(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Alumno Guardado");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());

        } finally {
            cerrarConexion(con);
        }
    }

    public Alumno buscarAlumno(int id) {
        String sql = "SELECT dni, apellido,nombre,fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
        Alumno alumno = null;
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            ps.setInt(1, id);
            if (rs.next()) {

                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaDeNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);

                JOptionPane.showMessageDialog(null, "Alumno Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Alumno");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        } finally {
            cerrarConexion(con);
        }
        return alumno;
    }

    public Alumno buscarAlumnoDNI(int dni) {
        String sql = "SELECT dni, apellido,nombre,fechaNacimiento FROM alumno WHERE dni = ? AND estado = 1";
        Alumno alumno = null;
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            ps.setInt(1, dni);

            if (rs.next()) {

                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("IdAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaDeNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);

                JOptionPane.showMessageDialog(null, "Alumno Guardado");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Alumno");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        } finally {
            cerrarConexion(con);
        }
        return alumno;
    }

    public List<Alumno> listaralumnos() throws SQLException {
        List<Alumno> listaAlumno = new ArrayList<>();
        String sql = "SELECT * FROM `alumno` WHERE activo = 1";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("IdAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaDeNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);
                listaAlumno.add(alumno);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
            ex.printStackTrace();
        } finally {
            cerrarConexion(con);
        }
        return listaAlumno;
    }

    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni =?, apellido=?, nombre=?, fechaNacimiento=?"
                + "WHERE idAlumno=?";

        try(PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setDate(4, Date.valueOf(alumno.getFechaDeNacimiento()));
            ps.setInt(5, alumno.getIdAlumno());

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno modificado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }finally{
            cerrarConexion(con);
        }
    }

    public void eliminarAlumno(int id) {
        String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";

        try (PreparedStatement ps = con.prepareStatement(sql);) {

            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Alumno eliminado");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        } finally {
            cerrarConexion(con);
        }
    }

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