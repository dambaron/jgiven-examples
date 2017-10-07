package com.github.dambaron.jgiven.examples.steps;

import com.github.dambaron.jgiven.examples.basket.Fruit;
import com.github.dambaron.jgiven.examples.basket.FruitBasket;
import com.github.dambaron.jgiven.examples.format.FruitFormatter;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.*;

import java.util.Arrays;
import java.util.List;

public class WhenFruitBasket extends Stage<WhenFruitBasket> {

    @ExpectedScenarioState
    private FruitBasket fruitBasket;

    @As("the following fruits are added: $fruits")
    public WhenFruitBasket fruits_are_added(List<Fruit> fruits) {
        fruitBasket.addFruits(fruits);
        return self();
    }

    //@As("the following fruits are added: $fruits")
    public WhenFruitBasket fruits_are_added(@Table Fruit... fruits) {
        List<Fruit> fruitsToBeAdded = Arrays.asList(fruits);
        fruitBasket.addFruits(fruitsToBeAdded);
        return self();
    }

    public WhenFruitBasket a_$_is_added(Fruit fruit) {
        fruitBasket.addFruit(fruit);
        return self();
    }
}
