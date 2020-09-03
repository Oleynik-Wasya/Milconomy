package de.milkonomy.models;

import de.milkonomy.app.Application;
import de.milkonomy.elements.Element;
import de.milkonomy.elements.Image;
import de.milkonomy.elements.Text;
import processing.core.PConstants;

public class CountryPoint implements Element {

    private Image image;
    private Country country;
    private Text title;

    public Country getCountry() {
        return country;
    }

    public Text getTitle() {
        return this.title;
    }

    public CountryPoint(Country country, int x, int y) {
        this.image = new Image(x, y, Application.processing.loadImage("PointOnMap.png"));
        this.country = country;
        this.title = new Text.Builder(country.getName())
                .x(x)
                .y(y)
                .font(Application.processing.createFont(Application.mainFont, 24))
                .color(Application.mainColorTwo)
                .build();
    }

    public void drawTitle() {
        int titleY = this.title.getY() - this.image.getHeight() / 2;
        Application.processing.noStroke();
        Application.processing.textAlign(PConstants.CENTER, PConstants.CENTER);
        Application.processing.textFont(Application.processing.createFont(Application.mainFont, 24));
        Application.processing.fill(255);
        Application.processing.rect(this.title.getX(), titleY, this.title.getWidth() + this.title.getWidth() / 5, this.title.getHeight() * 1.5f, 5);
        Application.processing.fill(Application.mainColorOne.getRGB());
        Application.processing.text(this.title.getText(), this.title.getX(), titleY - this.title.getHeight() / 3);
    }

    public Image getImage() {
        return image;
    }

    public int getWidth() {
        return image.getImage().width;
    }

    public int getHeight() {
        return image.getImage().height;
    }

    public int getX() {
        return image.getX();
    }

    public int getY() {
        return image.getY();
    }

    public void draw() {
        image.draw();
    }
}
