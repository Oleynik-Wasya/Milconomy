package de.milkonomy.elements;

import de.milkonomy.app.Application;

import java.awt.*;

public class Rect implements Element {
    private int x;
    private int y;
    private int width;
    private int height;
    private int corner;
    private Color color;

    static public class Builder {
        private int x;
        private int y;
        private int width;
        private int height;
        private int corner;
        private Color color;

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder setX(int x) {
            this.x = x;
            return this;
        }

        public Builder setY(int y) {
            this.y = y;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setCorner(int corner) {
            this.corner = corner;
            return this;
        }

        public Rect build() {
            Rect rect = new Rect();
            rect.x = this.x;
            rect.y = this.y;
            rect.width = this.width;
            rect.height = this.height;
            rect.corner = this.corner;
            rect.color = this.color;

            return rect;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw() {
        Application.processing.fill(color.getRGB());
        Application.processing.rect(x, y, width, height, corner);
    }
}
