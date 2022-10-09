public class Headlamp extends Lamp implements checkable{

    public Headlamp(String colorLamp, int powerLamp) {
        super(colorLamp, powerLamp);
        this.colorLamp = "white";
    }

    @Override
    protected void turnOnInternal() {
        System.out.println("включена фара");
    }

    @Override
    protected void turnOffInternal() {
        System.out.println("выключена фара");
    }

    @Override
    public void chek() {
        System.out.println("Проверка фары: Ок");
    }
}
