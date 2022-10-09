// Левый Автомобильный поворотник
public class CarLeftTurntSignals extends Lamp implements checkable{

    @Override
    protected void turnOnInternal() {
        System.out.println("Включен левый поворотник");
    }

    @Override
    protected void turnOffInternal() {
        System.out.println("Выключен левый поворотник");
    }

    @Override
    public void chek() {
        System.out.println("Левый поворотник: ОК");
    }

    public CarLeftTurntSignals(int powerLamp) {
        super(powerLamp);
        this.colorLamp = "yellow";
    }
}
