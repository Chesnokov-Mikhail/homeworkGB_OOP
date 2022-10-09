// автомобильная лампа
public class Headlamp extends Lamp implements checkable{

    // порядковый номер лампы
    private int numHead;

    public int getNumHead() {
        return numHead;
    }

    public Headlamp(int powerLamp, int numHead) {
        super(powerLamp);
        this.colorLamp = "white";
        this.numHead = numHead;
    }

    @Override
    protected void turnOnInternal() {
        System.out.println("включена фара номер " + Integer.toString(numHead));
    }

    @Override
    protected void turnOffInternal() {
        System.out.println("выключена фара номер " + Integer.toString(numHead));
    }

    @Override
    public void chek() {
        System.out.printf("Проверка фары номер %d: Ок %n", numHead);
    }
}
