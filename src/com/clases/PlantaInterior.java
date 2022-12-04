/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases;

/**
 *
 * @author romin
 */
public class PlantaInterior extends Planta{
    private String tipoDia;
    private int temperaturaCelcius;


    public PlantaInterior(String nombreIngresado, String fechaSembradoIngresado, int cantVecesRiegoIngresado,
        String tipoDiaIngresado, int temperaturaCelciusIngresado){
        super(nombreIngresado, fechaSembradoIngresado, cantVecesRiegoIngresado);
        this.tipoDia = tipoDiaIngresado;
        this.temperaturaCelcius = temperaturaCelciusIngresado;
    }

    public String getTipoDia() {
        return tipoDia;
    }

    public int getTemperaturaCelcius() {
        return temperaturaCelcius;
    }

    public void setCantidadLuz(String tipoDia) {
        this.tipoDia = tipoDia;
    }

    public void setTemperaturaCelcius(int temperatura) {
        this.temperaturaCelcius = temperatura;
    }


    public void mostrarDatos(){

        System.out.println("El nombre de la planta es " + getNombre() + ".");
        System.out.println("La fecha de siembra es " +getFechaSembrado()+ ".");
        if(getCantVecesRiego() == 1){
            System.out.println("Se ha regado " +getCantVecesRiego()+ " vez esta planta.");
        }
        else{
            System.out.println("Se ha regado " +getCantVecesRiego()+ " veces esta planta.");
        }
        System.out.println("La planta es" + getTipoDia());
        
        System.out.println("La temperatura de la planta es "+ getTemperaturaCelcius());

    }
}
