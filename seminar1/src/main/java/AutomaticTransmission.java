public class AutomaticTransmission extends Transmission{

    public AutomaticTransmission() {
        setTransmission();
    }

    @Override
    protected void setTransmission() {
        this.type = typeTransmission.automatic;
    }

    @Override
    protected void switchGearInternal(int number) {
        if (number > 0) {
            System.out.printf("Переключение селектора на D %n");
        } else if (number < 0) {
            System.out.printf("Переключение селектора на R %n");
        } else {
            System.out.printf("Переключение селектора на P %n");
        }
    }

    @Override
    public void chek() {
        System.out.println("Автоматическая трансмиссия: Ок %n");
    }
}
