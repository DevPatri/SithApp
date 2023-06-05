
package sithapp;

import java.util.Objects;

/**
 *
 * @author Patri
 */
public class AprendizSith extends Sith {
    private int anioLadoOscuro;
    private LordSith maestro;

    public AprendizSith() {
        super();
        this.maestro = new LordSith();
    }

    public AprendizSith(String nombre, int nivelMidi, int edad, Fortalezas forta, int anioLadoOscuro) {
        super(nombre, nivelMidi, edad, forta);
        this.anioLadoOscuro = anioLadoOscuro;
    }
        
    /*
     * @param maestro
     * @param nombre
     * @param nivelMidi
     * @param edad
     * @param forta
    */
    public AprendizSith(LordSith maestro, String nombre, int nivelMidi, int edad, Fortalezas forta,  int anioLadoOscuro) {
        super(nombre, nivelMidi, edad, forta);
        this.maestro = maestro;
        this.anioLadoOscuro = anioLadoOscuro;
    }
    public AprendizSith(AprendizSith p){
        super(p.nombre,p.nivelMidi,p.edad,p.forta);
        this.maestro = p.maestro;
        this.anioLadoOscuro = p.anioLadoOscuro;
    }

    public LordSith getMaestro() {
        return maestro;
    }

    public void setMaestro(LordSith maestro) {
        this.maestro = maestro;
    }
    
    public int getAnioLadoOscuro() {
        return anioLadoOscuro;
    }

    public void setAnioLadoOscuro(int anioLadoOscuro) {
        this.anioLadoOscuro = anioLadoOscuro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.anioLadoOscuro;
        hash = 71 * hash + Objects.hashCode(this.maestro);
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
        if (this.anioLadoOscuro != other.anioLadoOscuro) {
            return false;
        }
        return Objects.equals(this.maestro, other.maestro);
    }

    @Override
    public String toString() {
        return "AprendizSith{" + "anioLadoOscuro=" + anioLadoOscuro + ", maestro=" + maestro + '}';
    }

    
    

    
    
    
    
    
    
    
}