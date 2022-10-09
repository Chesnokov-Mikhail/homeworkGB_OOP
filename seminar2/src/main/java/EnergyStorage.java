// емкость хранения топлива для двигателя
public abstract class EnergyStorage implements checkable {
    // количество имеющегося топлива для двигателя
    private int capacity;
    // тип топлива
    private String fuelType;

    public EnergyStorage(String fuelType) {
        this.fuelType = fuelType;
        this.setCapacity(0);
    }

    // возвращает объем имеющегося топлива для двигателя
    public int getCapacity() {
        return this.capacity;
    }

    // заправка топливом для двигателя
    public void setCapacity(int capacity) {
        this.capacity = capacity;
        setCapacityInternal(capacity);
    }

    protected abstract void setCapacityInternal(int capacity);

    // тип топлива используемого в двигателе
    public String getFuelType() {
        return fuelType;
    }

}
