// Автомобильная фара/фонарь/поворотник
public abstract class Lamp implements checkable {
    // цвет
    protected String colorLamp;
    // мощность лампы
    private int powerLamp;
    // состояние включена или выключена
    private boolean enabled;

    public Lamp(int powerLamp) {
        this.powerLamp = powerLamp;
    }

    public Lamp(String colorLamp, int powerLamp) {
        this.colorLamp = colorLamp;
        this.powerLamp = powerLamp;
    }

    // включить
    public void turnOn(){
        this.enabled = true;
        turnOnInternal();
    }

    protected abstract void turnOnInternal();
    // выключить
    public void turnOff(){
        this.enabled = false;
        turnOffInternal();
    }

    protected abstract void turnOffInternal();

    public String getColorLamp() {
        return colorLamp;
    }

    public int getPowerLamp() {
        return powerLamp;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
