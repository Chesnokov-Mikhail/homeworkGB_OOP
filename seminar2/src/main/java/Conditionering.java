// Кондиционер
public class Conditionering implements checkable {
    // состояние кондиционера, работает или не работает
    private boolean work;
    private int levelCooling = 0;

    public boolean isWork() {
        return work;
    }

    public void startСonditionering(int level) {
        if (!this.isWork()) {
            this.work = true;
            this.levelCooling = level;
            System.out.println("Кондиционер включен");
        }
    }

    public void setLevelCooling(int levelCooling) {
        if (this.isWork()) {
            this.levelCooling = levelCooling;
        } else {
            System.out.println("Включите кондиционер для установки уровня охолождения");
        }
    }

    public int getLevelCooling() {
        return levelCooling;
    }

    public void stopСonditionering() {
        if (this.isWork()) {
            this.work = false;
            System.out.println("Кондиционер выключен");
            this.levelCooling = 0;
        }
    }

    @Override
    public void chek() {
        System.out.println("Кондиционер: Ок");
    }
}
