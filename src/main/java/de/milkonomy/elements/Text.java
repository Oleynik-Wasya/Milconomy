package de.milkonomy.elements;

import de.milkonomy.app.Application;
import processing.core.PFont;

import java.awt.*;

public class Text implements Element {

    private int x;
    private int y;
    private String text;
    private Color color;
    private PFont font;
    private boolean animated = false;
    private int speed = 15;
    private Integer textLeading;
    private Integer textAlign;
    private Color backgroundColor;
    private int borderRadius;
    private int borderSizeWidth;
    private int borderSizeHeight;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    public static class Builder {
        private int x = 0;
        private int y = 0;
        private String text;
        private Color color = Color.white;
        private PFont font = new PFont();
        private Integer textLeading;
        private Integer textAlign;
        private Color backgroundColor;
        private int borderRadius;
        private int borderSizeWidth;
        private int borderSizeHeight;

        public Builder setBorderSizeHeight(int borderSizeHeight) {
            this.borderSizeHeight = borderSizeHeight;
            return this;
        }

        public Builder(String text) {
            this.text = text;
        }

        public Builder setBackgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setBorderRadius(int borderRadius) {
            this.borderRadius = borderRadius;
            return this;
        }

        public Builder setBorderSizeWidth(int borderSizeWidth) {
            this.borderSizeWidth = borderSizeWidth;
            return this;
        }

        public Builder textAlign(int value) {
            this.textAlign = value;
            return this;
        }

        public Builder x(int x) {
            this.x = x;
            return this;
        }

        public Builder y(int y) {
            this.y = y;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder color(Color color) {
            this.color = color;
            return this;
        }

        public Builder font(PFont font) {
            this.font = font;
            return this;
        }

        public Builder textLeading(int value) {
            this.textLeading = value;
            return this;
        }

        public Text build() {
            Text text = new Text();
            text.x = this.x;
            text.y = this.y;
            text.font = this.font;
            text.color = this.color;
            text.text = this.text;
            text.textLeading = this.textLeading;
            text.textAlign = this.textAlign;
            text.backgroundColor = this.backgroundColor;
            text.borderSizeWidth = this.borderSizeWidth;
            text.borderRadius = this.borderRadius;
            text.borderSizeHeight = this.borderSizeHeight;

            return text;
        }
    }

    private Text() {
    }

    public Integer getTextLeading() {
        return textLeading;
    }

    public int getWidth() {
        Application.processing.textFont(this.font);
        return (int) Application.processing.textWidth(this.text);
    }

    public int getHeight() {
        Application.processing.textFont(this.font);
        return (int) (Application.processing.textAscent() - Application.processing.textDescent() + (this.textLeading == null ? 0 : getTextLeading() - this.font.getSize())) * countOfLine();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void draw() {
        animation();

        if (isOnDisplay) {
            if (backgroundColor != null) {
                Application.processing.fill(backgroundColor.getRGB());
                Application.processing.rect(getX(), getY() + Application.processing.height / 50, getWidth() + borderSizeWidth, getHeight() + borderSizeHeight, borderRadius);
            }
            Application.processing.textFont(font);
            if (textLeading != null) {
                Application.processing.textLeading(textLeading);
            }
            if (textAlign != null) {
                Application.processing.textAlign(textAlign);
            }
            Application.processing.fill(color.getRGB());
            Application.processing.text(text, x, y);
        }
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PFont getFont() {
        return font;
    }

    public void setFont(PFont font) {
        this.font = font;
    }

    public int countOfLine() {
        return text.length() - text.replace("\n", "").length() + 1;
    }

    private boolean isOnDisplay = false;
    private boolean first = true;

    private char[] splitedText;
    private StringBuffer currentText;
    private int i = 0;
    private int timeForOneSymbol = 10;
    private int k = 0;

    private void animation() {
        if (!animated) {
            isOnDisplay = true;
        }
        if (!isOnDisplay) {
            Application.processing.textFont(font);
            if (textLeading != null) {
                Application.processing.textLeading(textLeading);
            }
            if (textAlign != null) {
                Application.processing.textAlign(textAlign);
            }
            if (first) {
                splitedText = this.text.toCharArray();
                currentText = new StringBuffer(splitedText[0]);
                first = false;
            }
            Application.processing.fill(color.getRGB());
            Application.processing.text(currentText.toString(), getX(), getY());

            if (k >= timeForOneSymbol) {
                currentText.append(splitedText[i]);
                i++;
                k = 0;
            }
            k += speed;
            if (i == splitedText.length) {
                isOnDisplay = true;
            }
        }
    }

    @Override
    public String toString() {
        return text;
    }
}
