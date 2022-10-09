import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число N случайных целых чисел: ");
        try {
            int n = scanner.nextInt();
            NumberRandom numberRandom = new NumberRandom(n);
            for (Integer ni: numberRandom) {
                System.out.println(ni);
            }
        } catch (Exception e) {
            System.out.println("Введено не целое число");
            System.out.println(e.getLocalizedMessage());
        }

    }
}
