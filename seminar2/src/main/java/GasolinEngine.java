public class GasolinEngine extends Engine{
    @Override
    protected void startInternal() {
        System.out.println("Бензиновый двигатель запущен");
    }

    @Override
    protected void stopInternal() {
        System.out.println("Бензиновый двигатель остановлен");
    }

    @Override
    protected void throttleUpInternal(int level) {
        System.out.printf("Дросель открыт %d%n", level);
    }

    @Override
    public void chek() {
        System.out.println("Бензиновый двигатель: Ок");
    }
}
