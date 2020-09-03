package de.milkonomy.elements;

import de.milkonomy.app.Application;
import processing.core.PImage;

public class Image implements Element {
    private int x;
    private int y;
    private PImage image;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return image.width;
    }

    public int getHeight() {
        return image.height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public PImage getImage() {
        return image;
    }

    public void resize(int width, int height) {
        image.resize(width, height);
    }

    public Image(int x, int y, PImage image) {
        this.x = x;
        this.y = y;
        this.image = image;
        float sizeIndex = Application.processing.width / Application.processing.height;
        image.resize((int) (image.width * sizeIndex), (int) (image.height * sizeIndex));
    }

    public void resize(float sizeIndex) {
        image.resize((int) (image.width * sizeIndex), (int) (image.height * sizeIndex));
    }

    public void draw() {
        Application.processing.image(this.image, x, y);
    }
}
