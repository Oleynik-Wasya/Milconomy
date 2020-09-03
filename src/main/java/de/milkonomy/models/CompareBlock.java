package de.milkonomy.models;

import de.milkonomy.app.Application;
import de.milkonomy.elements.bottles.BlyBottleWithoutTax;
import de.milkonomy.elements.bottles.Bottle;
import de.milkonomy.elements.bottles.GrayBottleWithoutTax;
import de.milkonomy.elements.Text;
import processing.core.PConstants;
import processing.core.PFont;

import java.awt.*;

public class CompareBlock {
    private Bottle bottle;
    private Country country;
    private int x;
    private int y;
    private Text cost;
    private Text monthlyIncome;
    private Text costOfLivingIndex;
    private Color color;
    private Text countyName;
    private int margin = 40;

    public void defineLiquid(Double value) {
        this.bottle.defineLiquid(value);
    }

    public Country getCountry() {
        return country;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CompareBlock(Country country, int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.country = country;
        this.color = color;

        if (color.equals(Application.mainColorOne)) {
            bottle = new BlyBottleWithoutTax(x, y, 0.7);
        } else {
            bottle = new GrayBottleWithoutTax(x, y, 0.7);
        }

        bottle.defineLiquid(100.);
        this.cost = new Text.Builder(String.format("1 litre milk - %.2f €", country.getCost()))
                .x(x - bottle.getWidth() / 2 - (int)(Application.processing.width / 68.3))
                .y(y + bottle.getHeight() / 2 + margin)
                .font(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 51))
                .color(color)
                .build();

        this.monthlyIncome = new Text.Builder(String.format("monthly income of\nthe average citizen\n - %.2f €", country.getMonthlyIncome()))
                .color(color)
                .font(Application.processing.createFont(Application.mainFont + " Bold", 15))
                .x(x - bottle.getWidth() / 2 - (int)(Application.processing.width / 68.3))
                .y(cost.getY() + margin)
                .textAlign(PConstants.LEFT)
                .textLeading(Application.processing.createFont(Application.mainFont + " Bold", 15).getSize() + 2)
                .build();

        this.costOfLivingIndex = new Text.Builder("Costs of living index - " + country.getCostsOfLivingIndex())
                .color(Color.white)
                .font(Application.processing.createFont(Application.mainFont + " Regular", Application.processing.height / 69))
                .x(x - bottle.getWidth() / 2 - (int)(Application.processing.width / 68.3))
                .y(monthlyIncome.getY() + monthlyIncome.getHeight() + margin)
                .build();

        this.countyName = new Text.Builder(country.getName())
                .color(color)
                .font(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 48))
                .x(x)
                .y(y - bottle.getHeight() / 2 - margin / 3)
                .textAlign(PConstants.CENTER)
                .build();
    }

    public void draw() {
        Application.processing.textAlign(PConstants.CENTER);
        bottle.draw();
        Application.processing.textAlign(PConstants.LEFT);
        cost.draw();
        monthlyIncome.draw();
        Application.processing.rectMode(PConstants.CORNER);
        Application.processing.noStroke();
        Application.processing.rect(costOfLivingIndex.getX() - 5, costOfLivingIndex.getY() - costOfLivingIndex.getHeight() - 5, costOfLivingIndex.getWidth() + 10, costOfLivingIndex.getHeight() + 10, 1);
        costOfLivingIndex.draw();
        countyName.draw();
    }
}
