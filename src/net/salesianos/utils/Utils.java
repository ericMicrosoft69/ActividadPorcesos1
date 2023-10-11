package net.salesianos.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utils {

public static String LectorDeFicheros(String fileRoute ) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRoute));
    String texto = "";
    String linea = bufferedReader.readLine();
    while (linea != null ){

        linea = bufferedReader.readLine();
        texto += linea;
    }
    bufferedReader.close();

    return texto;
}


    };
