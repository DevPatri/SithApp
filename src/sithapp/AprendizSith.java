
package sithapp;

import java.util.Objects;

/**
 *
 * @author Patri
 */
public class AprendizSith extends Sith {
    private LordSith maestro;

    public AprendizSith() {
        super();
        this.maestro = new LordSith();
    }

    public AprendizSith(String nombre, int nivelMidi, int edad, Fortalezas forta) {
        super(nombre, nivelMidi, edad, forta);
    }
        
    /*
     * @param maestro
     * @param nombre
     * @param nivelMidi
     * @param edad
     * @param forta
    */
    public AprendizSith(LordSith maestro, String nombre, int nivelMidi, int edad, Fortalezas forta) {
        super(nombre, nivelMidi, edad, forta);
        this.maestro = maestro;
    }

    public LordSith getMaestro() {
        return maestro;
    }

    public void setMaestro(LordSith maestro) {
        this.maestro = maestro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.maestro);
        return hash;
    }

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
        final AprendizSith other = (AprendizSith) obj;
        return Objects.equals(this.maestro, other.maestro);
    }

    @Override
    public String toString() {
        return "AprendizSith: " + super.toString() + "maestro = " + maestro.getNombre() + '}';
    }
    
    
    
    
    
    
}