package de.milkonomy.slides;

import de.milkonomy.app.Application;
import de.milkonomy.elements.*;
import de.milkonomy.elements.Button;
import de.milkonomy.elements.bottles.BlyBottleWithoutTax;
import de.milkonomy.elements.bottles.Bottle;
import de.milkonomy.models.AverageMonthly;
import de.milkonomy.models.Country;
import de.milkonomy.models.InformationBlock;
import processing.core.PImage;

import java.awt.*;

public class InfoSlide implements Slideable {

    private Map map;
    private Line line;
    private InformationBlock informationBlock;
    private Button buttonCompare;
    private Button back;
    private Bottle bottle;
    private Country country;
    private Text milconomy;
    private AverageMonthly averageMonthly;

    public void setup(Country country) {
        this.country = country;
        map = new Map(Application.processing.width / 4, Application.processing.height / 2, country.getMap().getImage());

        int infoBlockStartY = (int) (Application.processing.height / 6.);

        int countOfCoinsLine = AverageMonthly.countOfCoinsLine(100 + country.getMonthlyIncomeDifference());
        if (countOfCoinsLine == 2) {
            infoBlockStartY = (int) (Application.processing.height / 4.);
        } else if (countOfCoinsLine == 3) {
            infoBlockStartY = (int) (Application.processing.height / 5.);
        } else if (countOfCoinsLine == 4) {
            infoBlockStartY = (int) (Application.processing.height / 4.8);
        }

        line = new Line.Builder((int) (Application.processing.width / 2.3), infoBlockStartY + Application.processing.height / 20, (int) (Application.processing.width / 2.1), infoBlockStartY)
                .setStrokeWeight(2)
                .setColor(Application.mainColorOne)
                .setAnimated(true)
                .build();

        line.addPoint(line.getLastPoint().getX() + Application.processing.width / 5, line.getLastPoint().getY());
        line.setAnimated(true);

        informationBlock = new InformationBlock.Builder()
                .setColor(Application.mainColorOne)
                .setCost(country.getCost())
                .setMonthlyIncome(country.getMonthlyIncome())
                .setCostsOfLivingIndex(country.getCostsOfLivingIndex())
                .setCountryName(country.getName())
                .setRank(country.getRank())
                .setTax(country.getTax())
                .setX(line.getLastPoint().getX() + 30)
                .setY(line.getLastPoint().getY())
                .setWidth(Application.processing.width / 5)
                .setFont(Application.processing.createFont(Application.mainFont, Application.processing.height / 24))
                .setMap(map)
                .setContinent(country.getContinent())
                .setMonthlyIncomeDifference(country.getMonthlyIncomeDifference())
                .build();

        buttonCompare = new Button.Builder()
                .setWidth(Application.processing.height / 14)
                .setHeight(Application.processing.width / 5)
                .setText("compare")
                .setColorText(Color.white)
                .setColorRect(Color.decode("#D5E8ED"))
                .setFont(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 29))
                .setVertical(true)
                .build();
        buttonCompare.setX(Application.processing.width - buttonCompare.getWidth() / 2);
        buttonCompare.setY((int) (Application.processing.height / 1.3));

        back = new Button.Builder()
                .setWidth(Application.processing.width / 14)
                .setHeight(Application.processing.height / 12)
                .setColorText(Color.white)
                .setColorRect(Color.decode("#D5E8ED"))
                .setFont(Application.processing.createFont(Application.mainFont, Application.processing.height / 28))
                .setImage(Application.processing.loadImage("Arrow.png"))
                .build();
        back.setX(back.getWidth() / 2 - 7);
        back.setY(back.getHeight());

        PImage b = Application.processing.loadImage("blyBottleWithTax.png");
        b.resize(Application.processing.width / 10, Application.processing.height / 2);
        bottle = new BlyBottleWithoutTax((int) (Application.processing.width / 1.7), (int) (Application.processing.height / 1.65), 1.);
        bottle.defineLiquid(75.);
        bottle.defineGrayLiquid(informationBlock.getTax());


        this.milconomy = new Text.Builder("milconomy".toUpperCase())
                .color(Color.decode("#EDF7F9"))
                .font(Application.processing.createFont(Application.mainFont + " Bold", 46))
                .textAlign(Application.processing.CENTER)
                .build();
        milconomy.setX(Application.processing.width - milconomy.getWidth() / 2 + milconomy.getHeight() / 3);
        milconomy.setY(Application.processing.height / 20 + milconomy.getHeight() / 2);
    }

    public Country getCountry() {
        return country;
    }

    public InfoSlide(Country country) {
        setup(country);
    }

    public Button getButtonCompare() {
        return buttonCompare;
    }

    public Button getBack() {
        return back;
    }

    public void draw() {
        Application.processing.background(255);
        bottle.draw();
        line.draw();
        informationBlock.draw();
        buttonCompare.draw();
        back.draw();

        if (back.overElement()) {
            back.setColorRect(Application.mainColorOne.brighter());
        } else {
            back.setColorRect(Color.decode("#D5E8ED"));
        }

        if (buttonCompare.overElement()) {
            buttonCompare.setColorRect(Application.mainColorOne.brighter());
        } else {
            buttonCompare.setColorRect(Color.decode("#D5E8ED"));
        }

        milconomy.draw();
    }
}
