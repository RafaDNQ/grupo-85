
package AccesoADatos;

import Entidades.Inscripcion;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class InscripcionData {
    private final Connection con;
    private MateriaData matData;
    private AlumnoData aluData;
    
    public InscripcionData() {
        
         con = Conexion.getConexion();    
    }   
    
 //-------------------------------------------------------------------------------------------------------------      
    public void guardarInscripcion(Inscripcion insc) {
        
    }
    
 //-------------------------------------------------------------------------------------------------------------      
 
     public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> listaInscripciones = new ArrayList<>();   
        
        
        
        return listaInscripciones;  
     }  
    
 //-------------------------------------------------------------------------------------------------------------      
    
     public List<Inscripcion> obtenerInscripcionesPorAlumno(int idAlumno) {
        
        List<Inscripcion> listaInscripcionesPorAlumnos = new ArrayList<>();
        
        
        
        
        
        
         return listaInscripcionesPorAlumnos;
     }   
    
 //-------------------------------------------------------------------------------------------------------------      
    
    public List<Materia> obtenerMateriasCursadas(int idAlumno) {
        List<Materia> materiasCursadas = new ArrayList<>();
        
        
        
        
        
      return materiasCursadas;  
    }  
    
 //-------------------------------------------------------------------------------------------------------------   

public List<Materia> obtenerMateriasNOCursadas(int id) {
        List<Materia> listaMateriasNOCursadas = new ArrayList<>();
        
        
       
        
        
        
        
   return listaMateriasNOCursadas;      
}    
    
 //-------------------------------------------------------------------------------------------------------------     

public void borrarInscripcionMateriaAlumno(int idInscripto) {
    
    
    
        
}


//-------------------------------------------------------------------------------------------------------------     

public void actualizarNota(int idInscripto, int nota){


}

//-------------------------------------------------------------------------------------------------------------     

public List<Alumno> obtenerAlumnoXMateriaMateria(int idMateria) {
        List<Alumno> listaAlumnoXMateriaMateria = new ArrayList<>();
        
        
       return listaAlumnoXMateriaMateria;
    }

}
