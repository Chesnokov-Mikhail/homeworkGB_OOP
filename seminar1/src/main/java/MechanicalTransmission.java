public class MechanicalTransmission extends Transmission implements checkable{

    public MechanicalTransmission() {
        this.setTransmission();
    }

    @Override
    protected void setTransmission() {
        this.type = typeTransmission.mechanical;
    }

    @Override
    protected void switchGearInternal(int number) {
        System.out.printf("Переключение скорости на %d%n", number);
    }

    @Override
    public void chek() {
        System.out.println("Механическая трансмиссия: Ок");
    }
}
