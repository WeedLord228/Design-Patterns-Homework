package homework.visitorTask;

import java.awt.*;
import java.util.ArrayList;

public class Triangle extends Figure {

    public Triangle(ArrayList<Point> points)
    {
        pointArray = points;
        name = "Triangle";
        numOfPoints = 3;
    }

    @Override
    public void accept(FigureVisitor visitor) {
        visitor.visit(this);
    }
}
