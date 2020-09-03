package de.milkonomy.slides;

import de.milkonomy.app.Application;
import de.milkonomy.countries.CountyDb;
import de.milkonomy.elements.Button;
import de.milkonomy.elements.Image;
import de.milkonomy.elements.Text;
import de.milkonomy.models.Country;
import de.milkonomy.models.CountryPoint;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorldInfoSlide implements Slideable {

    private Image worldMap;
    private Button backFromWorldMap;
    private List<CountryPoint> points;
    private Text milconomy;

    public List<CountryPoint> getPoints() {
        return points;
    }

    public Button getBackFromWorldMap() {
        return backFromWorldMap;
    }

    public void draw() {
        Application.processing.background(worldMap.getImage());
        backFromWorldMap.draw();
        if (backFromWorldMap.overElement()) {
            backFromWorldMap.setColorRect(backFromWorldMap.getColorRect().brighter());
        } else {
            backFromWorldMap.setColorRect(Color.decode("#D5E8ED"));
        }

        for (CountryPoint point : points) {
            point.draw();
            if (point.overElement()) {
                point.drawTitle();
            }
        }

        milconomy.draw();
    }

    public WorldInfoSlide() {
        setup();
    }

    public void setup() {
        worldMap = new Image(Application.processing.width / 2, Application.processing.height / 2, Application.processing.loadImage("maps/WorldMap.png"));
        worldMap.resize(Application.processing.width, Application.processing.height);
        backFromWorldMap = new Button.Builder()
                .setX(Application.processing.width / 14 / 2 - 7)
                .setY(Application.processing.height / 12)
                .setWidth(Application.processing.width / 14)
                .setHeight(Application.processing.height / 12)
                .setColorText(Color.white)
                .setColorRect(Color.decode("#D5E8ED"))
                .setFont(Application.processing.createFont(Application.mainFont, Application.processing.height / 28))
                .setImage(Application.processing.loadImage("Arrow.png"))
                .build();

        points = new ArrayList<>();

        this.milconomy = new Text.Builder("milconomy".toUpperCase())
                .color(Color.decode("#EDF7F9"))
                .font(Application.processing.createFont(Application.mainFont + " Bold", 46))
                .textAlign(Application.processing.CENTER)
                .build();
        milconomy.setX(Application.processing.width - milconomy.getWidth() / 2 + milconomy.getHeight() / 3);
        milconomy.setY(Application.processing.height / 20 + milconomy.getHeight() / 2);

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("UK"), (int)(Application.processing.width / 2.25),(int)(Application.processing.height / 4.51)));
        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Germany"), (int)(Application.processing.width / 2.08),(int)(Application.processing.height / 4.41)));
        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Switzerland"), (int)(Application.processing.width / 2.14),(int)(Application.processing.height / 3.91)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Spain"), (int)(Application.processing.width / 2.34),(int)(Application.processing.height / 3.25)));
        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Morocco"), (int)(Application.processing.width / 2.39),(int)(Application.processing.height / 2.66)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Ukraine"), (int)(Application.processing.width / 1.77),(int)(Application.processing.height / 3.69)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Russia"), (int)(Application.processing.width / 1.48),(int)(Application.processing.height / 4.59)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Egypt"), (int)(Application.processing.width / 1.86),(int)(Application.processing.height / 2.45)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Pakistan"), (int)(Application.processing.width / 1.52),(int)(Application.processing.height / 2.56)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("India"), (int)(Application.processing.width / 1.43),(int)(Application.processing.height / 2.2)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("China"), (int)(Application.processing.width / 1.31),(int)(Application.processing.height / 2.67)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Japan"), (int)(Application.processing.width / 1.15),(int)(Application.processing.height / 3.06)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Seychelles"), (int)(Application.processing.width / 1.56),(int)(Application.processing.height / 1.69)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Australia"), (int)(Application.processing.width / 1.128),(int)(Application.processing.height / 1.34)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Venezuela"), (int)(Application.processing.width / 4.13),(int)(Application.processing.height / 1.94)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("USA"), (int)(Application.processing.width / 8.08),(int)(Application.processing.height / 2.71)));

        points.add(new CountryPoint(CountyDb.getInstance().counties.get("Canada"), (int)(Application.processing.width / 5.62),(int)(Application.processing.height / 3.84)));
    }

}
