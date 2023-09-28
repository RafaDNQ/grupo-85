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

    
    /**
     * guarda Alumnos en la base de datos
     * @param alumno recibe un Alumno
     */
    public void guardarAlumno(Alumno alumno) {

        String sql = "INSERT INTO alumno(dni,apellido,nombre,fechaNacimiento,estado)"
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
                   // JOptionPane.showMessageDialog(null, "Alumno Guardado :)");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
            ex.printStackTrace();
        } 
    }

    /**
     Busca alumnos en la base de datos por id.
     * @param id es el id del alumno a buscar en la base de datos.
     * @return devuelve un Objeto de tipo Alumno si lo encuentra ,sino devuelve null.
     */
    public Alumno buscarAlumno(int id) {
        String sql = "SELECT dni, apellido,nombre,fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
        Alumno alumno = null;
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                alumno = new Alumno();
                alumno.setIdAlumno(id);
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaDeNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(true);

               // JOptionPane.showMessageDialog(null, "Alumno Guardado :V");
            } else {
                //JOptionPane.showMessageDialog(null, "no se encontro alumno :V", "Error", JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
        }
        return alumno;
    }
    
    /**
     busca a un objeto de tipo Alumno por el dni.
     * @param dni int recibe un dni como entero.
     * @return devuelve un Alumno si lo encuentra caso contrario null.
     */

    public Alumno buscarAlumnoDNI(int dni) {
        String sql = "SELECT * FROM alumno WHERE dni = ? AND estado = 1";
        Alumno alumno = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaDeNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));

                //JOptionPane.showMessageDialog(null, "Alumno Encontrado");
            } else {
                //JOptionPane.showMessageDialog(null, "No existe ese Alumno");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno :,( " + ex.getMessage());
            ex.printStackTrace();
        }
        return alumno;
    }
    
    /**
     *recupera de la base de datos una lista de alumnos.
     *@return retorna una lista de de objetos de tipo Alumno.
     *@throws SQLException puede lanzar una excepcion si falla la conexion.
     */
    
    public List<Alumno> listaralumnos() throws SQLException {
        List<Alumno> listaAlumno = new ArrayList<>();
        String sql = "SELECT * FROM `alumno` WHERE estado = 1";
        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("IdAlumno"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaDeNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
                alumno.setEstado(rs.getBoolean("estado"));
                listaAlumno.add(alumno);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
            ex.printStackTrace();
        } 
        return listaAlumno;
    }

    /**
     * Modifica al alumno existente en la base de datos si el metodo buscarAluno lo encuentra.
     @param alumno recibe un objeto de tipo Alumno.
     @see #buscarAlumno(int) 
     */
    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET dni =?, apellido=?, nombre=?, fechaNacimiento=?"
                + "WHERE idAlumno=?";

        try (PreparedStatement ps = con.prepareStatement(sql);) {
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
        }
    }
    
    /**
     * Este metodo establece el estado de un alumno en 0 segun su id
     @param id recibe un entero que es el id
   
     */

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
        }
    }
    
    /**
     este metodo remueve de la baseded datos a los alumnos con estado=0 false
     * 
     * 
     * 
     */
    public void removeralumno(){

        String sql = "DELETE FROM alumno WHERE estado = 0";

        try (PreparedStatement ps = con.prepareStatement(sql);) {

            int exito = ps.executeUpdate();
            if (exito == 1) {
                //JOptionPane.showMessageDialog(null, "Alumno eliminado :V ");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno" + ex.getMessage());
         
        }

    }
    
    
    
    /**
     * este metodo se encagar de cerrar la conexion a la base de datos no devuelve ningun valor
     * @param  con  un objeto de tipo Connection
     * @throws SQLException si no se puede cerrar la conexion 
     * @deprecated no se recomienda su uso debido que la conexion se instancia con cada clase data 
     * si se usa con un finally al final de los metodos la segunda vez que se quiera llamar a un metodo
     * este lanzara una excepcion de tipo SQLException 
    */
    @Deprecated
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
