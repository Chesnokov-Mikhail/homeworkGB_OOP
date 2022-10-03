// двигатель автомобиля
public abstract class Engine implements checkable {
    // состояние двигателя. true - работает; false - не работает
    private Boolean work;

    // запуск двигателя
    public void start () {
        this.work = true;
        startInternal();
    }

    protected abstract void startInternal();
    public void stop () {
        this.work = false;
        stopInternal();
    }

    protected abstract void stopInternal();

    public void throttleUp(int level) {
        if (this.work) {
            throttleUpInternal(level);
        }
    }

    protected abstract void throttleUpInternal(int level);

    public Boolean getWork() {
        return work;
    }

}
