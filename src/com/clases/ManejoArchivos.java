/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases;

import com.vistas.InicioSesion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Francisco
 */
public class ManejoArchivos {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY"); 
    private Scanner sc;
    
    //funcion que valida si existe el archivo y si no lo crea
    //retorna true si existia o retorna false en caso contrario
    public void crearArchivoUsuarios(String nombreArchivo){
        File archivo = new File("bd\\"+nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            
        } catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    public boolean validarArchivo(String ubicacionArchivo){
        File archivo  = new File("bd\\" + ubicacionArchivo);
        return archivo.exists();
    }
    
    //pruebas
    public int contarLineasArchivos(String ubicacionArchivo){
        FileReader fr = null;
        int nLineas = 0;
        try {
            
            String linea;
            sc = new Scanner(ubicacionArchivo);
            File f = new File(ubicacionArchivo);
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                while((linea=br.readLine())!= null){
                    nLineas++;
                }
            } catch (IOException ex) {
                Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
                return nLineas;
            } catch (IOException ex) {
                Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
                return 0;
            }
        }
    }
    
    public void crearUsuario(String usuario, String contrasena){
        File archivo = new File("bd\\usuarios.txt");
        try {
            FileWriter arch = new FileWriter(archivo,true);
            PrintWriter salida = new PrintWriter(arch);
            salida.println(usuario);
            salida.println(contrasena);
            salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public void crearDatosUsuario(String ubicacionArchivo, String usuario, String nombre, String apellido){
        File archivo = new File(ubicacionArchivo);
        try {
            FileWriter arch = new FileWriter(archivo,true);
            PrintWriter salida = new PrintWriter(arch);
            
            salida.println(usuario);
            salida.println(nombre);
            salida.println(apellido);
            salida.println("0");
           
            salida.close();
            
        } catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearPlantasCSVUsuario(String ubicacionArchivo){
        try {
            File f = new File(ubicacionArchivo);
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public String[] cargarDatosUsuario(String ubicacionArchivo){
        String [] buffer = new String[4];
        try {
            sc = new Scanner(new File(ubicacionArchivo));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
            return buffer;
        }
            
            for(int i = 0; i<4; i++){
                buffer[i] = sc.nextLine();
            }
        return buffer;
    }
    
    public ArrayList<Planta> cargarPlantasUsuario(String ubicacionArchivo){
        ArrayList<Planta> plantas = new ArrayList<Planta>();
        String line;
        File f = new File(ubicacionArchivo);
        try {
            
            BufferedReader reader = new BufferedReader(new FileReader(f));
            while((line = reader.readLine())!=null){
                String[] parts = line.split(";");
                if(parts[0].equals("E")){
                    //planta exterior
                    plantas.add(new PlantaExterior(parts[1], parts[2], 
                            Integer.parseInt(parts[3]), parts[4], parts[5]));
                }
                else{
                    plantas.add(new PlantaInterior(parts[1], parts[2],
                            Integer.parseInt(parts[3]), parts[4], 
                            Integer.parseInt(parts[5])));
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plantas;
    }
    
    public void guardarDatos(String ubicacionArchivoUsuario, String ubicacionArchivoPlantas, Usuario usuarioSesion){
        File archivo = new File(ubicacionArchivoUsuario);
        
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.println(usuarioSesion.getUsuario());
            salida.println(usuarioSesion.getNombre());
            salida.println(usuarioSesion.getApellido());
            salida.println(usuarioSesion.getCantPlantasSembradas());
            salida.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileWriter fw = new FileWriter(ubicacionArchivoPlantas, false);
            for(int i=0;i<usuarioSesion.getPlantasUsuario().size();i++){
                Planta plant = usuarioSesion.getPlantasUsuario().get(i);
                if(i>0){
                    fw.write("\n");
                }
                if(plant instanceof PlantaExterior){
                    fw.write("E"+
                            ";"+plant.getNombre()+
                            ";"+plant.getFechaSembrado()+
                            ";"+plant.getCantVecesRiego()+
                            ";"+((PlantaExterior) plant).getTipoClima()+
                            ";"+((PlantaExterior) plant).getTemporada());                            
                }
                else{
                    fw.write("I"+
                            ";"+plant.getNombre()+
                            ";"+plant.getFechaSembrado()+
                            ";"+plant.getCantVecesRiego()+
                            ";"+((PlantaInterior) plant).getCantidadLuz()+
                            ";"+((PlantaInterior) plant).getTemperaturaCelcius());
                }
                
            
            }
            fw.close();
           
        } catch (IOException ex) {
            Logger.getLogger(ManejoArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   
}   
