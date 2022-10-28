/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Francisco
 */

public class Usuario{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY"); 
    
    //Atributos
    private String usuario;
    private String nombre;
    private String apellido;
    private int cantPlantasSembradas;
    private ArrayList<Planta> plantasUsuario;
    
    //Constructores
    public Usuario(String usuarioIngresado, String nombreIngresado, String apellidoIngresado
            , int cantPlantasSembradaIngresadas, ArrayList<Planta> plantasIngresadas){
        this.usuario = usuarioIngresado;
        this.nombre = nombreIngresado;
        this.apellido = apellidoIngresado;
        this.cantPlantasSembradas = cantPlantasSembradaIngresadas;
        this.plantasUsuario = plantasIngresadas;
    }
    
    public Usuario(){
        this.usuario = null;
        this.nombre = null;
        this.apellido = null;
        this.cantPlantasSembradas = 0;
        this.plantasUsuario = new ArrayList<Planta>();
    }
    
    //Accesores y mutadores(Getters y Setters)
    public String getUsuario(){
        return usuario;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCantPlantasSembradas() {
        return cantPlantasSembradas;
    }
    
    public ArrayList<Planta> getPlantasUsuario(){
        return plantasUsuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCantPlantasSembradas(int cantPlantasSembradas) {
        this.cantPlantasSembradas = cantPlantasSembradas;
    }

    public void setPlantasUsuario(ArrayList<Planta> plantasUsuario) {
        this.plantasUsuario = plantasUsuario;
    }
    
    
    //Métodos
    
 
    public void agregarPlantas (){
        Scanner Entrada = new Scanner(System.in);
        Planta nuevaPlanta = new Planta();
        String auxNombre;
        String auxDate;
        int auxNum;
        
        //ingresar nombre
        System.out.println("Ingrese el nombre de la planta o árbol:");
        auxNombre = Entrada.nextLine();
        
        //ingresar fecha
        System.out.println("Ingrese la fecha en que fue sembrada la planta o árbol:");
        System.out.println("Ingresela con el siguiente formato: 'dia/mes/año' en valores numericos");
        auxDate = Entrada.nextLine();
        
        //ingrese cantVecesRiego
        System.out.println("Ingrese cantidad de veces que se ha regado:");
        auxNum = Entrada.nextInt();
        
        if(auxDate != null){ // para evitar agregar una fecha nula
            nuevaPlanta.setNombre(auxNombre);
            nuevaPlanta.setFechaSembrado(stringADate(auxDate));
            nuevaPlanta.setCantVecesRiego(auxNum);
            this.plantasUsuario.add(nuevaPlanta);
        }
    }
    
    public int contarPlantas(){
        int suma = this.plantasUsuario.size();
        return suma;
    }
    
    public void mostrarDatos(){
        System.out.println("Datos del usuario");
        System.out.println("Nombre: "+this.nombre+" "+ this.apellido);
        System.out.println("Plantas sembradas: "+ contarPlantas());
    }
    
    //date a string
    //pienso que deberia ser privado ya que solo sirve para la funcion agregarPlantas
    private Date stringADate(String var){
        Date fecha = null;
        try{ //try catch necesario, sirve para seguir una serie de intrsucciones cuando hay un error
            fecha = sdf.parse(var); 
        }catch(ParseException e){   //ParseException e tipo de error
        } //en blanco porque no hay instucciones para cuando haya error
        return fecha; // si es valido retorna un dato tipo date y si no es valido retorna un dato null
    }   
}

    

