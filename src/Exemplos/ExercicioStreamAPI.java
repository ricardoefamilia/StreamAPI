package Exemplos;

import java.util.*;
import java.util.function.*;
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
        System.out.println();

        System.out.println("Imprima todos os elementos dessa lista de String com " +
                "método stream e Lambda: ");
        numerosAleatorios.stream().forEach(s->System.out.print(" "+s));
        System.out.println();

        System.out.println("Imprima todos os elementos dessa lista de String sem " +
                "stream e com Lambda: ");
        numerosAleatorios.forEach(s->System.out.print(" "+s));
        System.out.println();

        System.out.println("Imprima todos os elementos dessa lista de String sem " +
                "stream e com Method Reference: ");
        numerosAleatorios.forEach(System.out::print);
        System.out.println();

        System.out.println("Pegue os 5 primeiros números e coloque-os dentro de um Set");
        numerosAleatorios.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::print);
        System.out.println();
        //outra forma
        Set<String> collectSet = numerosAleatorios.stream().limit(5).collect(Collectors.toSet());
        System.out.println(collectSet);
        System.out.println();

        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
        numerosAleatorios.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        });
        numerosAleatorios.forEach(System.out::print);
        System.out.println();

        System.out.println("(Lambda) Transforme esta lista de String em uma lista de números inteiros.");
        numerosAleatorios.stream().map(s->Integer.parseInt(s));
        numerosAleatorios.forEach(System.out::print);
        System.out.println();

        System.out.println("(Method Reference) Transforme esta lista de String em uma lista de números inteiros.");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::print); //imprimindo em seguida
        System.out.println();

        //outra forma: coletando e atribuindo a uma variável


        System.out.println("(Em uma variável) Transforme esta lista de String em uma lista de números inteiros.");
        List<Integer> listInteiros = numerosAleatorios.stream()
                .map(Integer::parseInt).collect(Collectors.toList());
        listInteiros.forEach(System.out::print);
        System.out.println();

        System.out.println("Pegue os números pares e maiores que 2 e coloque-os em uma lista.");
        List<Integer> ListParesMaiorQ2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if(i % 2 == 0 && i > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println(ListParesMaiorQ2);

        System.out.println("(Lambda) Pegue os números pares e maiores que 2 e coloque-os em uma lista.");
        List<Integer> List2ParesMaiorQ2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i->i % 2 == 0 && i > 2).collect(Collectors.toList());
        System.out.println(List2ParesMaiorQ2);
        List2ParesMaiorQ2.forEach(System.out::println);

        System.out.println("Mostrar a média dos números.");
        numerosAleatorios.stream()
                .mapToInt(new ToIntFunction<String>() {
                    @Override
                    public int applyAsInt(String s) {
                        return Integer.parseInt(s);
                    }
                }).average()
                .ifPresent(new DoubleConsumer() {
                    @Override
                    public void accept(double v) {
                        System.out.println(v);
                    }
                });

        System.out.println("(Lambda) Mostrar a média dos números.");
        numerosAleatorios.stream()
                .mapToInt(s->Integer.parseInt(s))
                .average()
                .ifPresent(v->System.out.println(v));

        System.out.println("(Method reference) Mostrar a média dos números.");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);

        System.out.println("Remova os valores ímpares.");
        //var listInteiros linha 72 deste exercício
        listInteiros.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer % 2 != 0) return true;
                return false;
            }
        });
        System.out.println(listInteiros);

        System.out.println("(Lambda) Remova os valores ímpares.");
        //var listInteiros linha 72 deste exercício
        listInteiros.removeIf(integer->integer % 2 != 0);
        System.out.println(listInteiros);

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante: ");
        System.out.println(numerosAleatorios);
        List<String> ignore3primeiroselementos = numerosAleatorios.stream()
                .skip(3).collect(Collectors.toList());
        System.out.println(ignore3primeiroselementos);

        System.out.println("Retirando os números repetidos da lista, quantos números ficam? ");
        Set<String> listaSet = numerosAleatorios.stream()
                .collect(Collectors.toSet());
        System.out.println(listaSet.size());
        System.out.println(listaSet);

        //outra forma com stream
        System.out.println("Retirando os números repetidos da lista, quantos números ficam? ");
        List<Integer> numerosAleatoriosInteger =  numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        long countNumUnicos = numerosAleatoriosInteger.stream()
                .distinct()
                .count();
        System.out.println("Qtde de números não repetidos: " + countNumUnicos);

        System.out.println("Mostre o menor valor da lista");
        numerosAleatoriosInteger.stream()
                .mapToInt(new ToIntFunction<Integer>() {
                    @Override
                    public int applyAsInt(Integer value) {
                        return value.intValue();
                    }
                })
                .min()
                .ifPresent(System.out::println);

        System.out.println("(Lambda) Mostre o menor valor da lista");
        numerosAleatoriosInteger.stream()
                .mapToInt(value->value.intValue())
                .min()
                .ifPresent(System.out::println);

        System.out.println("(Method Reference) Mostre o menor valor da lista");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.println("Mostre o maior valor da lista");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);

        System.out.println("Pegue apenas os números ímpares e some. ");
        int soma = numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .filter(value->value % 2 != 0)
                .sum();
        System.out.println(numerosAleatoriosInteger);
        System.out.println("Soma dos números ímpares: "+soma);

        System.out.println("Lista na ordem numérica: ");
        List<Integer> listOrdemNumerica = numerosAleatoriosInteger.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(listOrdemNumerica);

        //collect(Collectors.groupingBy(new Function())
        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou de 5: ");
        Map<Boolean, List<Integer>> collectNumerosMultiplosDe3e5 = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i->(i % 3 == 0 || i % 5 == 0)));
        for (Map.Entry<Boolean, List<Integer>> cnm3e5: collectNumerosMultiplosDe3e5.entrySet()) {
            if(cnm3e5.getKey() == true) System.out.println(cnm3e5.getValue());
        }

        //prova
        List<Character> c = Arrays.asList('c', 'm', 'l');
        System.out.println(c);

        List<String> numeros = List.of("1", "2", "5", "3");
        System.out.println(numeros.stream().mapToInt(Integer::parseInt).average());


    }
}
