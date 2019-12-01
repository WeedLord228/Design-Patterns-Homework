package homework.visitorTask;

public class CircleInVisitor implements FigureVisitor {
    @Override
    public String getOperationName()
    {
        return "Вписывание круга";
    }

    @Override
    public void visit(Rectangle figure) {
        System.out.println("Вписан круг в прямоугольник");
    }

    @Override
    public void visit(Triangle figure) {
        System.out.println("Вписан круг в треугольник");
    }

    @Override
    public void visit(Pentagon figure) {
        System.out.println("Вписан круг в пятиугольник");
    }

}
