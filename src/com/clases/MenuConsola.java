/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Francisco
 */
public class MenuConsola {
    private Usuario usuarioSesion;
    private ManejoArchivos ma = new ManejoArchivos();
        
    public void menu(String us){
        Scanner sc = new Scanner(System.in);
        String opcion;
        
        //cargar datos
        cargarDatos(us);
        
        do{
            System.out.println("Ingrese 1)Para agregar plantas");
            System.out.println("Ingrese 2)Para mostrar plantas");
            System.out.println("Ingrese 3)Para buscar una planta");
            System.out.println("Ingrese 4)Para modificar datos de alguna planta");
            System.out.println("Ingrese 5)Para eliminar alguna planta\n");
            
            System.out.println("Ingrese 0)Para finalizar el programa\n");
            
            System.out.println("Ingrese una de las opciones");
            opcion = sc.nextLine();
            
            switch(opcion){
                case "1":
                    //agregarPlantas
                    PlantaExterior pe = new PlantaExterior("Plantita","22/02/2002",
                            3,"arido","verano");
                    usuarioSesion.getPlantasUsuario().add(pe);
                    PlantaInterior pi = new PlantaInterior("Plantoide","22/02/2003",
                            10,"poca",30);
                    usuarioSesion.getPlantasUsuario().add(pi);
                    break;
                    
                case "2":
                    //mostrar plantas
                    System.out.println();
                    for(int i=0; i< usuarioSesion.getPlantasUsuario().size(); i++){
                        usuarioSesion.getPlantasUsuario().get(i).mostrarDatos();
                        System.out.println();
                    }
                    System.out.println();
                    break;
                    
                case "3":
                    //buscar planta
                    usuarioSesion.setCantPlantasSembradas(2);
                    break;
                    
                case "4":
                    //modificar planta
                    
                    break;
                    
                case "5":
                    //eliminar planta
                    break;
                    
                default:
                    break;
                
            }
            
            
            
        }while(!(opcion.equals("0")));
        ma.guardarDatos("bd\\"+ usuarioSesion.getUsuario() +"bd.txt", "bd\\"+ usuarioSesion.getUsuario()
                +"PlantasBD.csv", usuarioSesion);
    }
    
    private void cargarDatos(String usu){
        String [] nombreUsuario = new String[2];
        String [] datosUsuario = new String[4];
        if(!(ma.validarArchivo( usu+"bd.txt"))){
            //usuarioSesion();
            nombreUsuario = agregarNombreUsuario();
            ma.crearDatosUsuario("bd\\"+ usu+"bd.txt", usu, nombreUsuario[0], nombreUsuario[1]); 
            ma.crearPlantasCSVUsuario("bd\\"+ usu+"PlantasBD.csv");
        }
        datosUsuario = ma.cargarDatosUsuario("bd\\"+ usu+"bd.txt");
        ArrayList<Planta> plantas = ma.cargarPlantasUsuario("bd\\"+ usu+"PlantasBD.csv");
        usuarioSesion = new Usuario(datosUsuario[0],datosUsuario[1],datosUsuario[2], Integer.parseInt(datosUsuario[3]), plantas);
    }
    
    private String[] agregarNombreUsuario(){
        Scanner Entrada = new Scanner(System.in);
        String[] nuevoUsuario = new String[2];
        
        //Leer datos Usuario
        System.out.println("Ingrese su Nombre: ");
        nuevoUsuario[0] = Entrada.nextLine();

        System.out.println("Ingrese su Apellido: ");
        nuevoUsuario[1] = Entrada.nextLine();
        
        return nuevoUsuario;
    }
    
    
}
