import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box<T extends Fruit> {

    private ArrayList<? super T> fruits;

    public Box(ArrayList<? super T> fruits) {
        this.fruits = fruits;
    }

    public void addFruits(T fruit) {
        if (fruits.size() > 0) {
            // Проверяем что можем добавить тот же фрукт в коробку
            if (fruits.get(0).getClass().isInstance(fruit)) {
                this.fruits.add(fruit);
            } else System.out.println("нельзя положить " +
                    fruit.getClass().getName() +
                    " в коробку с " +
                    fruits.get(0).getClass().getName());
        }
        else this.fruits.add(fruit);
    }

    public ArrayList<? super T> getFruits() {
        return fruits;
    }
    // вытаскиваем фрукт из коробки
    public T pop() {
        if (this.fruits.size() > 0) {
            T fr = (T) this.fruits.remove((this.fruits.size() - 1));
            return fr;
        }
        return null;
    }

    // Считаем вес коробки
    public double getWeight() {
        double sum = 0.0f;
        for (int i = 0; i < this.fruits.size(); i++) {
                sum += ((T) this.fruits.get(i)).weight();
        }
        return sum;
    }
    // метод сравнивнения коробки
    public boolean compare(Box<? extends Fruit> o1) {
        if (Math.abs(o1.getWeight() - this.getWeight()) < 0.001)
            return true;
        return false;
    }

    @Override
    public String toString() {
        StringBuilder rez = new StringBuilder();
        rez.append("Box:\n");
        if(this.fruits.size() == 0) {
            rez.append("Коробка пуста.\n");
        } else {
            for (int i = 0; i < this.fruits.size(); i++) {
                rez.append(((T) this.fruits.get(i)).getName() + Integer.toString(i) + "\n");
            }
        }
        return rez.toString();
    }
}
