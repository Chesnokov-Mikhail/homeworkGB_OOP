public class ElectricEnergyStorage extends EnergyStorage {

    public ElectricEnergyStorage(String fuelType) {
        super(fuelType);
    }

    @Override
    protected void setCapacityInternal(int capacity) {
        System.out.printf("Батарея заряжена на %d Ват %n", capacity);
    }

    @Override
    public void chek() {
        System.out.println("Электрическая батарея: Ок");
    }
}
