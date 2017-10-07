package com.github.dambaron.jgiven.examples.format;

import com.github.dambaron.jgiven.examples.basket.Fruit;
import com.tngtech.jgiven.format.ArgumentFormatter;

public class FruitFormatter implements ArgumentFormatter<Fruit> {

    @Override
    public String format(Fruit fruit, String... formatterArguments) {
        if (fruit == null) {
            return "";
        }

        return "[name = \"" + fruit.getType() + "\", id = \"" + fruit.getId() + "\"]";
    }
}

