public class Door implements checkable {
    // открыта или закрыта дверь
    private boolean close;

    public void closeDoor() {
        this.close = true;
        System.out.println("Дверь закрыта");
    }

    public boolean isClose() {
        return close;
    }

    public void openDoor(int numberDoor) {
        this.close = false;
        System.out.printf("Дверь %d открыта %n", numberDoor);
    }

    @Override
    public void chek() {
        System.out.println("Дверь: Ок");
    }
}
