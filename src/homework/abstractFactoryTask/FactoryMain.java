package homework.abstractFactoryTask;

public class FactoryMain {

    public static void main(String[] args) {

        AudiFactory audiFactory = new AudiFactory();
        System.out.println("Автомобиль ауди");
        printParts(audiFactory);
        System.out.println();

        BMWFactory bmwFactory = new BMWFactory();
        System.out.println("Автомобиль BMW");
        printParts(bmwFactory);
        System.out.println();
    }

    public static void printParts(CarFactory factory) {
        System.out.println("Комплектующие автомобиля: ");
        System.out.println("---------------------------");

        CarBody body = factory.CreateBody();
        System.out.println(body.getName());

        CarEngine engine = factory.CreateEngine();
        System.out.println(engine.getName());

        CarWheel wheel = factory.CreateWheel();
        System.out.println(wheel.getName());

        CarTransmisson transmisson = factory.CreateTransmisson();
        System.out.println(transmisson.getName());
    }
}
