package de.milkonomy.elements.bottles;

import de.milkonomy.app.Application;

public class BlyBottleWithoutTax extends Bottle {
    public BlyBottleWithoutTax(int x, int y, Double sizeIndex) {
        super(x, y, Application.processing.loadImage("bottleBlyWithoutTax.png"), sizeIndex);
    }
}
