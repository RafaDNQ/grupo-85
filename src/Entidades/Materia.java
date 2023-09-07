/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Usuario
 */
public class Materia {
    int idMateria;
    String nombre;
    int annoMateria;
    boolean activo;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int annoMateria, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.annoMateria = annoMateria;
        this.activo = activo;
    }

    public Materia(String nombre, int annoMateria, boolean activo) {
        this.nombre = nombre;
        this.annoMateria = annoMateria;
        this.activo = activo;
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

    public int getAnnoMateria() {
        return annoMateria;
    }

    public void setAnnoMateria(int annoMateria) {
        this.annoMateria = annoMateria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", annoMateria=" + annoMateria + ", activo=" + activo + '}';
    }
    
    
    
    
    
    
}
