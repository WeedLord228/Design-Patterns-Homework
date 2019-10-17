package homework.abstractFactoryTask;

public class AudiFactory implements CarFactory {

    public CarBody CreateBody() {
        return new AudiBody();
    }

    public CarEngine CreateEngine() {
        return new AudiEngine();
    }

    public CarTransmisson CreateTransmisson() {
        return new AudiTransmission();
    }

    public CarWheel CreateWheel() {
        return new AudiWheel();
    }
}
