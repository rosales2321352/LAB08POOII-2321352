import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        //Banco de caracteres
        String banco = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789 ";

        //Crear cadenas de manera aleatoria.
        List<String> cadenasAleatorias = Stream.generate(() -> {
                    int longitud = numeroAleatorioEnRango(1, 10);
                    return Stream.generate(() -> {
                                int index = numeroAleatorioEnRango(0, banco.length() - 1);
                                return banco.charAt(index);
                            })
                            .limit(longitud)
                            .map(Object::toString)
                            .collect(Collectors.joining());
                }).limit(10)
                .map(Object::toString)
                .toList();

        //Contar cuántas cadenas vacías tiene la lista de cadenas.
        List<String> cadenasAleatorias_ = Arrays.asList(" ","   ","CIB3 bm", "tYAi xHN", "ñjn qaF", "7PñÑnYUTf", "YnATo8c");
        int cadenasVacias = (int) cadenasAleatorias_.stream()
                .filter(x -> x.isBlank())
                .count();

        System.out.println(cadenasVacias);

        //Contabilizar cuántas cadenas tienen longitud superior a 5.
        int cadenasMayoresA5 = (int) cadenasAleatorias.stream()
                .filter(x -> x.length() > 5)
                .count();

        System.out.println(cadenasMayoresA5);

        //Contabilizar cuántas cadenas comienzan con "s".
        List<String> cadenasAleatorias__ = Arrays.asList("S","s46das","sCIB3 bm", "tYAi xHN", "ñjn qaF", "7PñÑnYUTf", "SYnATo8c");
        int cadenasComienzanConS = (int) cadenasAleatorias__.stream()
                .filter(x -> x.startsWith("s"))
                .count();

        System.out.println(cadenasComienzanConS);


        List<String> cadenasAleatorias___ = Arrays.asList(" ","   ","CIB3 bm", "tYAi xHN", "ñjn qaF", "7PñÑnYUTf", "YnATo8c");
        String eliminandoVacios  = cadenasAleatorias___.stream()
                .filter(x -> !x.isBlank()) //Eliminar todas las cadenas vacías de la lista.
                .filter(x -> x.length() > 5) //Filtra la lista anterior con cadena de más de 5 caracteres.
                .map(String::toUpperCase)//Convertir las palabras a mayúsculas.
                .collect(Collectors.joining(","));//Concatenarlos usando una coma ‘,’.

        System.out.println(eliminandoVacios);


        //Implementar el siguiente ejercicio utilizando IntSummaryStatistics.
        IntSummaryStatistics intSummaryStatistics
                = new IntSummaryStatistics();

        List<Integer> list
                = Arrays.asList(10, 20, 30, 40, 50);

        for (Integer integer : list) {
            intSummaryStatistics.accept(integer);
        }

        // Obtener el recuento.
        System.out.println("El recuento es :" + intSummaryStatistics.getCount());

        //Obtener el minimo valor.
        System.out.println("El valor minimo de los valores es: " + intSummaryStatistics.getMin());

        //Obtener el maximo valor.
        System.out.println("El valor máximo de los valores es: " + intSummaryStatistics.getMax());

        //Obtener la suma.
        System.out.println("La suma de los números es: " + intSummaryStatistics.getSum());

        //Obtener el promedio.
        System.out.println("El promedio es: "  + intSummaryStatistics.getAverage());

    }


    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }
}