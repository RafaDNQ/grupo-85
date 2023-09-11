
package Entidades;

public class Inscripcion {
    int idInscripto;
    Alumno alumno;
    Materia materia;
    double nota;

    public Inscripcion() {
    }

    public Inscripcion(double nota) {
        this.nota = nota;
    }
    

    public Inscripcion(int idInscripto, Alumno alumno, Materia materia, double nota) {
        this.idInscripto = idInscripto;
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdIncripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
 @Override
    public String toString() {
        //return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + '}';
        String insc = idInscripto + " " + alumno.getApellido() + ", " + alumno.getNombre() + " " + materia.getNombre();
        return insc;    
    }
}
