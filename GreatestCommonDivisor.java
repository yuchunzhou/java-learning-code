import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GreatestCommonDivisor {

    private int[] factors(int number) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                arrayList.add(i);
            }
        }

        return arrayList.stream().mapToInt(t -> t).toArray();
    }

    private int compute(int[] numbers) {
        HashMap<Integer, Integer> fHashMap = new HashMap<>();

        for (int number : numbers) {
            for (int factor : this.factors(number)) {
                fHashMap.put(factor, fHashMap.getOrDefault(factor, 0) + 1);
            }
        }

        Map<Integer, Integer> filteredMap = fHashMap.entrySet().stream()
                .filter(entry -> entry.getValue() == numbers.length)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return filteredMap.keySet().stream().max(Integer::compareTo).get();
    }

    public static void main(String[] args) {
        int[] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            numbers[i] = Integer.parseInt(args[i]);
        }

        System.out.printf("input numbers: %s\n", Arrays.toString(numbers));

        GreatestCommonDivisor greatestCommonDivisor = new GreatestCommonDivisor();
        System.out.printf("the greatest common divisor: %s\n", greatestCommonDivisor.compute(numbers));
    }
}
