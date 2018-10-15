package date1015;

public class NumberOf1Between1AndN {

    public static int Number(int n) {
        int number = 0;

        for (int i = 1; i <= n; i++) {
            number += NumberOf1(i);
        }
        return number;
    }

    public static int NumberOf1(int n) {
        int number = 0;
        while (n != 0) {
            if (n % 10 == 1) {
                number++;
            }
            n = n / 10;
        }
        return number;
    }

    public static void main(String[] args) {
        int nuber = 12;
        System.out.println(Number(nuber));
    }
}
