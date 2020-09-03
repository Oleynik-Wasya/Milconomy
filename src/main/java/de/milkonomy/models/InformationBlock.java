package de.milkonomy.models;

import de.milkonomy.app.Application;
import de.milkonomy.elements.Line;
import de.milkonomy.elements.Map;
import de.milkonomy.elements.Text;
import processing.core.PConstants;
import processing.core.PFont;

import java.awt.*;

public class InformationBlock {
    private Text countryName;
    private Text costsOfLivingIndex;
    private Text rank;
    private Text cost;
    private Text tax;
    private Text averageCitizen;
    private Color color;
    private int x;
    private int y;
    private int width;
    private PFont font;
    private Map map;
    public static int marginBetweenBlocks = Application.processing.height / 26;
    public static int margin = Application.processing.height / 26;
    private Line diviningLine;
    private Color backgroundColor;
    private int height;
    private Double taxAsValue;
    private AverageMonthly averageMonthly;
    private Text incomeText;
    private Text incomePercent;
    private Text incomeContinent;

    public int getHeight() {
        return height;
    }

    public Double getTax() {
        return taxAsValue;
    }

    public AverageMonthly getAverageMonthly() {
        return averageMonthly;
    }

    public static class Builder {
        private String countryName;
        private Double costsOfLivingIndex;
        private Integer rank;
        private Double cost;
        private Double tax;
        private Double monthlyIncome;
        private Color color;
        private int x;
        private int y;
        private int width;
        private PFont font;
        private Map map;
        private Color backgroundColor;
        private int monthlyIncomeDifference;
        private String continent;

        public Builder setContinent(String continent) {
            this.continent = continent;
            return this;
        }

        public Builder setMonthlyIncomeDifference(int value) {
            this.monthlyIncomeDifference = value;
            return this;
        }

