package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) {
        final var numbers = Arrays.asList(1,2,3,4,5,6);

        var listInteger = new ArrayList<Integer>();
        for (Integer number : numbers){
            if(number % 2 == 0)
                listInteger.add(number);
        }
        System.out.println(listInteger);


        //With Streams
        var evenNumbers = numbers.stream().filter(number -> number % 2 == 0).toList();
        System.out.println(evenNumbers);

        var names = Arrays.asList("Maarten", "Marit", "Mala");
        var khalid = names.stream()
                .filter(n -> n.equals("Khalid"))
                .findFirst();


        // ### Simple examples of Java Streams


        enum FruitCategory {
            SubAcid,
            Acid,
        }

        record Fruit(
                String name,
                FruitCategory category,
                double price
        ){}

        List<Fruit> fruits = Arrays.asList(
                new Fruit("Avocado", FruitCategory.Acid, 10.0),
                new Fruit("Apple", FruitCategory.SubAcid, 8.0)
        );

        var fru = fruits.stream().map(Fruit::price).toList();

        System.out.println(fru);

        var discountedFruits = fruits.stream()
                .map(fruit -> new Fruit(fruit.name, fruit.category, fruit.price * 0.8))
                .toList()
                        .stream().map(Fruit::price).toList();

        System.out.println(discountedFruits);

        var skipeFirst = discountedFruits.stream().skip(1).toList();
        System.out.println(skipeFirst);

        var limitList = discountedFruits.stream().limit(1).toList();
        System.out.println( limitList);

        var highestToLowest = fruits.stream()
                .sorted(comparing(Fruit::price, reverseOrder()))
                .toList();

        System.out.println(highestToLowest);
    }
}