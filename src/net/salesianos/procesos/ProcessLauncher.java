package net.salesianos.procesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessLauncher  {
    private final static String OUTPUT_ROUTE = "C:\\Users\\eric\\IdeaProjects\\ActividadProcesos\\src\\net\\salesianos\\output";

    public static Process initWordCounterProcess(String vocal, String texto) {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "java", "C:\\Users\\eric\\IdeaProjects\\ActividadProcesos\\src\\net\\salesianos\\contador\\ContadorVocales.java", vocal, texto
        );
        Process javaProces = null;
        String output = null;
        try {
            File outputFile = new File(OUTPUT_ROUTE);
            processBuilder.redirectOutput(outputFile);
            javaProces = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(javaProces.getInputStream()));
            output = reader.readLine();
            reader.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return javaProces;
    }
}
