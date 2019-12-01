package homework.visitorTask;

public class DrawVisitor implements FigureVisitor {
    private int x;
    private int y;

    public DrawVisitor(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    @Override
    public String getOperationName() {
        return "Нарисовать фигуру с центром в точке" + x + " " + y;
    }

    @Override
    public void visit(Rectangle figure) {
        System.out.println("Нарисован прямоугольник с центром в точке" + x + " " + y);
    }

    @Override
    public void visit(Triangle figure) {
        System.out.println("Нарисован треугольник с центром в точке" + x + " " + y);
    }

    @Override
    public void visit(Pentagon figure) {
        System.out.println("Нарисован пятиугольник с центром в точке" + x + " " + y);
    }
}
