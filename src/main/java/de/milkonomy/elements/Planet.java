package de.milkonomy.elements;

import de.milkonomy.app.Application;
import processing.core.PImage;

public class Planet extends Image {
    public Planet(int x, int y, PImage image) {
        super(x, y, image);
        image.resize((int) (Application.processing.height * 0.8), (int) (Application.processing.height * 0.8));
    }

    @Override
    public void draw() {
        Application.processing.image(getImage(), getX(), getY());
    }
}
