package com.github.dambaron.jgiven.examples.steps;

import com.github.dambaron.jgiven.examples.basket.Fruit;
import com.github.dambaron.jgiven.examples.basket.FruitBasket;
import com.github.dambaron.jgiven.examples.format.FruitFormatter;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.Format;
import com.tngtech.jgiven.annotation.Table;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenFruitBasket extends Stage<ThenFruitBasket> {
    @ExpectedScenarioState
    private FruitBasket fruitBasket;

    public ThenFruitBasket the_fruit_basket_should_not_be_empty() {
        assertThat(fruitBasket.getFruits()).isNotNull();
        assertThat(fruitBasket.getFruits().size()).isGreaterThan(0);
        return self();
    }

    public ThenFruitBasket the_fruit_basket_should_contain_$(List<Fruit> fruits) {
        assertThat(fruitBasket.getFruits()).isNotNull().containsAll(fruits);
        return self();
    }

    public ThenFruitBasket the_fruit_basket_should_contain_$(@Table Fruit... fruits) {

        List<Fruit> expectedFruits = Arrays.asList(fruits);
        assertThat(fruitBasket.getFruits()).isNotNull().containsAll(expectedFruits);
        return self();
    }
}
