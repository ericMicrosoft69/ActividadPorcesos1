import net.salesianos.procesos.ProcessLauncher;
import net.salesianos.utils.Utils;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {


        ArrayList<Process> arrayDeProcesos = new ArrayList<>();
        String[] vocales = {"A", "E", "I", "O", "U"};

        String fichero = "C:\\Users\\eric\\IdeaProjects\\ActividadProcesos\\src\\net\\lorem_ipsum.txt";
        Utils.LectorDeFicheros(fichero);


        for (int i = 0; i < vocales.length; i++) {
            String nombreArchivo = "output: " + vocales[i];
            Process javaProces = ProcessLauncher.initWordCounterProcess(vocales[i], nombreArchivo);

            arrayDeProcesos.add(javaProces);

        }

        for (Process process : arrayDeProcesos) {
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalVocales = 0;
        for (Process process : arrayDeProcesos) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String output = reader.readLine();
                int contadorVocal = Integer.parseInt(output);
                totalVocales = contadorVocal;

                System.out.println("Vocal " + vocales[arrayDeProcesos.indexOf(process)] + ", Cantidad: " + contadorVocal);

                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Número total de vocales: " + totalVocales );
    }
}