package homework.visitorTask;

import java.awt.*;
import java.util.ArrayList;

public class Pentagon extends Figure {
    public Pentagon(ArrayList<Point> points)
    {
        pointArray = points;
        name = "Pentagon";
        numOfPoints = 5;

    }

    @Override
    public void accept(FigureVisitor visitor) {
        visitor.visit(this);
    }
}
