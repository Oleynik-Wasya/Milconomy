package de.milkonomy.elements;

import de.milkonomy.app.Application;

public interface Element {

    int getWidth();

    int getHeight();

    int getX();

    int getY();

    void draw();

    default boolean overElement() {
        if (Application.processing.mouseX >= getX() - getWidth() / 2 && Application.processing.mouseX <= getX() + getWidth() / 2 &&
                Application.processing.mouseY >= getY() - getHeight() / 2 && Application.processing.mouseY <= getY() + getHeight() / 2) {
            return true;
        } else {
            return false;
        }
    }
}