        public Builder setBackgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setFont(PFont font) {
            this.font = font;
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

        public Builder setCountryName(String countryName) {
            this.countryName = countryName;
            return this;
        }

        public Builder setCostsOfLivingIndex(Double costsOfLivingIndex) {
            this.costsOfLivingIndex = costsOfLivingIndex;
            return this;
        }

        public Builder setRank(int rank) {
            this.rank = rank;
            return this;
        }

        public Builder setCost(Double cost) {
            this.cost = cost;
            return this;
        }

        public Builder setTax(Double tax) {
            this.tax = tax;
            return this;
        }

        public Builder setMonthlyIncome(Double monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
            return this;
        }

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder setMap(Map map) {
            this.map = map;
            return this;
        }

        public InformationBlock build() {

            if (countryName.equals("Japan")) {
                marginBetweenBlocks = Application.processing.height / 40;
            } else {
                marginBetweenBlocks = Application.processing.height / 26;
            }

            InformationBlock iB = new InformationBlock();
            iB.countryName = new Text.Builder(countryName.toUpperCase())
                    .color(color)
                    .font(Application.processing.createFont(font.getName() + " Bold", font.getSize()))
                    .x(x)
                    .y(y)
                    .build();
            iB.countryName.setAnimated(true);
            iB.countryName.setSpeed(3);

            iB.costsOfLivingIndex = new Text.Builder("Costs of living index - " + this.costsOfLivingIndex)
                    .color(Color.white)
                    .font(Application.processing.createFont(font.getName() + " Regular", (int) (font.getSize() * 0.375)))
                    .x(x)
                    .y(y + margin)
                    .build();
            iB.costsOfLivingIndex.setAnimated(true);
            iB.costsOfLivingIndex.setSpeed(5);

            iB.rank = new Text.Builder(this.rank + "th rank worldwide")
                    .color(color)
                    .font(Application.processing.createFont(font.getName() + " Bold", (int) (font.getSize() * 0.375)))
                    .x(x)
                    .y(iB.costsOfLivingIndex.getY() + margin)
                    .build();
            iB.rank.setAnimated(true);
            iB.rank.setSpeed(4);

            if (cost != null) {
                iB.cost = new Text.Builder("1 litre milk - " + this.cost + "€")
                        .color(color)
                        .font(Application.processing.createFont(font.getName() + " Bold", (int) (font.getSize() * 0.56)))
                        .x(x)
                        .y(y + margin * 4)
                        .build();
                iB.cost.setAnimated(true);
                iB.cost.setSpeed(4);
            }

            if (tax != null) {
                iB.tax = new Text.Builder(String.format("%.2f %% tax = %.2f €", this.tax, this.cost / 100 * this.tax))
                        .color(Application.mainColorTwo)
                        .font(Application.processing.createFont(font.getName() + " Bold", (int) (font.getSize() * 0.56)))
                        .x(x)
                        .y(iB.cost.getY() + (int) (margin))
                        .build();
                iB.tax.setAnimated(true);
                iB.tax.setSpeed(4);
            }

            if (this.monthlyIncome != null) {
                iB.diviningLine = new Line.Builder(this.x, iB.tax.getY() + marginBetweenBlocks, this.x + Application.processing.width / 6, iB.tax.getY() + marginBetweenBlocks)
                        .setStrokeWeight(2)
                        .setColor(color)
                        .setAnimated(true)
                        .build();
                iB.diviningLine.setAnimated(true);

                iB.averageCitizen = new Text.Builder(String.format("monthly income of the\naverage citizen -\n%.2f € =\n%.2f litre milk (tax incl)", this.monthlyIncome, this.monthlyIncome / this.cost))
                        .color(color)
                        .font(Application.processing.createFont(font.getName() + " Bold", (int) (font.getSize() * 0.56)))
                        .textLeading(21)
                        .x(x)
                        .y(iB.diviningLine.getLastPoint().getY() + (int) (marginBetweenBlocks * 1.5))
                        .build();
                iB.averageCitizen.setAnimated(true);
            }

            iB.color = this.color;
            iB.font = this.font;
            iB.x = this.x;
            iB.y = this.y;
            iB.width = this.width;
            iB.map = this.map;
            iB.backgroundColor = this.backgroundColor;
            iB.taxAsValue = this.tax;

            iB.height = iB.averageCitizen.getY() - this.y + iB.averageCitizen.getHeight();

            iB.averageMonthly = new AverageMonthly(this.x + Application.processing.loadImage("coins/coin0%.png").width / 2, this.y + iB.getHeight() + (int) (marginBetweenBlocks * 1.5), this.monthlyIncomeDifference);

            iB.incomePercent = new Text.Builder(Math.abs(this.monthlyIncomeDifference) + "% " + (this.monthlyIncomeDifference < 0 ? "<" : ">"))
                    .color(Application.mainColorOne)
                    .font(Application.processing.createFont(Application.mainFont + " Bold", Application.processing.height / 32))
                    .x(this.x)
                    .y(iB.averageMonthly.getY() + iB.averageMonthly.getHeight() + (int) (marginBetweenBlocks * 0.8))
                    .build();

            iB.incomeText = new Text.Builder(" average monthly")
                    .color(Application.mainColorOne)
                    .font(Application.processing.createFont(Application.mainFont + " Bold", 18))
                    .x(this.x + iB.incomePercent.getWidth())
                    .y(iB.incomePercent.getY())
                    .build();

            iB.incomeContinent = new Text.Builder("income in " + this.continent)
                    .color(Application.mainColorOne)
                    .font(Application.processing.createFont(Application.mainFont + " Bold", 18))
                    .x(this.x)
                    .y(iB.incomeText.getY() + iB.incomeText.getHeight() + iB.incomeText.getHeight() / 2)
                    .build();

            return iB;
        }
    }


    private InformationBlock() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public Line getDiviningLine() {
        return diviningLine;
    }

    public void draw() {
        Application.processing.textAlign(PConstants.LEFT);
        Application.processing.rectMode(PConstants.CORNER);
        if (backgroundColor != null) {
            Application.processing.fill(backgroundColor.getRGB());
            Application.processing.noStroke();
            Application.processing.rect(this.x - marginBetweenBlocks, this.y - this.countryName.getHeight() - marginBetweenBlocks, this.width, this.height);
        }
        if (map != null) {
            map.draw();
        }

        countryName.draw();

        Application.processing.noStroke();
        Application.processing.rect(costsOfLivingIndex.getX() - 5, costsOfLivingIndex.getY() - costsOfLivingIndex.getHeight() - 5, costsOfLivingIndex.getWidth() + 10, costsOfLivingIndex.getHeight() + 10, 1);
        costsOfLivingIndex.draw();

        rank.draw();

        if (cost != null) {
            cost.draw();
        }

        if (tax != null) {
            tax.draw();
        }

        if (averageCitizen != null) {
            diviningLine.draw();
            averageCitizen.draw();
        }

        averageMonthly.draw();

        incomeText.draw();

        incomePercent.draw();

        incomeContinent.draw();

        Application.processing.rectMode(Application.processing.CENTER);
        Application.processing.textAlign(Application.processing.CENTER, Application.processing.CENTER);
    }
}
