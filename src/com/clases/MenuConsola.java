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
    private ArrayList<Usuario> usuarios;
    private ManejoArchivos ma = new ManejoArchivos();
        
    public void menu(String us){
        Scanner sc = new Scanner(System.in);
        String opcion;
        
        //cargar datos
        cargarDatos(us);
        
        do{
            System.out.println();
            System.out.println("Ingrese 1)Para agregar plantas");
            System.out.println("Ingrese 2)Para mostrar plantas");
            System.out.println("Ingrese 3)Para buscar una planta");
            System.out.println("Ingrese 4)Para buscar las planta menos regadas");
            System.out.println("Ingrese 5)Para la planta mas regadas entre los usuarios");
            System.out.println("Ingrese 6)Para modificar datos de alguna planta");
            System.out.println("Ingrese 7)Para eliminar alguna planta\n");
            
            System.out.println("Ingrese 0)Para finalizar el programa\n");
            
            System.out.println("Ingrese una de las opciones");
            opcion = sc.nextLine();
            System.out.println();
            System.out.println("===============================================================================================");
            System.out.println();
            switch(opcion){
                case "1":
                    //agregarPlantas
                    System.out.println();
                    usuarioSesion.agregarPlantas();
                    System.out.println("\n");
                    break;
                    
                case "2":
                    //mostrar plantas
                    System.out.println();
                    usuarioSesion.mostrarDatosPlantas();
                    System.out.println("\n");
                    
                    break;
                    
                case "3":
                    //buscar planta
                    System.out.println();
                    usuarioSesion.buscarPlanta();
                    System.out.println("\n");
                    break;
                    
                case "4":
                    //buscar planta mas regada
                    System.out.println();
                    usuarioSesion.buscarPlantaMenosRegada();
                    System.out.println("\n");
                    break;
                    
                case "5":
                    //mostrar planta mas regada entre los usuarios
                    System.out.println();
                    usuariosPlantaMasRegada();
                    System.out.println("\n");
                    break;
                    
                case "6":
                    //modificar planta
                    System.out.println();
                    usuarioSesion.modificarPlanta();
                    System.out.println("\n");
                    
                    break;
                    
                case "7":
                    //eliminar planta
                    System.out.println();
                    usuarioSesion.eliminarPlanta();
                    System.out.println("\n");
                    break;
                    
                default:
                    break;
                
            }
            System.out.println("===============================================================================================");
            ma.guardarDatos("bd\\"+ usuarioSesion.getUsuario() +"bd.txt", "bd\\"+ usuarioSesion.getUsuario()
                +"PlantasBD.csv", usuarioSesion);
            
            
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
        ma.guardarDatos("bd\\"+ usuarioSesion.getUsuario() +"bd.txt", "bd\\"+ usuarioSesion.getUsuario()
                +"PlantasBD.csv", usuarioSesion);
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
    
    private void usuariosPlantaMasRegada(){
        usuarios = ma.cargarTodosUsuarios("bd\\usuarios.txt");
        //encontrar cantidad planta menos regada
        int cantPlantaMasRegada = -1;
        for(int i=0;i<usuarios.size();i++){
            ArrayList<Planta> plantasUsuario = usuarios.get(i).getPlantasUsuario();
            for(int j=0; j<usuarios.get(i).getCantPlantasSembradas();j++){
                if(cantPlantaMasRegada < plantasUsuario.get(j).getCantVecesRiego()){
                    cantPlantaMasRegada = plantasUsuario.get(j).getCantVecesRiego();
                }
            }
        }
        
        //buscar usuarios que tengan plantas con la cantidad encontrada anteriormente
        ArrayList<Usuario> usuariosPlantasMasRegada = new ArrayList<Usuario>();
        for(int i=0;i<usuarios.size();i++){
            int tienePlantasMasRegadas = 0;
            ArrayList<Planta> plantasUsuario = usuarios.get(i).getPlantasUsuario();
            ArrayList<Planta> plantasMasRegadasUsuario = new ArrayList<Planta>(); 
            for(int j=0;j<usuarios.get(i).getCantPlantasSembradas();j++){
                if(cantPlantaMasRegada == plantasUsuario.get(j).getCantVecesRiego()){
                  plantasMasRegadasUsuario.add(plantasUsuario.get(j));
                  tienePlantasMasRegadas = 1;
                }
            }
            if(tienePlantasMasRegadas == 1){
                Usuario usuarioPlantasMasRegadas = new Usuario(
                        usuarios.get(i).getUsuario(),
                        usuarios.get(i).getNombre(),
                        usuarios.get(i).getApellido(),
                        usuarios.get(i).getCantPlantasSembradas(),
                        plantasMasRegadasUsuario
                        );
                usuariosPlantasMasRegada.add(usuarioPlantasMasRegadas);
            }
        }
        
        //mostrar datos2
        for(int i=0;i<usuariosPlantasMasRegada.size();i++){
            System.out.println("El usuario '"+usuariosPlantasMasRegada.get(i).getUsuario()+"' rego "+cantPlantaMasRegada+ " veces a sus plantas:");
            System.out.println();
            for(int j=0; j<usuariosPlantasMasRegada.get(i).getPlantasUsuario().size();j++){
                usuariosPlantasMasRegada.get(i).getPlantasUsuario().get(j).mostrarDatos();
                System.out.println();
            }
        }
    }
    
    
    
    
}
