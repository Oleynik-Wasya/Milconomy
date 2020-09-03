package de.milkonomy.elements;

import de.milkonomy.app.Application;
import de.milkonomy.models.Point;

import java.awt.*;
import java.util.ArrayList;

public class Line {

    private int speed = 7;
    private boolean animated = false;
    private int strokeWeight;
    private Color color;
    private ArrayList<de.milkonomy.models.Point> points;

    public boolean isAnimated() {
        return animated;
    }

    public void setAnimated(boolean animated) {
        this.animated = animated;
    }

    static public class Builder {
        private int strokeWeight;
        private Color color;
        private boolean animated;

        public Builder setAnimated(boolean animated) {
            this.animated = animated;
            return this;
        }

        private ArrayList<de.milkonomy.models.Point> points;

        public Builder(int x, int y, int x2, int y2) {
            points = new ArrayList<de.milkonomy.models.Point>();
            points.add(new de.milkonomy.models.Point(x, y));
            points.add(new de.milkonomy.models.Point(x2, y2));
        }

        public Builder setStrokeWeight(int strokeWeight) {
            this.strokeWeight = strokeWeight;
            return this;
        }

        public Builder setColor(Color color) {
            this.color = color;
            return this;
        }

        public Line build() {
            Line line = new Line();
            line.points = this.points;
            line.color = this.color;
            line.strokeWeight = this.strokeWeight;
            line.animated = this.animated;

            return line;
        }
    }

    private Line() {
    }

    public de.milkonomy.models.Point getLastPoint() {
        return points.get(points.size() - 1);
    }

    public void addPoint(int x, int y) {
        points.add(new de.milkonomy.models.Point(x, y));
    }

    private boolean isOnDisplay = false;
    private boolean first = true;

    private int i = 0;
    private int j;

    private void animation() {
        if (!animated) {
            isOnDisplay = true;
        }
        if (!isOnDisplay) {
            if (first) {
                j = points.get(i).getX();
                first = false;
            }
            Application.processing.stroke(color.getRGB());
            Application.processing.strokeWeight(strokeWeight);
            if (i > 0) {
                for (int k = i; k > 0; k--) {
                    de.milkonomy.models.Point point = points.get(k);
                    de.milkonomy.models.Point nextPoint = points.get(k - 1);
                    Application.processing.line(point.getX(), point.getY(), nextPoint.getX(), nextPoint.getY());
                }
            }
            de.milkonomy.models.Point point = points.get(i);
            de.milkonomy.models.Point nextPoint = points.get(i + 1);
            Application.processing.line(point.getX(), point.getY(), j, (j - point.getX()) * (nextPoint.getY() - point.getY()) / (nextPoint.getX() - point.getX()) + point.getY());
            if (j >= nextPoint.getX()) {
                i++;
                if (!(i < points.size() - 1)) {
                    isOnDisplay = true;
                }
            }
            j += speed;
            return;
        }
    }

    public void draw() {
        animation();


        if (isOnDisplay) {
            for (int i = 0; i < points.size() - 1; i++) {
                Application.processing.stroke(color.getRGB());
                Application.processing.strokeWeight(strokeWeight);
                de.milkonomy.models.Point point = points.get(i);
                Point nextPoint = points.get(i + 1);
                Application.processing.line(point.getX(), point.getY(), nextPoint.getX(), nextPoint.getY());
            }
        }
    }
}
