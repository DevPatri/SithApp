
package sithapp;

import java.util.Objects;

/**
 *
 * @author Patri
 */
public abstract class Sith {
    private String nombre;
    private int nivelMidi;
    private int edad;
    private Fortalezas forta;

    //constructor por defecto para no hacer ExceptionNullPointer
    public Sith() {    
        this.nombre = "";
        this.nivelMidi = 0;
        this.edad = 0;
        this.forta = new Fortalezas();
    }
    //constructor con parámetros
    /*
     * @param nombre
     * @param nivelMidi
     * @param edad
     * @param forta
    */
    public Sith(String nombre, int nivelMidi, int edad, Fortalezas forta) {
        this.nombre = nombre;
        this.nivelMidi = nivelMidi;
        this.edad = edad;
        this.forta = forta;
    }
    //Getters and Setters
    public Fortalezas getForta() {
        return forta;
    }

    public void setForta(Fortalezas forta) {
        this.forta = forta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelMidi() {
        return nivelMidi;
    }

    public void setNivelMidi(int nivelMidi) {
        this.nivelMidi = nivelMidi;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    //HasCode para comparaciones
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + this.nivelMidi;
        hash = 89 * hash + this.edad;
        hash = 89 * hash + Objects.hashCode(this.forta);
        return hash;
    }
    //método equals para comparar objetos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sith other = (Sith) obj;
        if (this.nivelMidi != other.nivelMidi) {
            return false;
        }
        if (this.edad != other.edad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.forta, other.forta);
    }
    //método toString
    @Override
    public String toString() {
        return "Sith: " + "nombre=" + nombre + ", nivelMidi=" + nivelMidi + ", edad=" + edad + ", forta=" + forta + '}';
    }
    
    
    
}
