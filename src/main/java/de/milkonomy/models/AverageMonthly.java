package de.milkonomy.models;

import de.milkonomy.app.Application;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

public class AverageMonthly {
    private PImage coin100;
    private PImage coin75;
    private PImage coin50;
    private PImage coin25;
    private PImage coin0;

    private int x;
    private int y;
    private int monthlyIncome;
    private Double countOfCoinsIn100 = 12.;
    private Double inOneCoin = 100. / countOfCoinsIn100;
    private int verticalMargin = 3;
    private int horizontalMargin = 2;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return (Application.processing.loadImage("coins/coin0%.png").height + verticalMargin) * countOfCoinsLine();
    }

    public AverageMonthly(int x, int y, int difference) {
        this.x = x;
        this.y = y;
        this.monthlyIncome = 100 + difference;
        coin0 = Application.processing.loadImage("coins/coin0%.png");
        coin25 = Application.processing.loadImage("coins/coin25%.png");
        coin50 = Application.processing.loadImage("coins/coin50%.png");
        coin75 = Application.processing.loadImage("coins/coin75%.png");
        coin100 = Application.processing.loadImage("coins/coin100%.png");
    }

    private List<PImage> getBottlesStructure() {
        List<PImage> bottles = new ArrayList<PImage>();
        int countOfFullBottle = (int) (monthlyIncome / inOneCoin);
        int typeOfNotFullBottle = getFracOfDouble(monthlyIncome / inOneCoin);

        if (monthlyIncome <= 100) {
            for (int i = 0; i < countOfFullBottle; i++) {
                bottles.add(this.coin100);
            }
            bottles.add(getTypeOfBottle(typeOfNotFullBottle));
            for (int i = 0; i < countOfCoinsIn100 - countOfFullBottle - 1; i++) {
                bottles.add(this.coin0);
            }
        } else {
            countOfFullBottle = countOfFullBottle - 12;
            for (int i = 0; i < countOfFullBottle; i++) {
                bottles.add(this.coin100);
            }
            if (!getTypeOfBottle(typeOfNotFullBottle).equals(this.coin0)) {
                bottles.add(getTypeOfBottle(typeOfNotFullBottle));
            }
        }

        while (bottles.size() > 24) {
            bottles.remove(bottles.size() - 1);
        }

        return bottles;
    }

    public void draw() {
        List<PImage> bottlesStructure = getBottlesStructure();
        if (monthlyIncome >= 100) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 2; j++) {
                    Application.processing.image(this.coin100, this.x + i * (this.coin100.width + horizontalMargin), this.y + j * (this.coin100.height + verticalMargin));
                }
            }
            int i = 0;
            int j = 0;
            for (PImage image : bottlesStructure) {
                Application.processing.image(image, this.x + i * (image.width + horizontalMargin), this.y + verticalMargin + (coin0.height + verticalMargin) * (2 + j));
                i++;
                if (i == 6) {
                    i = 0;
                    j++;
                }
            }

        } else {
            int i = 0;
            int j = 0;
            for (PImage image : bottlesStructure) {
                Application.processing.image(image, this.x + i * (image.width + horizontalMargin), this.y + j * (image.height + verticalMargin));
                i++;
                if (i == 6) {
                    i = 0;
                    j++;
                }
            }
        }
    }

    private PImage getTypeOfBottle(int value) {
        int absoluteValue = Math.abs(value);
        if (absoluteValue > 10 && absoluteValue <= 35) {
            return this.coin25;
        } else if (absoluteValue > 35 && absoluteValue <= 65) {
            return this.coin50;
        } else if (absoluteValue > 65 && absoluteValue < 85) {
            return this.coin75;
        } else if (absoluteValue >= 85) {
            return this.coin100;
        }

        if (value <= 0) {
            return this.coin0;
        } else {
            return this.coin100;
        }
    }

    private int getFracOfDouble(Double value) {
        int res = value.intValue(); //целая часть
        double res2 = value - res; //дробная часть
        return (int) (res2 * 100);
    }

    public int countOfCoinsLine() {
        if (monthlyIncome <= 100) {
            return 2;
        } else {
            int res = (int) Math.ceil(monthlyIncome / 50.);
            if (res > 6) {
                res = 6;
            }
            return res;

        }
    }

    public static int countOfCoinsLine(int monthlyIncome) {
        if (monthlyIncome <= 100) {
            return 2;
        } else {
            int res = (int) Math.ceil(monthlyIncome / 50.);
            if (res > 6) {
                res = 6;
            }
            return res;

        }
    }
}
