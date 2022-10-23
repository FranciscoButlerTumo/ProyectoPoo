/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.appplantas;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Francisco
 */
public class AppPlantas {

    public static void main(String[] args) {
        Scanner Entrada = new Scanner (System.in);
        int auxInt;
        String auxString;
        Date auxFecha;
        Usuario user;
        ArrayList<Planta> plantasUser;

        System.out.println("¿Es usted un nuevo usuario? Ingrese 'Si' o 'No'" );
        
        //agregar datos
        PaginaPrincipal objeto = new PaginaPrincipal();
        objeto.agregarUsuario();
                
        System.out.println("Ingrese el nombre del usario:");
        auxString = Entrada.nextLine();
        user = objeto.buscarUsuario(auxString);
        
        plantasUser = user.getPlantasUsuario();
            
        System.out.println("Ingrese 1)Para agregar plantas");
        System.out.println("Ingrese 2)Para mostrar Usuario y sus Plantas");
        auxInt = Entrada.nextInt();
        
        switch(auxInt){
            case 1: //si
                
                user.agregarPlantas();
                
            case 2: //no
                System.out.println("Ingrese 1)Para mostrar Usuario");
                System.out.println("Ingrese 2)Para mostrar sus Plantas");
                auxInt = Entrada.nextInt();
                
                if(auxInt == 1){
                    user.mostrarDatos();
                }
                if(auxInt == 2){
                    for(int i = 0; i < plantasUser.size(); i++){
                        auxString = plantasUser.get(i).getNombre();
                        auxFecha = plantasUser.get(i).getFechaSembrado();
                        auxInt = plantasUser.get(i).getCantVecesRiego();
                        plantasUser.get(i).mostrarDatos(auxString, auxFecha, auxInt);
                    }
                }
            default:
                System.out.println("Ingrese una opcion Valida");
              
        }
        
               

        
    
    }
}
