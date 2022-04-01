package Exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExercicioStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios = Arrays.asList("1","0","4","1","2","3","9","9","6","5");

        System.out.println("Imprima todos os elementos dessa lista de String com " +
                "método stream e classe anônima Consumer: ");
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(" "+s);
            }
        });
        System.out.println("\n");

        System.out.println("Imprima todos os elementos dessa lista de String com " +
                "método stream e Lambda: ");
        numerosAleatorios.stream().forEach(s->System.out.print(" "+s));
        System.out.println("\n");

        System.out.println("Imprima todos os elementos dessa lista de String sem " +
                "stream e com Lambda: ");
        numerosAleatorios.forEach(s->System.out.print(" "+s));
        System.out.println("\n");

        System.out.println("Imprima todos os elementos dessa lista de String sem " +
                "stream e com Method Reference: ");
        numerosAleatorios.forEach(System.out::print);
        System.out.println("\n");

    }
}
