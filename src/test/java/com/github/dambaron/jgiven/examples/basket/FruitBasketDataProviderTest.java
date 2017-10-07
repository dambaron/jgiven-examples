package com.github.dambaron.jgiven.examples.basket;

import com.github.dambaron.jgiven.examples.steps.GivenFruitBasket;
import com.github.dambaron.jgiven.examples.steps.ThenFruitBasket;
import com.github.dambaron.jgiven.examples.steps.WhenFruitBasket;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class FruitBasketDataProviderTest extends ScenarioTest<GivenFruitBasket, WhenFruitBasket, ThenFruitBasket> {

    @DataProvider
    public static Object[][] a_new_fruit_can_be_added_to_an_empty_basket() {

        return new Fruit[][]{
                {new Papaya("p1")},
                {new Durion("d1")},
                {new Banana("b1")}
        };
    }

    @DataProvider
    public static Object[][] new_fruits_can_be_added_to_an_empty_basket() {

        Papaya pa = new Papaya("pa");
        Durion du = new Durion("du");
        Banana ba = new Banana("ba");

        Papaya pa1 = new Papaya("pa1");
        Papaya pa2 = new Papaya("pa2");
        Papaya pa3 = new Papaya("pa3");


        return new Object[][]{
                {Arrays.asList(pa)},
                {Arrays.asList(pa, du)},
                {Arrays.asList(pa, du, ba)},

                {Arrays.asList(pa1)},
                {Arrays.asList(pa1, pa2)},
                {Arrays.asList(pa1, pa2, pa3)},
        };
    }

    @DataProvider
    public static Object[][] new_fruits_can_be_added_to_a_filled_basket() {

        Papaya pa = new Papaya("pa");
        Durion du = new Durion("du");
        Banana ba = new Banana("ba");

        Papaya pa1 = new Papaya("pa1");
        Papaya pa2 = new Papaya("pa2");
        Papaya pa3 = new Papaya("pa3");


        return new Object[][]{
                {new ArrayList<Fruit>(), Arrays.asList(pa), Arrays.asList(pa)},
                {new ArrayList<Fruit>(), Arrays.asList(pa, du), Arrays.asList(pa, du)},
                {new ArrayList<Fruit>(), Arrays.asList(pa, du, ba), Arrays.asList(pa, du, ba)},

                {Arrays.asList(pa), new ArrayList<>(), Arrays.asList(pa)},
                {Arrays.asList(pa), Arrays.asList(du), Arrays.asList(pa, du)},
                {Arrays.asList(pa), Arrays.asList(du, ba), Arrays.asList(pa, du, ba)},

                {new ArrayList<Fruit>(), Arrays.asList(pa1), Arrays.asList(pa1)},
                {new ArrayList<Fruit>(), Arrays.asList(pa1, pa2), Arrays.asList(pa1, pa2)},
                {new ArrayList<Fruit>(), Arrays.asList(pa1, pa2, pa3), Arrays.asList(pa1, pa2, pa3)},

                {Arrays.asList(pa1), new ArrayList<>(), Arrays.asList(pa1)},
                {Arrays.asList(pa1), Arrays.asList(pa2), Arrays.asList(pa1, pa2)},
                {Arrays.asList(pa1), Arrays.asList(pa2, pa3), Arrays.asList(pa1, pa2, pa3)},
        };
    }

    @Test
    @UseDataProvider
    public void a_new_fruit_can_be_added_to_an_empty_basket(Fruit fruit) {

        given().a_fruit_basket()
                .and().it_is_empty();

        when().a_$_is_added(fruit);

        then().the_fruit_basket_should_not_be_empty()
                .and().the_fruit_basket_should_contain_$(fruit);
    }

    @Test
    @UseDataProvider
    public void new_fruits_can_be_added_to_an_empty_basket(List<Fruit> fruitsToBeAdded,
                                                           List<Fruit> expectedFruits) {
        given().a_fruit_basket()
                .and().it_is_empty();

        when().fruits_are_added(fruitsToBeAdded);

        then().the_fruit_basket_should_not_be_empty()
                .and().the_fruit_basket_should_contain_$(expectedFruits);
    }

    @Test
    @UseDataProvider
    public void new_fruits_can_be_added_to_a_filled_basket(List<Fruit> fruitsAlreadyInBasket,
                                                           List<Fruit> fruitsToBeAdded,
                                                           List<Fruit> expectedFruits) {
        given().a_fruit_basket()
                .and().it_is_filled_with(fruitsAlreadyInBasket);

        when().fruits_are_added(fruitsToBeAdded);

        then().the_fruit_basket_should_not_be_empty()
                .and().the_fruit_basket_should_contain_$(expectedFruits);
    }
}