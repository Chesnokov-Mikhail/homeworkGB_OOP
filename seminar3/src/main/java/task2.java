import java.util.*;

public class task2 {
    public static void main(String[] args) {
        Random ri = new Random();
        String[] names = {"Анна", "Борис", "Федор", "Гульнар",
                        "Михаил", "Александр", "Альберт", "Еатерина",
                        "Ольга", "Сергей", "Петр", "Кирил"};
        ArrayList<Person> peoples = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            peoples.add(new Person(names[ri.nextInt(0, names.length -1)],
                    ri.nextInt(1, 99),
                    ri.nextInt(5, 120),
                    ri.nextInt(50, 210)));
        }
        System.out.println("Исходный массив");
        for (Person person: peoples) {
            System.out.println(person);
        }
        System.out.println("сортировать по возрасту, весу, росту");
        // Collections.sort(peoples);
        // сортировать по возрасту, весу, росту
        peoples.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (Integer.compare(o1.age, o2.age) == 0) {
                    if (Integer.compare(o1.weight, o2.weight) == 0) {
                        return Integer.compare(o1.height, o2.height);
                    }
                    return Integer.compare(o1.weight, o2.weight);
                }
                return Integer.compare(o1.age, o2.age);
            }
        });

        for (Person person: peoples) {
            System.out.println(person);
        }
        System.out.println("сортировать по имени, возрасту, росту");
        // сортировать по имени, возрасту, росту
        peoples.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.compareTo(o2) == 0) {
                    if (Integer.compare(o1.age, o2.age) == 0) {
                        return Integer.compare(o1.height, o2.height);
                    }
                    return Integer.compare(o1.age, o2.age);
                }
                return o1.compareTo(o2);
            }
        });

        for (Person person: peoples) {
            System.out.println(person);
        }
        System.out.println("сортировать по имени, росту, весу");
        // сортировать по имени, росту, весу
        peoples.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.compareTo(o2) == 0) {
                    if (Integer.compare(o1.height, o2.height) == 0) {
                        return Integer.compare(o1.weight, o2.weight);
                    }
                    return Integer.compare(o1.height, o2.height);
                }
                return o1.compareTo(o2);
            }
        });

        for (Person person: peoples) {
            System.out.println(person);
        }

    }
}
