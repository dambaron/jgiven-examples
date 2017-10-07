package com.github.dambaron.jgiven.examples.basket;

import java.util.*;
import java.util.stream.Collectors;

public class FruitBasket {

    private List<Fruit> fruits = new ArrayList<>();

    public List<Fruit> getFruits() {
        return fruits;
    }

    public Map<String, List<Fruit>> getFruitsByType() {
        return fruits.stream().collect(Collectors.groupingBy(Fruit::getType, Collectors.toList()));
    }

    public void clearFruits() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(Fruit fruit) {
        addFruits(Collections.singletonList(fruit));
    }

    public void addFruits(List<Fruit> fruits) {
        this.fruits.addAll(fruits);
    }
}
