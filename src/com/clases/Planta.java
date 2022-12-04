/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases;

import java.util.Date;

/**
 *
 * @author Francisco
 */
public abstract class Planta{
    //Atributos
    private String nombre;
    private String fechaSembrado;
    private int cantVecesRiego;

    //Contructor
    public Planta(){
        nombre = null;
        fechaSembrado = null;
        cantVecesRiego = 0;
    }
    
    public Planta(String nombreIngresado, String fechaSembradoIngresado, int cantVecesRiegoIngresado){
        this.nombre = nombreIngresado;
        this.fechaSembrado = fechaSembradoIngresado;
        this.cantVecesRiego = cantVecesRiegoIngresado;
    }

    //Accesores y mutadores(Getters y Setters)
    public String getNombre() {
        return nombre;
    }

    public String getFechaSembrado() {
        return fechaSembrado;
    }

    public int getCantVecesRiego() {
        return cantVecesRiego;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaSembrado(String fechaSembrado) {
        this.fechaSembrado = fechaSembrado;
    }

    public void setCantVecesRiego(int cantVecesRiego) {
        this.cantVecesRiego = cantVecesRiego;
    }
    
    public abstract void mostrarDatos();
}
