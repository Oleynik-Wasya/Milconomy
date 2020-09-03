package de.milkonomy.slides;

import de.milkonomy.app.Application;
import de.milkonomy.countries.CountyDb;
import de.milkonomy.elements.Map;
import de.milkonomy.elements.Text;
import de.milkonomy.models.CompareBlock;
import de.milkonomy.models.Country;
import de.milkonomy.elements.Button;

import java.awt.*;

public class CompareSlide implements Slideable {
    private CompareBlock worstCountryBlock;
    private CompareBlock bestCountryBlock;
    private CompareBlock countryBlock;

    private Map compareMap;

    private Text title;

    private Button back;

    private Text milconomy;

    public CompareSlide(Country country) {
        if (country.equals(CountyDb.getInstance().counties.get("Pakistan"))) {
            this.countryBlock = new CompareBlock(country, (int) (Application.processing.width / 1.5), (int) (Application.processing.height / 1.9), Application.mainColorOne);
            this.bestCountryBlock = new CompareBlock(CountyDb.getInstance().counties.get("Switzerland"), this.countryBlock.getX() + (int)(Application.processing.width / 6.76), this.countryBlock.getY(), Color.decode("#CCCCCC"));
            this.countryBlock.defineLiquid(country.getCostsOfLivingIndex() / (bestCountryBlock.getCountry().getCostsOfLivingIndex() / 100));

        } else if (country.equals(CountyDb.getInstance().counties.get("Switzerland"))) {

            this.countryBlock = new CompareBlock(country, (int) (Application.processing.width / 1.5), (int) (Application.processing.height / 1.9), Application.mainColorOne);
            this.worstCountryBlock = new CompareBlock(CountyDb.getInstance().counties.get("Pakistan"), this.countryBlock.getX() + (int)(Application.processing.width / 6.76), this.countryBlock.getY(), Color.decode("#CCCCCC"));
            this.worstCountryBlock.defineLiquid(worstCountryBlock.getCountry().getCostsOfLivingIndex() / (countryBlock.getCountry().getCostsOfLivingIndex() / 100));

        } else {

            this.countryBlock = new CompareBlock(country, (int) (Application.processing.width / 1.36), (int) (Application.processing.height / 1.8), Application.mainColorOne);
            this.worstCountryBlock = new CompareBlock(CountyDb.getInstance().counties.get("Pakistan"), this.countryBlock.getX() + (int)(Application.processing.width / 6.76), this.countryBlock.getY(), Color.decode("#CCCCCC"));
            this.bestCountryBlock = new CompareBlock(CountyDb.getInstance().counties.get("Switzerland"), this.countryBlock.getX() - (int)(Application.processing.width / 6.76), this.countryBlock.getY(), Color.decode("#CCCCCC"));
            this.countryBlock.defineLiquid(country.getCostsOfLivingIndex() / (bestCountryBlock.getCountry().getCostsOfLivingIndex() / 100));
            this.worstCountryBlock.defineLiquid(0.);
        }

        if (country.equals(CountyDb.getInstance().counties.get("Pakistan"))) {
            this.compareMap = new Map((int)(Application.processing.width / 3.77),
                    (int)(Application.processing.height / 2),
                    country.getCompareMap().getImage());
            this.title = new Text.Builder("comparison to the cheapest and the\n most expensive country to live")
                    .color(Application.mainColorOne)
                    .textLeading(Application.processing.height / 25)
                    .font(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 30))
                    .x((int) (Application.processing.width / 1.33))
                    .y(Application.processing.height / 5)
                    .build();
        } else if (country.equals(CountyDb.getInstance().counties.get("Switzerland"))) {
            this.compareMap = new Map((int)(Application.processing.width / 3.77),
                    Application.processing.height / 2,
                    country.getCompareMap().getImage());
            this.title = new Text.Builder("comparison to the cheapest and the\n most expensive country to live")
                    .color(Application.mainColorOne)
                    .textLeading(Application.processing.height / 25)
                    .font(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 30))
                    .x((int) (Application.processing.width / 1.33))
                    .y(Application.processing.height / 5)
                    .build();
        } else {
            this.compareMap = new Map((int)(Application.processing.width / 3.77),
                    Application.processing.height / 2,
                    country.getCompareMap().getImage());

            this.title = new Text.Builder("comparison to the cheapest and the\n most expensive country to live")
                    .color(Application.mainColorOne)
                    .textLeading(Application.processing.height / 25)
                    .font(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 30))
                    .x(countryBlock.getX())
                    .y(Application.processing.height / 5)
                    .build();
        }

        this.back = new Button.Builder()
                .setWidth(Application.processing.width / 14)
                .setHeight(Application.processing.height / 12)
                .setColorText(Color.white)
                .setColorRect(Color.decode("#D5E8ED"))
                .setFont(Application.processing.createFont("Roboto Bold", Application.processing.height / 28))
                .setImage(Application.processing.loadImage("Arrow.png"))
                .build();
        back.setX(back.getWidth() / 2 - 7);
        back.setY(back.getHeight());

        this.milconomy = new Text.Builder("milconomy".toUpperCase())
                .color(Color.decode("#EDF7F9"))
                .font(Application.processing.createFont(Application.mainFont + " Bold", 46))
                .textAlign(Application.processing.CENTER)
                .build();
        milconomy.setX(Application.processing.width - milconomy.getWidth() / 2 + milconomy.getHeight() / 3);
        milconomy.setY(Application.processing.height / 20 + milconomy.getHeight() / 2);
    }

    public Country getCounty() {
        return countryBlock.getCountry();
    }

    public Button getBack() {
        return back;
    }

    @Override
    public void draw() {
        Application.processing.background(255);

        back.draw();

        if (worstCountryBlock != null) {
            worstCountryBlock.draw();
        }

        if (countryBlock != null) {
            countryBlock.draw();
        }

        if (bestCountryBlock != null) {
            bestCountryBlock.draw();
        }

        if (back.overElement()) {
            back.setColorRect(Application.mainColorOne.brighter());
        } else {
            back.setColorRect(Color.decode("#D5E8ED"));
        }

        compareMap.draw();

        title.draw();

        milconomy.draw();
    }
}
