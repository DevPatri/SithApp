
package sithapp;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Patri
 */
public class LordSith extends Sith implements SableLaser{
    
    private boolean maestroSith;
    private boolean alphaSith;
    
    private ArrayList<AprendizSith> aprendices = new ArrayList<>();
    
    /*
     * 
    */
    public LordSith(){
        super();
        this.maestroSith = false;
        this.alphaSith = false;
        
    }
    
    /**
     * @param maestroSith
     * @param alphaSith
     * @param aprendices
     * @param nombre
     * @param nivelMidi
     * @param edad
     * @param forta
    */
    
    public LordSith(boolean maestroSith, boolean alphaSith, String nombre, int nivelMidi, int edad, Fortalezas forta) {
        super(nombre, nivelMidi, edad, forta);
        this.maestroSith = maestroSith;
        this.alphaSith = alphaSith;
    }

    public LordSith(boolean maestroSith, boolean alphaSith, AprendizSith aprendiz, String nombre, int nivelMidi, int edad, Fortalezas forta) {
        super(nombre, nivelMidi, edad, forta);
        this.maestroSith = maestroSith;
        this.alphaSith = alphaSith;
        //modifico para crear un nuevo array y que no lo pida por parámetro o lo dejo así??
        this.aprendices.add(aprendiz);      
    }
    
    public LordSith(LordSith p){
        LordSith a = new LordSith(p);
    }
    
    // interface implementada para enseñar el color del sable.         
    @Override
    public void ColorSableLaser() {
        System.out.println("El color del sable láser es ROJO!");
    }
    //Getters and Setters
    public boolean isMaestroSith() {
        return maestroSith;
    }

    public void setMaestroSith(boolean maestroSith) {
        this.maestroSith = maestroSith;
    }

    public boolean isAlphaSith() {
        return alphaSith;
    }

    public void setAlphaSith(boolean alphaSith) {
        this.alphaSith = alphaSith;
    }

    public ArrayList<AprendizSith> getAprendices() {
        return aprendices;
    }

    public void setAprendices(ArrayList<AprendizSith> aprendices) {
        this.aprendices = aprendices;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.maestroSith ? 1 : 0);
        hash = 67 * hash + (this.alphaSith ? 1 : 0);
        hash = 67 * hash + Objects.hashCode(this.aprendices);
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
        final LordSith other = (LordSith) obj;
        if (this.maestroSith != other.maestroSith) {
            return false;
        }
        if (this.alphaSith != other.alphaSith) {
            return false;
        }
        return Objects.equals(this.aprendices, other.aprendices);
    }

    @Override
    public String toString() {
        return "LordSith: " + super.toString() + "maestroSith=" + maestroSith + ", alphaSith=" + alphaSith + ", aprendices=" + aprendices.toString() + '}';
    }
    
    
    
}
