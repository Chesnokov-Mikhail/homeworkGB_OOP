public class Person implements Comparable<Person> {
    String name;
    int age;
    int weight;
    int height;

    public Person(String name, int age, int weight, int height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareToIgnoreCase(o.name);
    }
}
