package homework.visitorTask;

import java.awt.*;
import java.util.ArrayList;

public abstract class Figure {
    protected ArrayList<Point> pointArray;
    protected Integer numOfPoints;
    protected String name;

    public ArrayList<Point> getPointArray() {
        return pointArray;
    }

    public void setPointArray(ArrayList<Point> pointArray) {
        this.pointArray = pointArray;
    }

    public abstract void accept(FigureVisitor visitor);
}
