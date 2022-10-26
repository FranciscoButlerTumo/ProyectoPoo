/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appplantas;

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
    private String nombre;
    private String apellido;
    private String alias;
    private String correoElectronico;
    private int numeroCelular;
    private int cantPlantasSembradas;
    private String pais;
    private String ciudad;
    private String direccion;
    private ArrayList<Planta> plantasUsuario = new ArrayList();
    
    //Constructores
    public Usuario(String nombreIngresado, String apellidoIngresado, String aliasIngresado, 
    String correoElectronicoIngresado, int numeroCelularIngresado, int cantPlantasSembradaIngresadas,
    String paisIngresado, String ciudadIngresada, String direccionIngresada){
    
        this.nombre = nombreIngresado;
        this.apellido = apellidoIngresado;
        this.alias = aliasIngresado;
        this.correoElectronico = correoElectronicoIngresado;
        this.numeroCelular = numeroCelularIngresado;
        this.cantPlantasSembradas = cantPlantasSembradaIngresadas;
        this.pais = paisIngresado;
        this.ciudad = ciudadIngresada;
        this.direccion = direccionIngresada;
    }
    
    public Usuario(){
        this.nombre = null;
        this.apellido = null;
        this.alias = null;
        this.correoElectronico = null;
        this.numeroCelular = 0;
        this.cantPlantasSembradas = 0;
        this.pais = null;
        this.ciudad = null;
        this.direccion = null;
    }
    
    //Accesores y mutadores(Getters y Setters)
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getAlias() {
        return alias;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public int getCantPlantasSembradas() {
        return cantPlantasSembradas;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }
    
    
    public String getDireccion() {
        return direccion;
    }
    
    public ArrayList<Planta> getPlantasUsuario(){
        return plantasUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public void setCantPlantasSembradas(int cantPlantasSembradas) {
        this.cantPlantasSembradas = cantPlantasSembradas;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
        System.out.println("Alias: "+ this.alias);
        System.out.println("E-mail: "+ this.correoElectronico);
        System.out.println("Fono: "+ this.numeroCelular);
        System.out.println("Direccion: "+this.direccion+", "+ this.ciudad +", " + this.pais);
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

    

