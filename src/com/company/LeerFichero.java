package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeerFichero {

    // Lee el contenido del fichero
    static void muestraContenido(String archivo) throws FileNotFoundException, IOException {

        String cadena = "0"; //Inicializo a "0" para que entre la primera vez en el buclo While
        String dy = null;
        Double max = null;
        Double min = null;

        // Objeto de tipo Registro
        Registro miRegistro = new Registro();

        // Declaración del ArrayList de tipo Registro
        ArrayList<Registro> wather = new ArrayList<Registro>();


        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        while (cadena != null){
            cadena = br.readLine();
            //cadena = cadena.replace(" ", ""); // Elimino los espacios


            // Codigo susceptible a falla por StringIndexOutOfBoundsException
            // ya que hay líneas sin datos
            try{
                dy  = cadena.substring(0, Coodenadas.DAYNUMBER);
                System.out.println("A----->" + cadena.substring(Coodenadas.DAYNUMBER, Coodenadas.MAXTEMP));
                System.out.println("B----->" + cadena.substring(Coodenadas.MAXTEMP, Coodenadas.MINTEMP));
                max = Double.parseDouble(cadena.substring(Coodenadas.DAYNUMBER, Coodenadas.MAXTEMP));
                min = Double.parseDouble(cadena.substring(Coodenadas.MAXTEMP, Coodenadas.MINTEMP));
            }
            catch(Exception StringIndexOutOfBoundsException){
                dy  = null;
                max = 0.0;
                min = 0.0;
            }
            finally{
                //System.out.println(cadena);
                System.out.println(dy + " - " + max + " - " + min + " - " + (max - min));
                System.out.println("-------------------------");

                // Le asigno los valores
                miRegistro.setDay(dy);
                miRegistro.setMaxTemp(max);
                miRegistro.setMinTemp(min);
                miRegistro.setDifTemp(max - min);

                // Anyado el nuevo registro
                wather.add(miRegistro);

            }

        }
        br.close();
    }

    public static void main(String[] args) throws IOException{
        muestraContenido("C:\\Users\\jtena\\Downloads\\weather.dat");
    }
}
