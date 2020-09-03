package de.milkonomy.elements.bottles;

import de.milkonomy.app.Application;
import de.milkonomy.elements.Image;
import processing.core.PConstants;
import processing.core.PImage;

import java.awt.*;

public abstract class Bottle extends Image {
    public Bottle(int x, int y, PImage image, Double sizeIndex) {
        super(x, y, image);
        image.resize((int) (Application.processing.width / 10 * sizeIndex), (int) (Application.processing.height / 2 * sizeIndex));
        xspacing = 2;   // How far apart should each horizontal location be spaced
        w = getX() + getWidth() / 2 - 1;            // Width of entire wave

        theta = 0;  // Start angle at 0
        amplitude = (int) (15 * sizeIndex);  // Height of wave
        period = 500;  // How many pixels before the wave repeats
        dx = (Application.processing.TWO_PI * 2 / period) * xspacing;  // Value for incrementing X, a function of period and xspacing
        yvalues = new float[w / xspacing];

        glassThickness = getWidth() / 11. / 2;
        grayLiquid = 0.;
        liquid = 0.;
        liquidStopY = (getY() + getHeight() / 2.4 + 1.);
        liquidStartY = liquidStopY - (float) ((liquidStopY - getY()) / 70 * liquid);
        grayLiquidStartY = getY() + getHeight() / 2 - glassThickness;

        color = Application.mainColorOne;
    }

    private Double grayLiquid;
    private Double liquid;
    private Double liquidStopY;
    private Double liquidStartY;
    private Double grayLiquidStartY;
    private Color color;
    private Double glassThickness;

    public void setColor(Color color) {
        this.color = color;
    }


    @Override
    public void draw() {
        calcWave();
        renderWave();
        Application.processing.noStroke();
        Application.processing.rectMode(PConstants.CORNERS);

        Application.processing.fill(color.getRGB());
        Application.processing.rect(getX() + getWidth() / 2 - glassThickness.floatValue() + 2, getY() + getHeight() / (float) 2 - 1, getX() - getWidth() / 2 + glassThickness.floatValue() - 2, liquidStartY.floatValue());


        Application.processing.fill(Application.mainColorTwo.getRGB());
        Application.processing.rect(getX() + getWidth() / 2 - glassThickness.floatValue(), grayLiquidStartY.floatValue(), getX() - getWidth() / 2 + glassThickness.floatValue(), grayLiquidStartY.floatValue() - (float) ((grayLiquidStartY - getY()) / 70 * grayLiquid));
        Application.processing.image(getImage(), getX(), getY());
    }

    public void defineGrayLiquid(Double value) {
        this.grayLiquid = value;
    }

    public void defineLiquid(Double value) {
        this.liquid = value;
        liquidStartY = liquidStopY - (float) ((liquidStopY - getY()) / 70 * liquid);
    }

    public Double getGrayLiquid() {
        return grayLiquid;
    }

    int xspacing;   // How far apart should each horizontal location be spaced
    int w;            // Width of entire wave

    float theta;  // Start angle at 0
    float amplitude;  // Height of wave
    float period;  // How many pixels before the wave repeats
    float dx;  // Value for incrementing X, a function of period and xspacing
    float[] yvalues;  // Using an array to store height values for the wave

    void calcWave() {
        // Increment theta (try different values for 'angular velocity' here
        theta += 0.03;

        // For every x value, calculate a y value with sine function
        float x = theta;
        for (int i = 0; i < yvalues.length; i++) {
            yvalues[i] = Application.processing.sin(x) * amplitude - amplitude;
            x += dx;
        }
    }

    void renderWave() {
        Application.processing.strokeWeight(3);
        Application.processing.fill(255);
        Application.processing.stroke(color.getRGB());
        // A simple way to draw the wave with an ellipse at each location
        for (int x = getX() / xspacing - getWidth() / 2 / xspacing + 2; x < yvalues.length; x++) {
            Application.processing.line(x * xspacing, liquidStartY.floatValue() + 1, x * xspacing, liquidStartY.floatValue() + yvalues[x]);
        }
    }
}
