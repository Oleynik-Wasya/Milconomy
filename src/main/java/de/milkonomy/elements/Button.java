package de.milkonomy.elements;

import de.milkonomy.app.Application;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PImage;

import java.awt.*;

public class Button implements Element {

    private int x;
    private int y;
    private int width;
    private int height;
    private int corner;
    private String text;
    private Color colorText;
    private Color colorRect;
    private PFont font;
    private boolean vertical;
    private PImage image;
    private Color shadowColor = Color.decode("#AED2DA");

    public static class Builder {
        private int x;
        private int y;
        private int width;
        private int height;
        private int corner;
        private String text;
        private Color colorText;
        private Color colorRect;
        private PFont font;
        private boolean vertical = false;
        private PImage image;

        public Builder setImage(PImage image) {
            image.resize(image.width * (this.height - 28) / image.height, this.height - 26);
            this.image = image;
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

        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        public Builder setColorText(Color colorText) {
            this.colorText = colorText;
            return this;
        }

        public Builder setColorRect(Color colorRect) {
            this.colorRect = colorRect;
            return this;
        }

        public Builder setFont(PFont font) {
            this.font = font;
            return this;
        }

        public Builder setVertical(boolean b) {
            this.vertical = b;
            return this;
        }

        public Button build() {
            Button button = new Button();
            button.font = this.font;
            button.height = this.height;
            button.width = this.width;
            button.colorRect = this.colorRect;
            button.colorText = this.colorText;
            button.corner = this.corner;
            button.text = this.text;
            button.x = this.x;
            button.y = this.y;
            button.vertical = this.vertical;
            button.image = this.image;

            return button;
        }
    }

    public Color getColorText() {
        return colorText;
    }

    public void setColorText(Color colorText) {
        this.colorText = colorText;
    }

    public Color getColorRect() {
        return colorRect;
    }

    public void setColorRect(Color colorRect) {
        this.colorRect = colorRect;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCorner() {
        return corner;
    }

    public void setCorner(int corner) {
        this.corner = corner;
    }

    public Color getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
    }

    private Button() {
    }

    public void draw() {
        Application.processing.rectMode(PConstants.CENTER);
        Application.processing.noStroke();
        if (vertical) {
            Application.processing.fill(shadowColor.getRGB());
            Application.processing.rect(this.x, (int)(this.y + 3.5), this.width + 14, this.height + 7, this.corner);
            Application.processing.fill(colorRect.getRGB());
            Application.processing.rect(this.x, this.y, this.width, this.height, this.corner);
        } else {
            Application.processing.fill(shadowColor.getRGB());
            Application.processing.rect(this.x + 3, (int)(this.y + 3.5), this.width, this.height + 7, this.corner);
            Application.processing.fill(colorRect.getRGB());
            Application.processing.rect(this.x, this.y, this.width, this.height, this.corner);
        }

        Application.processing.fill(colorText.getRGB());
        Application.processing.textFont(font);
        if (image != null) {
            Application.processing.image(image, x, y);
        }
        if (text == null) {
            return;
        }
        if (vertical) {
            Application.processing.pushMatrix();
            Application.processing.translate(this.x, this.y - font.getSize() / 4);
            Application.processing.rotate(-Application.processing.HALF_PI);
            Application.processing.text(this.text, 0, -5);
            Application.processing.popMatrix();
        } else {
            Application.processing.text(this.text, this.x, this.y - font.getSize() / 4);
        }

    }
}
