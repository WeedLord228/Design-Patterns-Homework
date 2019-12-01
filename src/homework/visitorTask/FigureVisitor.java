package homework.visitorTask;

public interface FigureVisitor {
    String getOperationName();
    void visit(Rectangle figure);
    void visit(Triangle figure);
    void visit(Pentagon figure);
}
