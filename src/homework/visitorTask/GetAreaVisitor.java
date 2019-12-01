package homework.visitorTask;

public class GetAreaVisitor implements FigureVisitor {
    @Override
    public String getOperationName() {
        return "Посчитать площать фигуры";
    }

    @Override
    public void visit(Rectangle figure) {
        System.out.println("Посчитана плошадь прямоугольника");
    }

    @Override
    public void visit(Triangle figure) {
        System.out.println("Посчитана плошадь прямоугольника");
    }

    @Override
    public void visit(Pentagon figure) {
        System.out.println("Посчитана плошадь прямоугольника");
    }
}
