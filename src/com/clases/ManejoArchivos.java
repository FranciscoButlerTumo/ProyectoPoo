/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clases;

import com.vistas.InicioSesion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Francisco
 */
public class ManejoArchivos {
    private Scanner sc;
    
    //funcion que valida si existe el archivo y si no lo crea
    //retorna true si existia o retorna false en caso contrario
    public void crearArchivo(String nombreArchivo){
        File archivo = new File("bd\\"+nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(archivo);
            salida.close();
            
        } catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
        }
    }
    
    public void validarArchivo(String ubicacionArchivo){
        File archivo  = new File("bd\\" + ubicacionArchivo);
        if(!archivo.exists()){
            crearArchivo(ubicacionArchivo);
        }
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
}
