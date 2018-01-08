package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichero {

    // Lee el contenido del fichero
    static void muestraContenido(String archivo) throws FileNotFoundException, IOException {

        String cadena = "0"; //Inicializo a "0" para que entre la primera vez en el buclo While

        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        while (cadena != null){
            cadena = br.readLine();
            System.out.println(cadena);
        }
        br.close();
    }

    public static void main(String[] args) throws IOException{
        muestraContenido("C:\\Users\\jtena\\Downloads\\weather.dat");
    }
}
