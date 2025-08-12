import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumbers {

    private boolean is_prime_number(int number) {
        int divisor = number - 1;

        while (true) {
            if (number % divisor == 0) {
                if (divisor == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                divisor--;
            }
        }
    }

    private int[] compute(int number) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 2; i <= number; i++) {
            if (this.is_prime_number(i)) {
                arrayList.add(i);
            }
        }

        return arrayList.stream().mapToInt(t -> t).toArray();
    }

    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);

        System.out.printf("input number: %s\n", number);

        PrimeNumbers primeNumbers = new PrimeNumbers();
        int[] result = primeNumbers.compute(number);

        System.out.printf("prime numbers: %s\n", Arrays.toString(result));
    }
}
