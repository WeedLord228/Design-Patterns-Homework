package homework.abstractFactoryTask;

public class BMWFactory implements CarFactory {

    public CarBody CreateBody() {
        return new BMWBody();
    }


    public CarEngine CreateEngine() {
        return new BMWEngine();
    }


    public CarTransmisson CreateTransmisson() {
        return new BMWTransmisson();
    }


    public CarWheel CreateWheel() {
        return new BMWWheel();
    }
}
