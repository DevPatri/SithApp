package sithapp;

import java.util.ArrayList;
import java.util.Objects;
import javafx.scene.control.Alert;

/**
 *
 * @author Patri
 */
public class LordSith extends Sith {

    private boolean maestroSith;
    private boolean alphaSith;
    private int anioAscensoLord;
    private ArrayList<AprendizSith> aprendices = new ArrayList<>();

    /*
     * 
     */
    public LordSith() {
    }

    /**
     * @param maestroSith
     * @param alphaSith
     * @param anioAscensoLord
     * @param aprendices
     * @param nombre
     * @param nivelMidi
     * @param edad
     * @param forta
     */
    public LordSith(boolean maestroSith, boolean alphaSith, int anioAscensoLord, String nombre, int nivelMidi, int edad, Fortalezas forta) {
        super(nombre, nivelMidi, edad, forta);
        this.maestroSith = maestroSith;
        this.alphaSith = alphaSith;
        this.anioAscensoLord = anioAscensoLord;
    }

//    public LordSith(boolean maestroSith, boolean alphaSith, int anioAscensoLord, String nombre, int nivelMidi, int edad, Fortalezas forta, AprendizSith aprendiz) {
//        super(nombre, nivelMidi, edad, forta);
//        this.maestroSith = maestroSith;
//        this.alphaSith = alphaSith;
//        this.anioAscensoLord = anioAscensoLord;
//        this.aprendices.add(aprendiz);
//    }

    public LordSith(LordSith p) {
        LordSith a = new LordSith(p);
    }

    // interface implementada para enseñar el color del sable.         
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

    public int getAnioAscensoLord() {
        return anioAscensoLord;
    }

    public void setAnioAscensoLord(int anioAscensoLord) {
        this.anioAscensoLord = anioAscensoLord;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.maestroSith ? 1 : 0);
        hash = 17 * hash + (this.alphaSith ? 1 : 0);
        hash = 17 * hash + this.anioAscensoLord;
        hash = 17 * hash + Objects.hashCode(this.aprendices);
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
        if (this.anioAscensoLord != other.anioAscensoLord) {
            return false;
        }
        return Objects.equals(this.aprendices, other.aprendices);
    }

    @Override
    public String toString() {
        return "LordSith: " + super.toString() + "maestroSith: " + maestroSith + ", alphaSith: " + alphaSith + ", anioAscensoLord: " + anioAscensoLord + ", aprendices: " + mostrarAprendices() + '}';
    }

    public void agregarAprendiz(AprendizSith aprendiz) {
        if (aprendices.size() < 3) {
            aprendices.add(aprendiz);
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setContentText("No puedes entrenar mas Aprendices Sith.");
            alert.showAndWait();
        }
    }

    public void eliminarAprendiz(AprendizSith aprendiz) {
        aprendices.remove(aprendiz);
    }
    public String mostrarAprendices(){
        String SAprendices = "";
        for(AprendizSith aprendiz: aprendices){
           
           SAprendices += aprendiz.getNombre();
           SAprendices += " ";
        }
        return SAprendices;
    }
}
