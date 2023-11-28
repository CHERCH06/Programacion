package quicksort;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* @author VGSG */

public class Quicksort {
    public static void main(String[] args) {
        String rutaTxt = "C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\Quicksort\\h.txt";
        String rutaSalida = "C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\LeerArchivoPJava\\Quicksort\\src\\quicksort\\resultado.txt";
        //Se uso BigInteger por que el int no tenias el rango para el valor numero que se generaba de la vonverison de hexa a decimal base 10
        try {
            List<BigInteger> listaDecimal = hexADecimal(abrirTxt(rutaTxt));
            List<BigInteger> listaOrdenada = quicksort(listaDecimal);
            generaArchivo(listaOrdenada, rutaSalida);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static List<BigInteger> quicksort(List<BigInteger> arr) {
        if (arr.size() <= 1) {
            return arr;
        } else {
            BigInteger pivot = arr.get(0);
            List<BigInteger> menor = new ArrayList<>();
            List<BigInteger> mayor = new ArrayList<>();

            for (BigInteger n : arr.subList(1, arr.size())) {
                int comparacion = n.compareTo(pivot);
                if (comparacion<=0) {
                    menor.add(n);
                } else {
                    mayor.add(n);
                }
            }

            List<BigInteger> resultado = new ArrayList<>();
            resultado.addAll(quicksort(menor));
            resultado.add(pivot);
            resultado.addAll(quicksort(mayor));
            return resultado;
        }
    }

    private static List<BigInteger> hexADecimal(List<String> array) {
        List<BigInteger> arrayDecimal = new ArrayList<>();
        for (String linea : array) {
            try{
                BigInteger valorDecimal = new BigInteger(linea,16);
                arrayDecimal.add(valorDecimal);
            }catch(NumberFormatException e){
                System.err.println(e.getMessage()+" integer");
            }  
        }
        return arrayDecimal;
    }

    private static List<String> abrirTxt(String ruta) throws IOException{
        Path path = Paths.get(ruta);
        List<String> lineas = Files.readAllLines(path);

        StringBuilder textoCompleto = new StringBuilder();
        for (String linea : lineas) {
            textoCompleto.append(linea);
        }

        List<String> listaAux = new ArrayList<>();
        int aux = 0;
        while (aux < textoCompleto.length()) {
            if (aux + 8 <= textoCompleto.length()) {
                listaAux.add(textoCompleto.substring(aux, aux + 8));
            }
            aux += 8;
        }
        return listaAux;
    }

    private static void generaArchivo(List<BigInteger> array, String ruta) throws IOException {
        Path path = Paths.get(ruta);
        Files.deleteIfExists(path);
        Files.createFile(path);

        StringBuilder contenido = new StringBuilder();
        for (BigInteger valor : array) {
            contenido.append(valor).append(",");
        }

        Files.write(path, contenido.toString().getBytes());
    }
}
