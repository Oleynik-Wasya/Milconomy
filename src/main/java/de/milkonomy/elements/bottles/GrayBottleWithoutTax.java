package de.milkonomy.elements.bottles;

import de.milkonomy.app.Application;

public class GrayBottleWithoutTax extends Bottle {
    public GrayBottleWithoutTax(int x, int y, Double sizeIndex) {
        super(x, y, Application.processing.loadImage("grayBottleWithoutTax.png"), sizeIndex);
        setColor(Application.mainColorTwo);
    }
}
