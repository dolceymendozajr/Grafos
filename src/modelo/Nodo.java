/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author dolceya
 */
public class Nodo {
    
    int id;
    ArrayList<Nodo> hijos;
    int peso;

    public Nodo(int id) {
        this.id = id;
        this.hijos=new ArrayList<>();
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }

    public void addHijo(int id) {
        this.hijos.add(new Nodo(id));
    }

    public int getPeso() {
        return peso;
    }

    public int getId() {
        return id;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
    
}
