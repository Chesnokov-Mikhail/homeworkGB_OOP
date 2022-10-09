import java.util.Iterator;
import java.util.Random;

public class NumberRandom implements Iterable<Integer> {

    // количество N чисел
    private int number;

    public NumberRandom(int number) {
        this.number = number;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int count = 0;
            Random ri = new Random();
            @Override
            public boolean hasNext() {
                return count < number;
            }

            @Override
            public Integer next() {
                count++;
                return ri.nextInt();
            }
        };
    }
}
