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
    Scanner sc = new Scanner(System.in);
    
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
    
 
    public void agregarPlantas(){
        String opcion, nombre, fechaSembrado, cantLuz, tipClima, temporada,tempC, cantRiego;
        Planta plant;
        do{
            System.out.println("¿Desea agregar una planta de interior o de exterior?");
            System.out.println("1)Planta de Interior");
            System.out.println("2)Planta de Exterior");
        
            System.out.println("0)EXIT");
            
            opcion = sc.nextLine();
        
            switch(opcion){
                case "1":
                    //Planta
                    System.out.println("\n");
                    System.out.println("Ingrese el nombre de la planta");
                    nombre = sc.nextLine();
                    
                    System.out.println("Ingrese la fecha en la cual sembro la planta");
                    fechaSembrado = sc.nextLine();
                    
                    if(validarFechaSembrado(fechaSembrado)){
                        System.out.println("La fecha ingresada no es valida");
                        return;
                    }    
                   
                    
                    System.out.println("Ingrese cuantas veces rego la planta");
                    cantRiego = sc.nextLine();
                    if(Integer.parseInt(cantRiego)<0){
                        System.out.println("Error cantidad inferior a 0");
                        return;
                    }
                    
                    //PlantaInterior
                    System.out.println("Ingrese el tipo de luz que recibe)");
                    System.out.println("Ingrese 1) Para dia Corto");
                    System.out.println("Ingrese 2) Para dia Largo");
                    
                    System.out.println("0)EXIT");
                    cantLuz = sc.nextLine();
                    String tipoDia; 
                    
                    switch(opcion){
                        case "1":
                            //dia Corto
                            tipoDia = "dia Corto";
                            break;
                            
                        case "2":
                            //dia Largo
                            tipoDia = "dia Largo";
                            break;
                        
                        case "0": 
                            //exit
                            return;
                        
                        default:
                            System.out.println("Opcion invalida");
                            return;
                    }
                    

                    
                    System.out.println("Ingrese la temperatura de la planta");
                    tempC = sc.nextLine();
                    
                    plant  = new PlantaInterior(nombre,fechaSembrado
                            ,Integer.parseInt(cantRiego),tipoDia ,Integer.parseInt(tempC));
                    
                    if(!validarUsuarioRep(plant)){
                        this.plantasUsuario.add(plant);
                        System.out.println("La planta "+nombre+" fue ingresada con exito");
                        this.setCantPlantasSembradas(this.getCantPlantasSembradas()+1);
                    }
                    else{
                         System.out.println("La planta ya fue registrada, ingrese otro nombre");
                         
                    }
                    return;
                    
                case "2":
                    //Planta Exterior
                    System.out.println("\n");
                    System.out.println("Ingrese el nombre de la planta");
                    nombre = sc.nextLine();
                    
                    System.out.println("Ingrese la fecha en la cual sembro la planta con el formato DD/MM/YYYY");
                    fechaSembrado = sc.nextLine();
                    
                    if(!validarFechaSembrado(fechaSembrado)){
                        System.out.println("La fecha ingresada no es valida");
                        return;
                    }    
                    
                    
                    
                    
                    System.out.println("Ingrese cuantas veces rego la planta");
                    cantRiego = sc.nextLine();
                    
                    //PlantaExterior
                    System.out.println("Ingrese el tipo de clima que presenta la planta");
                    System.out.println("Ingrese 1) Para clima seco");
                    System.out.println("Ingrese 2) Para clima tropical");
                    System.out.println("Ingrese 3) Para clima templado");
                    System.out.println("Ingrese 4) Para clima continental");
                    
                    System.out.println("0)EXIT");
                    
                    opcion = sc.nextLine();
                    String tipoClima;
                    
                    switch(opcion){
                        case "1":
                            tipoClima = "seco";
                            break;
                        
                        case "2":
                            tipoClima = "tropical";
                            break;
                        
                        case "3":
                            tipoClima = "templado";
                            break;
                        
                        case "4":
                            tipoClima = "continental";
                            break;
                        
                        case "0":
                            return;
                        
                        default:
                            System.out.println("Opcion no valida");
                            return;
                            
                    }
                    
                    
                    
                    
                    System.out.println("Ingrese la temporada de la planta");
                    System.out.println("Ingrese 1) Para clima verano");
                    System.out.println("Ingrese 2) Para clima otoño");
                    System.out.println("Ingrese 3) Para clima invierno");
                    System.out.println("Ingrese 4) Para clima primavera");
                    
                    System.out.println("0)EXIT");
                    
                    opcion = sc.nextLine();
                    
                    
                    switch(opcion){
                        case "1":
                            temporada = "verano";
                            break;
                        
                        case "2":
                            temporada = "otoño";
                            break;
                        
                        case "3":
                            temporada = "invierno";
                            break;
                        
                        case "4":
                            temporada = "primavera";
                            break;
                        
                        case "0":
                            return;
                        
                        default:
                            System.out.println("Opcion no valida");
                            return;
                            
                    }
                    
                    plant  = new PlantaExterior(nombre,fechaSembrado
                            ,Integer.parseInt(cantRiego),tipoClima,temporada);
                    
                    if(!validarUsuarioRep(plant)){
                        this.plantasUsuario.add(plant);
                        System.out.println("La planta "+nombre+" fue ingresada con exito");
                        this.setCantPlantasSembradas(this.getCantPlantasSembradas()+1);
                    }
                    else{
                         System.out.println("La planta ya fue registrada, ingrese otro nombre");
                    }
                    
                   
                    
                    return;
                default:
                    System.out.println("Ingrese una opcion valida");
                    
                    break;
            }
        }while(!"0".equals(opcion));    
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
    
    public boolean validarUsuarioRep(Planta plantaIngresado){
        for(int i=0;i<this.plantasUsuario.size();i++){
            if((this.plantasUsuario.contains(plantaIngresado))
                    || this.plantasUsuario.get(i).getNombre().equals(plantaIngresado.getNombre())){
                return true;
            }
        }
        return false;
    }
    public void buscarPlanta(){
        String nombreIngresado;
        do{
            System.out.println("Ingrese el nombre de la planta que desea buscar");
            System.out.println("0)EXIT");
            System.out.println();
            nombreIngresado = sc.nextLine();
            
            for(int i=0;i<this.plantasUsuario.size();i++){
                if(this.plantasUsuario.get(i).getNombre().equals(nombreIngresado)){
                    System.out.println("Planta encontrada, sus datos son los siguientes:");
                    System.out.println();
                    this.plantasUsuario.get(i).mostrarDatos();
                    System.out.println();
                    return;
                }
            }
            System.out.println("Planta no encontrada, ingrese un nombre valido");
            System.out.println();
        }while("0".equals(nombreIngresado));
    }
    
    public void buscarPlantaMenosRegada(){
        ArrayList<Planta> plantasMenosRegadas = new ArrayList<Planta>();
        int cantMenor = -1, cantRiego;
        for(int i=0;i<this.plantasUsuario.size();i++){
            cantRiego = this.plantasUsuario.get(i).getCantVecesRiego();
            if(cantMenor == -1 || cantRiego < cantMenor){
                cantMenor = cantRiego;
            }
        }
        for(int i=0;i<this.plantasUsuario.size();i++){
            cantRiego = this.plantasUsuario.get(i).getCantVecesRiego();
            if(cantRiego == cantMenor){
                plantasMenosRegadas.add(this.plantasUsuario.get(i));
            }
        }
        
        for(int i=0; i< plantasMenosRegadas.size(); i++){
            plantasMenosRegadas.get(i).mostrarDatos();
            System.out.println();
        }
        
    }
    public void eliminarPlanta(){
        String nombreIngresado;
        do{
            System.out.println("Ingrese el nombre de la planta que desea eliminar");
            System.out.println("0)EXIT");
            System.out.println();
            nombreIngresado = sc.nextLine();
            
            for(int i=0;i<this.plantasUsuario.size();i++){
                if(this.plantasUsuario.get(i).getNombre().equals(nombreIngresado)){
                    
                    
                    this.plantasUsuario.remove(i);
                    System.out.println("La panta ha sido borrada del sistema");
                    System.out.println();
                    return;
                }
            }
            System.out.println("Planta no encontrada, ingrese un nombre valido");
            System.out.println();
        }while("0".equals(nombreIngresado));
    }
    
    public void mostrarDatosPlantas(){
        for(int i=0; i< this.plantasUsuario.size(); i++){
            this.plantasUsuario.get(i).mostrarDatos();
            System.out.println();
        }
    }
    
    public void modificarPlanta(){
        String nombreIngresado, opcion, cambio;
        do{
            System.out.println("Ingrese el nombre de la planta que desea modificar");
            System.out.println("0)EXIT");
            System.out.println();
            nombreIngresado = sc.nextLine();
            
            for(int i=0;i<this.plantasUsuario.size();i++){
                if(this.plantasUsuario.get(i).getNombre().equals(nombreIngresado)){
                    
                    
                    
                    if(this.plantasUsuario.get(i) instanceof PlantaExterior){
                        System.out.println("Planta encontrada, ¿Que dato desea modificar?");
                        System.out.println("1)Nombre");
                        System.out.println("2)Fecha");
                        System.out.println("3)Cantidad de veces regada");
                        System.out.println("4)Tipo de clima");
                        System.out.println("5)Temporada");
                        System.out.println("0)EXIT");       
                        opcion = sc.nextLine();
                        
                        switch(opcion){
                            case "1":
                                System.out.println("Ingrese el nuevo nombre");
                                cambio = sc.nextLine();
                                this.plantasUsuario.get(i).setNombre(cambio);
                                break;
                            case "2":
                                System.out.println("Ingrese la nueva fecha");
                                cambio = sc.nextLine();
                                this.plantasUsuario.get(i).setFechaSembrado(cambio);
                                break;
                            case "3":
                                System.out.println("Ingrese la nueva cantidad de veces regada");
                                cambio = sc.nextLine();
                                this.plantasUsuario.get(i).setCantVecesRiego(Integer.parseInt(cambio));
                                break;
                            case "4":
                                System.out.println("Ingrese el nuevo clima");
                                cambio = sc.nextLine();
                                ((PlantaExterior)this.plantasUsuario.get(i)).setTipoClima(cambio);
                                break;
                            case "5":
                                System.out.println("Ingrese la nueva temporada");
                                cambio = sc.nextLine();
                                ((PlantaExterior)this.plantasUsuario.get(i)).setTemporada(cambio);
                                break;
                            case "0":
                                return;
                            default:
                                System.out.println("Opcion invalida, ingrese una opccion valida");
                                return;
                        }
                        System.out.println("Se ha realizado el cambio");
                        return;

                    }
                    else{
                        System.out.println("Planta encontrada, ¿Que dato desea modificar?");
                        System.out.println("1)Nombre");
                        System.out.println("2)Fecha");
                        System.out.println("3)Cantidad de veces regada");
                        System.out.println("4)Cantidad de luz");
                        System.out.println("5)Temperatura en celcius");
                        System.out.println("0)EXIT");       
                        opcion = sc.nextLine();
                        
                        switch(opcion){
                            case "1":
                                System.out.println("Ingrese el nuevo nombre");
                                cambio = sc.nextLine();
                                this.plantasUsuario.get(i).setNombre(cambio);
                                break;
                            case "2":
                                System.out.println("Ingrese la nueva fecha");
                                cambio = sc.nextLine();
                                this.plantasUsuario.get(i).setFechaSembrado(cambio);
                                break;
                            case "3":
                                System.out.println("Ingrese la nueva cantidad de veces regada");
                                cambio = sc.nextLine();
                                this.plantasUsuario.get(i).setCantVecesRiego(Integer.parseInt(cambio));
                                break;
                            case "4":
                                System.out.println("Ingrese la nueva cantidad de luz");                                
                                cambio = sc.nextLine();
                                ((PlantaInterior)this.plantasUsuario.get(i)).setCantidadLuz(cambio);
                                break;
                            case "5":
                                System.out.println("Ingrese la nueva temperatura");
                                cambio = sc.nextLine();
                                ((PlantaInterior)this.plantasUsuario.get(i)).setTemperaturaCelcius(Integer. valueOf(cambio));
                                break;
                            case "0":
                                return;
                            default:
                                System.out.println("Opcion invalida, ingrese una opccion valida");
                                return;
                        }
                        System.out.println("Se ha realizado el cambio");
                        return;
                        
                    }
                    
                    
                }
            }
            System.out.println("Planta no encontrada, ingrese un nombre valido");
            System.out.println();
        }while("0".equals(nombreIngresado));
    }
    
    public boolean validarFechaSembrado(String date){
        Date myDate = new Date();
        String fechaActual = new SimpleDateFormat("dd-MM-yyyy").format(myDate); 
        String diaActual, mesActual, anioActual;
        diaActual = fechaActual.substring(0, 2);
        mesActual = fechaActual.substring(3, 5);
        anioActual = fechaActual.substring(6, 10);
        
        String dia, mes, anio, sep1, sep2;
        dia = date.substring(0, 2);
        sep1 = date.substring(2,3);
        mes = date.substring(3,5);
        sep2 = date.substring(5,6);
        anio = date.substring(6, 10);
        if(sep1.equals("/") || (sep2.equals("/"))){
            return false;
        }
        if((Integer.parseInt(mes)<= 12 && Integer.parseInt(mes)>=1)){
            if( Integer.parseInt(anio)<= Integer.parseInt(anioActual)){
            return true;
            }
        }
        return false;
        
    }
    
    
}

    
