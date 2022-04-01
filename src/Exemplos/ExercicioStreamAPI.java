package Exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        System.out.println("Pegue os 5 primeiros números e coloque-os dentro de um Set");
        numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::print);
        System.out.println("\n");
        //outra forma
        Set<String> collectSet = numerosAleatorios.stream().limit(5).collect(Collectors.toSet());
        System.out.println(collectSet);
        System.out.println("\n");

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        numerosAleatorios.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });
        numerosAleatorios.forEach(System.out::print);
        System.out.println("\n");

        System.out.println("(Lambda) Transforme esta lista de String em uma lista de números inteiros.");
        numerosAleatorios.stream().map(s->Integer.parseInt(s));
        numerosAleatorios.forEach(System.out::print);
        System.out.println("\n");

        System.out.println("(Method Reference) Transforme esta lista de String em uma lista de números inteiros.");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::print); //imprimindo em seguida
        System.out.println("\n");

        //outra forma: coletando e atribuindo a uma variável
        System.out.println("(Em uma variável) Transforme esta lista de String em uma lista de números inteiros.");
        List<Integer> collectList = numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        collectList.forEach(System.out::print);
        System.out.println("\n");
    }
}
