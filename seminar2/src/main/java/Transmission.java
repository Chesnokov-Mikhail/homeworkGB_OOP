public abstract class Transmission implements checkable {
    // номер текущей передачи
    private int grNumber = 0;
    // тип трансмисии
    enum typeTransmission {
        mechanical,
        automatic
    }

    protected typeTransmission type;

    protected abstract void setTransmission();

    public void switchGear (int number) {
        this.grNumber = number;
        switchGearInternal(number);
    }

    protected abstract void switchGearInternal(int number);

    public int getGrNumber() {
        return grNumber;
    }

}
