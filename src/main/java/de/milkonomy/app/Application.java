package de.milkonomy.app;

import de.milkonomy.countries.CountyDb;
import de.milkonomy.elements.*;
import de.milkonomy.models.CountryPoint;
import de.milkonomy.slides.CompareSlide;
import de.milkonomy.slides.MainSlide;
import de.milkonomy.slides.InfoSlide;
import de.milkonomy.slides.WorldInfoSlide;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.*;

public class Application extends PApplet {

    public static PApplet processing;

    public static void main(String[] args) {
        PApplet.main("de.milkonomy.app.Application", args);
    }

    public static int WIDTH = 1366;
    public static int HEIGHT = 768;


    public void settings() {
        size(WIDTH, HEIGHT);
    }


    public static Color mainColorOne = Color.decode("#BCDEE6");
    public static Color mainColorTwo = Color.decode("#E0E0E0");
    public static String mainFont = "Century Gothic";

    PImage background;
    CountyDb db;

    public void setup() {
        shapeMode(CENTER);
        rectMode(CENTER);
        textAlign(CENTER, CENTER);
        imageMode(CENTER);

        background = loadImage("background.png");
        background.resize(width, height);

        processing = this;

        db = CountyDb.getInstance();

        mainSlide = new MainSlide();

        infoSlide = new InfoSlide(db.counties.get("Morocco"));

        worldInfoSlide = new WorldInfoSlide();

        compareSlide = new CompareSlide(db.counties.get("Germany"));
    }


    int slide = 1;

    public void draw() {
        switch (slide) {
            case 1:
                mainSlide();
                break;
            case 2:
                worldInfoSlide();
                break;
            case 3:
                infoSlide();
                break;
            case 4:
                compareSlide();
                break;
        }
    }

    MainSlide mainSlide;

    public void mainSlide() {
        mainSlide.draw();
    }

    InfoSlide infoSlide;

    public void infoSlide() {
        infoSlide.draw();
    }

    WorldInfoSlide worldInfoSlide;

    public void worldInfoSlide() {
        worldInfoSlide.draw();
    }

    CompareSlide compareSlide;

    public void compareSlide() {
        compareSlide.draw();
    }


    boolean overElement(Element element) {
        if (mouseX >= element.getX() - element.getWidth() / 2 && mouseX <= element.getX() + element.getWidth() / 2 &&
                mouseY >= element.getY() - element.getHeight() / 2 && mouseY <= element.getY() + element.getHeight() / 2) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void mousePressed() {
        if (overElement(mainSlide.getButtonToNextSlide()) && slide == 1) {
            slide = 2;
            worldInfoSlide = new WorldInfoSlide();
            return;
        }
        if (overElement(infoSlide.getBack()) && slide == 3) {
            slide = 2;
            worldInfoSlide = new WorldInfoSlide();
            return;
        }
        if (overElement(worldInfoSlide.getBackFromWorldMap()) && slide == 2) {
            slide = 1;
            mainSlide = new MainSlide();
            return;
        }
        if (overElement(infoSlide.getButtonCompare()) && slide == 3) {
            slide = 4;
            compareSlide = new CompareSlide(infoSlide.getCountry());
        }
        if (overElement(compareSlide.getBack()) && slide == 4) {
            slide = 3;
            infoSlide = new InfoSlide(compareSlide.getCounty());
        }

        for (CountryPoint point : worldInfoSlide.getPoints()) {
            if (overElement(point.getImage()) && slide == 2) {
                slide = 3;
                infoSlide = new InfoSlide(point.getCountry());
                return;
            }
        }
    }
}
