import java.util.List;

/*
База/рама легкового автомобиля, куда навешиваются все остальные узлы и агрегаты автомобиля
 */
public class Base {
    // двигатель
    private Engine engine;
    // колесо 1
    private Wheel wheel1;
    // колесо 2
    private Wheel wheel2;
    // колесо 3
    private Wheel wheel3;
    // колесо 4
    private Wheel wheel4;
    // трансмиссия
    private Transmission transmission;
    private Door door1;
    private Door door2;
    private Door door3;
    private Door door4;
    private Door door5;
    private EnergyStorage energyStorage;
    private Steering steering;
    private Conditionering conditioner;
    private List<checkable> checkables;

    public Base() {
        engine = new ElectricEngine();
        wheel1 = new Wheel();
        wheel2 = new Wheel();
        wheel3 = new Wheel();
        wheel4 = new Wheel();
        transmission = new MechanicalTransmission();
        door1 = new Door();
        door2 = new Door();
        door3 = new Door();
        door4 = new Door();
        door5 = new Door();
        energyStorage = new ElectricEnergyStorage("electric battery");
        steering = new Steering();
        conditioner = new Conditionering();
        checkables = List.of(engine, wheel1, wheel2, wheel3, wheel4, transmission, door1, door2, door3, door4, door5, energyStorage, steering, conditioner);

    }

    public void start() {
        engine.start();
        if (energyStorage.getCapacity() == 0) {
            energyStorage.setCapacity(20);
        }
    }

    public void drive () {
        if (engine.getWork()) {
            transmission.switchGear(1);
            wheel1.rotate();
            wheel2.rotate();
            wheel3.rotate();
            wheel4.rotate();
        }
    }

    public void stop() {
        engine.stop();
    }

    public static void main(String[] args) {
        Base base = new Base();
        base.checkAll();
        base.start();
        base.drive();
        base.stop();
    }

    public void checkAll() {
        for (checkable chek: checkables) {
            chek.chek();
        }
    }
}
