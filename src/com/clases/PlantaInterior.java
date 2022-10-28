/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases;

import java.util.Date;

/**
 *
 * @author romin
 */
public class PlantaInterior extends Planta{
    private String cantidadLuz;
    private int temperaturaCelcius;


    public PlantaInterior(String nombreIngresado, String fechaSembradoIngresado, int cantVecesRiegoIngresado,
        String cantidadLuzIngresado, int temperaturaCelciusIngresado){
        super(nombreIngresado, fechaSembradoIngresado, cantVecesRiegoIngresado);
        this.cantidadLuz = cantidadLuzIngresado;
        this.temperaturaCelcius = temperaturaCelciusIngresado;
    }

    public String getCantidadLuz() {
        return cantidadLuz;
    }

    public int getTemperaturaCelcius() {
        return temperaturaCelcius;
    }

    public void setCantidadLuz(String cantidadLuz) {
        this.cantidadLuz = cantidadLuz;
    }

    public void setTemperaturaCelcius(int temperatura) {
        this.temperaturaCelcius = temperatura;
    }


    public void mostrarDatos(String cantidadLuz, int temperaturaCelcius){

        System.out.println("El nombre de la planta es " + getNombre() + ".");
        System.out.println("La fecha de siembra es " +getFechaSembrado()+ ".");
        if(getCantVecesRiego() == 1){
            System.out.println("Se ha regado " +getCantVecesRiego()+ " vez esta planta.");
        }
        else{
            System.out.println("Se ha regado " +getCantVecesRiego()+ " veces esta planta.");
        }
        System.out.println("La cantidad de luz que la planta ha recibido es" + cantidadLuz);

    }
}
