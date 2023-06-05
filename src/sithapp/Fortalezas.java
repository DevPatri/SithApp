/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sithapp;

import java.util.Objects;

/**
 *
 * @author Patri
 */
public class Fortalezas {
    private String nombre;

    public Fortalezas() {
        this.nombre = "";
    }

    public Fortalezas(String nombre) {
        this.nombre = nombre;
    }
    
    public Fortalezas(Fortalezas f){
        Fortalezas a = new Fortalezas(f);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.nombre);
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
        final Fortalezas other = (Fortalezas) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "nombre Fortaleza: " + nombre + ", ";
    }
    
    
    
    
}
