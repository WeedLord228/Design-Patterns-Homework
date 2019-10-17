package homework.abstractFactoryTask;

public interface CarFactory {
    CarBody CreateBody();
    CarEngine CreateEngine();
    CarTransmisson CreateTransmisson();
    CarWheel CreateWheel();
}
