
package Entidades;

public class Materia {
    private int idMateria;
    private String nombre;
    private int anno;
    private boolean estado;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int annoMateria, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anno = annoMateria;
        this.estado = activo;
    }

    public Materia(String nombre, int annoMateria, boolean activo) {
        this.nombre = nombre;
        this.anno = annoMateria;
        this.estado = activo;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.nombre;
    }   
    
}
