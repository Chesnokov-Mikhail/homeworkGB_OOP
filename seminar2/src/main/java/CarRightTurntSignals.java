// Правый Автомобильный поворотник
public class CarRightTurntSignals extends Lamp implements checkable{    @Override

    protected void turnOnInternal() {
    System.out.println("Включен правый поворотник");
}

    @Override
    protected void turnOffInternal() {
        System.out.println("Выключен правый поворотник");
    }

    @Override
    public void chek() {
        System.out.println("Правый поворотник: ОК");
    }

    public CarRightTurntSignals(int powerLamp) {
        super(powerLamp);
        this.colorLamp = "yellow";
    }
}
