package com.github.dambaron.jgiven.examples.basket;

import com.github.dambaron.jgiven.examples.steps.GivenFruitBasket;
import com.github.dambaron.jgiven.examples.steps.ThenFruitBasket;
import com.github.dambaron.jgiven.examples.steps.WhenFruitBasket;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitBasketTest extends ScenarioTest<GivenFruitBasket, WhenFruitBasket, ThenFruitBasket> {

    @Test
    public void a_new_fruit_can_be_added_to_an_empty_basket() {

        Banana banana = new Banana("b1");

        given().a_fruit_basket()
                .and().it_is_empty();

        when().a_$_is_added(banana);

        then().the_fruit_basket_should_not_be_empty()
                .and().the_fruit_basket_should_contain_$(banana);
    }

    @Test
    public void new_fruits_can_be_added_to_an_empty_basket() {

        Banana banana = new Banana("b1");
        Papaya papaya = new Papaya("p1");

        given().a_fruit_basket()
                .and().it_is_empty();

        when().fruits_are_added(papaya, banana);

        then().the_fruit_basket_should_not_be_empty()
                .and().the_fruit_basket_should_contain_$(banana, papaya);
    }

    @Test
    public void a_new_fruit_can_be_added_to_a_filled_basket() {

        Banana banana = new Banana("b1");
        Papaya papaya = new Papaya("p1");

        Papaya anotherPapaya = new Papaya("p1");

        given().a_fruit_basket()
                .and().it_is_filled_with(banana, papaya);

        when().fruits_are_added(anotherPapaya);

        then().the_fruit_basket_should_not_be_empty()
                .and().the_fruit_basket_should_contain_$(banana, papaya, anotherPapaya);
    }
}