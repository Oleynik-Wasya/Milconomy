package de.milkonomy.slides;

import de.milkonomy.app.Application;
import de.milkonomy.elements.*;
import de.milkonomy.elements.Button;
import de.milkonomy.elements.Image;
import processing.core.PConstants;
import processing.core.PImage;

import java.awt.*;

public class MainSlide implements Slideable {

    private Planet planet;
    private Double counter;
    private Button buttonToNextSlide;
    private Text MILCONOMY;
    private Text welcomeTo;
    private Image splash;

    public void setup() {
        counter = 0.0;

        planet = new Planet(0, 0, Application.processing.loadImage("planet.png"));
        planet.resize(0.9f);

        MILCONOMY = new Text.Builder("MILCONOMY")
                .font(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 10))
                .color(Application.mainColorOne)
                .x((int) (Application.processing.width / 2))
                .y(Application.processing.height / 2)
                .setBackgroundColor(Color.white)
                .setBorderRadius(40)
                .setBorderSizeWidth(60)
                .setBorderSizeHeight(30)
                .build();

        buttonToNextSlide = new Button.Builder()
                .setX((int) MILCONOMY.getX())
                .setY((int) (MILCONOMY.getY() + MILCONOMY.getHeight() + Application.processing.height / 15))
                .setWidth(Application.processing.width / 5)
                .setHeight(Application.processing.height / 18)
                .setCorner(50)
                .setText("click here to start")
                .setColorText(Color.white)
                .setColorRect(Color.decode("#D5E8ED"))
                .setFont(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 42))
                .build();


        welcomeTo = new Text.Builder("welcome to")
                .font(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 29))
                .color(Color.white)
                .x(MILCONOMY.getX())
                .y(MILCONOMY.getY() - MILCONOMY.getHeight() / 2 - 40)
                .build();
        PImage s = Application.processing.loadImage("splash.png");
        splash = new Image(Application.processing.width / 2, Application.processing.height / 2, s);
    }

    public MainSlide() {
        setup();
    }

    public Button getButtonToNextSlide() {
        return buttonToNextSlide;
    }

    public void draw() {
        Application.processing.textAlign(PConstants.CENTER, PConstants.CENTER);
        Application.processing.background(255);
        splash.draw();

        int xLocation = Application.processing.width / 2;
        int yLocation = Application.processing.height / 2;

        counter += 0.1;
        Application.processing.pushMatrix();
        Application.processing.translate(xLocation, yLocation);
        Application.processing.rotate((float) (counter * Application.processing.TWO_PI / 360));
        planet.draw();
        Application.processing.popMatrix();

        MILCONOMY.draw();
        welcomeTo.draw();

        buttonToNextSlide.draw();

        if (buttonToNextSlide.overElement()) {
            buttonToNextSlide.setColorRect(Application.mainColorOne.brighter());
        } else {
            buttonToNextSlide.setColorRect(Color.decode("#D5E8ED"));
        }

    }
}
