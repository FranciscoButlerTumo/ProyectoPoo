/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appplantas;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Francisco
 */
public class PaginaPrincipal {
    private int cantPlantasCiudad;
    private int cantPlantasPais;
    private int cantPlantasGlobal;
    private ArrayList<Usuario> ListaUsuarios= new ArrayList();

    //Constructor
    public PaginaPrincipal(int cantSembradasIngresadas, int cantPlantasCiudadIngresada, int cantPlantasPaisIngresada,
    int cantPlantasGlobalIngresada){
        this.cantPlantasCiudad = cantPlantasPaisIngresada;
        this.cantPlantasPais = cantPlantasPaisIngresada;
        this.cantPlantasGlobal = cantPlantasGlobalIngresada;
    }
    public PaginaPrincipal(){
        this.cantPlantasCiudad = 0;
        this.cantPlantasPais = 0;
        this.cantPlantasGlobal = 0;
    }
    
    //Accesores y mutadores(Getters y Setters)
    public int getCantPlantasCiudad(){
        return this.cantPlantasCiudad;
    }

    public int getCantPlantasPais(){
        return this.cantPlantasPais;
    }

    public int getCantPlantasGlobal(){
        return this.cantPlantasGlobal;
    }
    
    public ArrayList<Usuario> getListaUsuarios() {
        return ListaUsuarios;
    }
    

    public void setCantPlantasCiudad(int cantPlantasCiudadIngresada){
        this.cantPlantasCiudad = cantPlantasCiudadIngresada;
    }

    public void getCantPlantasPais(int cantPlantasPaisIngresada){
        this.cantPlantasPais = cantPlantasPaisIngresada;
    }

    public void getCantPlantasGlobal(int cantPlantasGlobalIngresada){
        this.cantPlantasGlobal = cantPlantasGlobalIngresada;
    }
    
    
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios){
        this.ListaUsuarios = listaUsuarios;
    }
    
    public void agregarUsuario(){
        Scanner Entrada = new Scanner(System.in);
        String auxNombre, auxApellido, auxAlias, auxCorreo, auxPais, auxCiudad, auxDireccion;
        int numAux = 0;
        Usuario nuevoUsuario = new Usuario();
        
        //Leer datos Usuario
        System.out.println("Ingrese su Nombre: ");
        auxNombre = Entrada.nextLine();

        System.out.println("Ingrese su Apellido: ");
        auxApellido = Entrada.nextLine();

        System.out.println("Ingrese su Alias: ");
        auxAlias = Entrada.next();
        
        while (buscarUsuario(auxAlias) != null){
            System.out.println("Este Alias ya se encuentra ingresado. Por favor, intente uno nuevo");
            auxAlias = Entrada.next();
        }
        
        
        System.out.println("Ingrese su Correo: ");
        auxCorreo = Entrada.nextLine();

        System.out.println("Ingrese su Numero de Celular: ");
        numAux = Entrada.nextInt();
        while (contarNumero(numAux) != 9){
            System.out.println("Numero ingresado es incorrecto. Por favor, intente nuevamente");
            numAux = Entrada.nextInt();
        }

        
        System.out.println("Ingrese su cantidad de plantas: ");
        numAux = Entrada.nextInt();
        nuevoUsuario.setCantPlantasSembradas(numAux);
        
        System.out.println("Ingrese su pais: ");
        auxPais = Entrada.nextLine();

        System.out.println("Ingrese su ciudad: ");
        auxCiudad = Entrada.nextLine();

        System.out.println("Ingrese su direccion: ");
        auxDireccion = Entrada.nextLine();
        
        nuevoUsuario.setNombre(auxNombre);
        nuevoUsuario.setApellido (auxApellido);
        nuevoUsuario.setAlias(auxAlias);   
        nuevoUsuario.setCorreoElectronico (auxCorreo);
        nuevoUsuario.setNumeroCelular (numAux);
        nuevoUsuario.setPais(auxPais);
        nuevoUsuario.setCiudad (auxCiudad);
        nuevoUsuario.setDireccion (auxDireccion);
        
        crearArchivo(nuevoUsuario);
        
        ListaUsuarios.add(nuevoUsuario);
    }
        
    
    public Usuario buscarUsuario (String nombreUsuario){
        for (int i = 0; i < ListaUsuarios.size(); i++){
            
            if (nombreUsuario.equals(ListaUsuarios.get(i).getNombre()))
                return ListaUsuarios.get(i);
        }
        return null;    
    }
        
    public int contarNumero (int numero){
        int cont = 0;
        while ( numero != 0){
            numero /= 10;
            cont++;
        }
        return cont;
    }
    
    private int sumar(){
        int sumaGlobal=0;
        for(int i=0;i<this.ListaUsuarios.size();i++){
            sumaGlobal+=this.ListaUsuarios.get(i).contarPlantas();
        }
        
        return sumaGlobal;
    }
    private void crearArchivo(Usuario us){
        try{
            File archivo = new File("datosGuardados.txt");
            if(archivo.createNewFile()){
                cargarArchivo(us);
                System.out.println("Se ha creado un archivo con los datos del programa");
            }
            else{
                System.out.println("El archivo con los datos del programa ya existia");
            }
        } catch(IOException e){
            System.out.println("Ocurrio un error al crear el archivo con los datos del programa");
        }
        
    
    }
    private void cargarArchivo(Usuario us){
        try{
            FileWriter fw = new FileWriter("datosGuardados.txt");
            fw.write(us.getAlias());
            fw.write(",");
            fw.write(us.getNombre());
            fw.write(",");
            fw.write(us.getApellido());
            fw.write(",");
            fw.write(us.getCorreoElectronico());
            fw.write(",");
            fw.write(us.getNumeroCelular());
            fw.write(",");
            fw.write(us.getCantPlantasSembradas());
            fw.write(",");
            fw.write(us.getPais());
            fw.write(",");
            fw.write(us.getCiudad());
            fw.write(",");
            fw.write(us.getDireccion());
            fw.write("\n");
            fw.close();
             
        } catch(IOException e){
            System.out.println("Ocurrio un error al agregar los datos");
        }
    }
    
}
