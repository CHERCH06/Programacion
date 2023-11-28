package heapsort;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/* @author VGSG */
public class HeapSort {

    public static void main(String[] args) {
        String rutaTxt = "C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\PhytonProjects\\HeapSort\\h.txt";
        String rutaSalida = "C:\\Users\\sergi\\OneDrive\\Documentos\\GitHub\\Programacion\\LeerArchivoPJava\\HeapSort\\src\\heapsort\\resultado.txt";
        //Se uso BigInteger por que el int no tenias el rango para el valor numero que se generaba de la vonverison de hexa a decimal base 10
        try {
            List<BigInteger> listaDecimal = hexADecimal(abrirTxt(rutaTxt));
            List<BigInteger> listaOrdenada = heapSort(listaDecimal);
            generaArchivo(listaOrdenada, rutaSalida);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public static List<BigInteger> heapSort(List<BigInteger> arr) {
        PriorityQueue<BigInteger> minHeap = new PriorityQueue<>();
        
        // Construir el heap
        for (BigInteger num : arr) {
            minHeap.offer(num);
        }
        
        // Extraer elementos ordenados del heap
        List<BigInteger> sortedArr = new ArrayList<>();
        int i = 0;
        while (!minHeap.isEmpty()) {
            sortedArr.add(minHeap.poll());
        }
        
        return sortedArr;
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
