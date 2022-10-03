public class GasolinEnergyStorage extends EnergyStorage{

    public GasolinEnergyStorage(String fuelType) {
        super(fuelType);
    }

    @Override
    protected void setCapacityInternal(int capacity) {
        System.out.printf("Заправлено %d литров топлива %n", capacity);
    }

    @Override
    public void chek() {
        System.out.println("Бензобак: Ок");
    }
}
