package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LeerFicheroWeather {

    // Lee el contenido del fichero
    static void muestraContenido(String archivo) throws FileNotFoundException, IOException {

        String cadena = null;
        String dy = null;
        Double max = null;
        Double min = null;

        // Declaración del ArrayList de tipo Registro
        ArrayList<Registro> wather = new ArrayList<Registro>();

        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        while ((cadena = br.readLine()) != null){

            cadena = cadena.replace("*", " "); // Elimino los caracteres extranyos

            // Codigo susceptible a fallar
            try{

                dy  = cadena.substring(0, Coodenadas.DAYNUMBER);
                max = Double.parseDouble(cadena.substring(Coodenadas.DAYNUMBER, Coodenadas.MAXTEMP));
                min = Double.parseDouble(cadena.substring(Coodenadas.MAXTEMP, Coodenadas.MINTEMP));

                System.out.println(dy + " - " + max + " - " + min + " - " + (max - min));

                // Objeto de tipo Registro
                Registro miRegistro = new Registro();

                // Le asigno los valores
                miRegistro.setDay(dy);
                miRegistro.setMaxTemp(max);
                miRegistro.setMinTemp(min);
                miRegistro.setDifTemp(max - min);

                // Anyado el nuevo registro
                wather.add(miRegistro);
            }
            catch(Exception StringIndexOutOfBoundsException) {

                //dy  = "Registro ignorado";
                //max = 0.0;
                //min = 0.0;
                //StringIndexOutOfBoundsException.printStackTrace();
                System.out.println("Registro ignorado --> " + cadena);
            }
        }
        br.close();
        //System.out.println("Fin del bulce");

        // Mostrar el registro con la diferencia de temperatura menor
        Double minimaDiferencia = -1.0;
        int indiceRegistro = 0;

        //System.out.println("wather.size():" + wather.size());
        for (int i = 0; i < wather.size(); i++){

            if ( (wather.get(i).getDifTemp() < minimaDiferencia) || minimaDiferencia ==-1.0) {
                indiceRegistro = i;
                minimaDiferencia = wather.get(i).getDifTemp();
            };
        }

        JOptionPane.showMessageDialog(null, "El día con la menor diferencia de temperatura máxima y minima es:" +
                                                                    "\nDía: " + wather.get(indiceRegistro).getDay() +
                                                                    "\nMáxima Temperatura: " + wather.get(indiceRegistro).getMaxTemp() +
                                                                    "\nMinima Temperatura: " + wather.get(indiceRegistro).getMinTemp() +
                                                                    "\nDiferencia: " + wather.get(indiceRegistro).getDifTemp());

    }
}
