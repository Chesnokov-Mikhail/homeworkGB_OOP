/*
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
 поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и
 вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
 которую подадут в compare в качестве параметра, true - если их веса равны,
 false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в
 другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
  соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты,
   которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
 */
import java.util.ArrayList;

public class generics {

    public static void main(String[] args) {
        // Заполняем 1 коробку Apple
        Box<Apple> fruitsApple1 = new Box(new ArrayList());
        for (int i=0; i<6; i++) {
            fruitsApple1.addFruits(new Apple());
        }
        System.out.println(fruitsApple1);
        // Заполняем коробку Orange
        Box<Orange> fruitsOrange1 = new Box(new ArrayList());
        for (int i=0; i<4; i++) {
            fruitsOrange1.addFruits(new Orange());
        }
        System.out.println(fruitsOrange1);
        // Заполняем 2 коробку Apple
        Box<Apple> fruitsApple2 = new Box(new ArrayList());
        for (int i=0; i<3; i++) {
            fruitsApple2.addFruits(new Apple());
        }
        System.out.println(fruitsApple2);

        // Сравнение коробок
        Boolean compareBox2 = fruitsApple1.compare(fruitsOrange1);
        System.out.println(compareBox2); // True
        Boolean compareBox1 = fruitsApple1.compare(fruitsApple2);
        System.out.println(compareBox1); // False

        // Пересыпаем фрукты из одной коробки в другую
        moveSomeFruits(fruitsApple1, fruitsApple2);
//        moveSomeFruits(fruitsApple1, fruitsOrange1); // Не будет компилироваться
        System.out.println(fruitsApple1); // пусто
        System.out.println(fruitsApple2); // + Apple из fruitsApple1

    }
    // Перекладываем фрукты из одной коробки в другую
    public static <T extends Fruit> void moveSomeFruits(Box<? extends T> source, Box<? super T> dest) {
        while (source.getFruits().size() > 0) {
            dest.addFruits(source.pop());
        }
    }
}
