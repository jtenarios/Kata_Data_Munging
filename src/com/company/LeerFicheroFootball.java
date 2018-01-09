package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerFicheroFootball {
    // Lee el contenido del fichero
    static void muestraContenido(String archivo) throws FileNotFoundException, IOException {

        String cadena = null;
        String team = null;
        int favor = 0;
        int contra = 0;

        // Declaración del ArrayList de tipo Registro
        ArrayList<RegistroFotball> tablaEquipos = new ArrayList<RegistroFotball>();

        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        while ((cadena = br.readLine()) != null){

            // Codigo susceptible a fallar
            try{

                team  = cadena.substring(7, 23);
                favor = Integer.parseInt(cadena.substring(43, 45));
                contra = Integer.parseInt(cadena.substring(50, 52));

                System.out.println(team + " - " + favor + " - " + contra + " - " + (favor - contra));


                // Objeto de tipo Registro
                RegistroFotball miEquipo = new RegistroFotball();

                // Le asigno los valores
                miEquipo.setTeam(team);
                miEquipo.setFavor(favor);
                miEquipo.setContra(contra);
                miEquipo.setDiferencia(favor - contra);

                // Anyado el nuevo registro
                tablaEquipos.add(miEquipo);
            }
            catch(Exception StringIndexOutOfBoundsException) {
                System.out.println("Registro ignorado --> " + cadena);
            }
        }
        br.close();
        //System.out.println("Fin del bulce");

        // Mostrar el registro con la diferencia de temperatura menor
        int minimaDiferencia = -1000;
        int indiceRegistro = 0;

        //System.out.println("wather.size():" + wather.size());
        for (int i = 0; i < tablaEquipos.size(); i++){

            if ( (tablaEquipos.get(i).getDiferencia() < minimaDiferencia) || minimaDiferencia ==-100) {
                indiceRegistro = i;
                minimaDiferencia = tablaEquipos.get(i).getDiferencia();
            };
        }

        JOptionPane.showMessageDialog(null, "El equipo con menos diferencia entre los goleas a favor y en contra es:" +
                "\nEquipo: " + tablaEquipos.get(indiceRegistro).getTeam() +
                "\nGoles a favor: " + tablaEquipos.get(indiceRegistro).getFavor() +
                "\nGoles en contra: " + tablaEquipos.get(indiceRegistro).getContra() +
                "\nDiferencia: " + tablaEquipos.get(indiceRegistro).getDiferencia());

    }
}
