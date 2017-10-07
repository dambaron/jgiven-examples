package com.github.dambaron.jgiven.examples.steps;

import com.github.dambaron.jgiven.examples.basket.Fruit;
import com.github.dambaron.jgiven.examples.basket.FruitBasket;
import com.github.dambaron.jgiven.examples.basket.SimpleFruit;
import com.github.dambaron.jgiven.examples.format.FruitFormatter;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GivenFruitBasket extends Stage<GivenFruitBasket> {

    @ProvidedScenarioState
    private FruitBasket fruitBasket;

    public GivenFruitBasket a_fruit_basket() {
        fruitBasket = new FruitBasket();
        return this;
    }

    public GivenFruitBasket it_is_empty() {

        fruitBasket.clearFruits();
        return this;
    }

    public GivenFruitBasket it_is_filled_with(List<Fruit> fruits) {
        fruitBasket.addFruits(fruits);
        return this;
    }

    public GivenFruitBasket it_is_filled_with(@Table Fruit... fruits) {
        return it_is_filled_with(Arrays.asList(fruits));
    }
}
