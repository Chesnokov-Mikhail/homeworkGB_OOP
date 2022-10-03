public class ElectricEngine extends Engine implements checkable{

    @Override
    protected void startInternal() {
        System.out.println("Электродвигатель запущен");
    }

    @Override
    protected void stopInternal() {
        System.out.println("Электродвигатель остановлен");
    }

    @Override
    protected void throttleUpInternal(int level) {
        System.out.printf("Пусковой ток %d Ампер %n", level);
    }

    @Override
    public void chek() {
        System.out.println("Электродвигатель: Ок");
    }
}
