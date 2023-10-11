package net.salesianos.contador;

public class ContadorVocales { public static void main(String[] args) {
    String texto = args[1];
    char vocal = args[0].charAt(0);

    int contadorVocal= 0;
    for (int i = 0; i <texto.length() ; i++) {
         if(texto.toUpperCase().charAt(i)==vocal){
             contadorVocal++;
         }
    }
    System.out.println(contadorVocal);
}
}
