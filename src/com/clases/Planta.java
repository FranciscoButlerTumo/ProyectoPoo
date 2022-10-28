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
public class Planta{
    //Atributos
    private String nombre;
    private Date fechaSembrado;
    private int cantVecesRiego;

    //Contructor
    public Planta(){
        nombre = null;
        fechaSembrado = null;
        cantVecesRiego = 0;
    }
    
    public Planta(String nombreIngresado, Date fechaSembradoIngresado, int cantVecesRiegoIngresado){
        this.nombre = nombreIngresado;
        this.fechaSembrado = fechaSembradoIngresado;
        this.cantVecesRiego = cantVecesRiegoIngresado;
    }

    //Accesores y mutadores(Getters y Setters)
    public String getNombre() {
        return nombre;
    }

    public Date getFechaSembrado() {
        return fechaSembrado;
    }

    public int getCantVecesRiego() {
        return cantVecesRiego;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaSembrado(Date fechaSembrado) {
        this.fechaSembrado = fechaSembrado;
    }

    public void setCantVecesRiego(int cantVecesRiego) {
        this.cantVecesRiego = cantVecesRiego;
    }
    
    public void mostrarDatos(){
        System.out.println("El nombre de la planta es " +nombre+ ".");
        System.out.println("La fecha de siembra es " + fechaSembrado + ".");
        if(cantVecesRiego == 1){    
            System.out.println("Se ha regado " +cantVecesRiego+ " vez esta planta.");
        }
        else{
            System.out.println("Se ha regado " +cantVecesRiego+ " veces esta planta.");
        }   
    }
}
