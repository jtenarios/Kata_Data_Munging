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
                max = Double.parseDouble(cadena.substring(Coodenadas.DAYNUMBER, Coodenadas.MAXTEMP));
                min = Double.parseDouble(cadena.substring(Coodenadas.MAXTEMP, Coodenadas.MINTEMP));
            }
            catch(Exception StringIndexOutOfBoundsException){

                dy  = "Registro ignorado";
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

        // Mostrar el registro con la diferencia de temperatura menor
        Double minimaDiferencia = 99.0;
        int indiceRegistro = 0;


        for (int i = 0; i < wather.size(); i++){
            miRegistro = wather.get(i);
            if (miRegistro.getDifTemp() < minimaDiferencia && miRegistro.getDay() != "Registro ignorado") {
                indiceRegistro = i;
                minimaDiferencia = miRegistro.getDifTemp();
                System.out.println("dia registrado");
            };
        }

        System.out.println("El día con la menor diferencia de temperatura máxima y minima es el registro --> " + indiceRegistro);
        System.out.println("Día: " + wather.get(indiceRegistro).getDay());
        System.out.println("Máxima Temperatura: " + wather.get(indiceRegistro).getMaxTemp());
        System.out.println("Minima Temperatura: " + wather.get(indiceRegistro).getMinTemp());
        System.out.println("Diferencia: " + wather.get(indiceRegistro).getDifTemp());

    }

    public static void main(String[] args) throws IOException{
        muestraContenido("C:\\Users\\jtena\\Downloads\\weather.dat");
    }
}
