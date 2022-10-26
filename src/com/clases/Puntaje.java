/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appplantas;

/**
 *
 * @author Francisco
 */
public class Puntaje {
    //Atributos
    private int oxigenoMinimo;
    private int litrosMaximos;
    private int alimento;
    private int co2;
    private int tiempoVida;

    //Constructor
    public Puntaje(int oxigenoMinimoIngresado, int litrosMaximosIngresados,
     int alimentoIngresado, int dioxidoCarbonoMaximoIngresado, int tiempovidaIngresado){
        this.oxigenoMinimo = oxigenoMinimoIngresado;
        this.litrosMaximos = litrosMaximosIngresados;
        this.alimento = alimentoIngresado;
        this.co2 = dioxidoCarbonoMaximoIngresado;
        this.tiempoVida = tiempovidaIngresado;
    }

    //Accesores y mutadores(Getters y Setters)
    public int getOxigenoMinimo(){
        return this.oxigenoMinimo;
    }

    public int getLitrosMaximos(){
        return this.litrosMaximos;
    }

    public int getAlimento(){
        return this.alimento;
    } 

    public int getDioxidoCarbonoMaximo(){
        return this.co2;
    }

    public int getTiempoVida(){
        return this.tiempoVida;
    }
 
    public void setOxigenoMinimo(int oxigenoMinimoIngresado){
        this.oxigenoMinimo = oxigenoMinimoIngresado;
    }

    public void setLitrosMaximos(int litrosMaximosIngresados){
        this.litrosMaximos = litrosMaximosIngresados;
    }

    public void setAlimento(int alimentoIngresado){
        this.alimento = alimentoIngresado;
    } 

    public void setDioxidoCarbonoMaximo(int dioxidoCarbonoMaximoIngresado){
        this.co2 = dioxidoCarbonoMaximoIngresado;
    }

    public void setTiempoVida(int tiempovidaIngresado){
        this.tiempoVida = tiempovidaIngresado;
    }
    
    
    public int sumar(int oxigeno,int litros,int alimento,int co2,int vida){
        
        int sumaTotalPuntos;
        sumaTotalPuntos = oxigeno + litros + alimento + co2 + vida;
        return sumaTotalPuntos;
    }

    
}
