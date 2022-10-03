// Рулевое управление автомобилем
public class Steering implements checkable {

    // угол поворота рулевого колеса
    private int degreOfRotation = 0;

    public void leftDrive(int degre) {
        this.degreOfRotation += degre;
        System.out.printf("Поворачиваем руль налево на %d градусов %n", degre);
    }

    public void rightDrive(int degre) {
        this.degreOfRotation -= degre;
        System.out.printf("Поворачиваем руль направо на %d градусов %n", degre);
    }

    public int getDegreOfRotation() {
        return degreOfRotation;
    }

    @Override
    public void chek() {
        System.out.println("Рулевое управление: Ок");
    }
}
