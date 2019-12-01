package homework.visitorTask;

import java.awt.*;
import java.util.ArrayList;

public class Rectangle extends Figure {

    public Rectangle(ArrayList<Point> points)
    {
        pointArray = points;
        name = "Rectangle";
        numOfPoints = 4;
    }

    @Override
    public void accept(FigureVisitor visitor) {
        visitor.visit(this);
    }
}
