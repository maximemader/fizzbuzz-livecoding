import java.util.stream.IntStream;

public class Program {
    public static void main(String[] args) {
        IntStream
                .range(1, 100 + 1)
                .forEachOrdered(value -> System.out.println(computeFizzBuzz(value)));
    }

    public static String computeFizzBuzz(int value) {
        if(value <= 0)
            throw new IllegalArgumentException();

        final var isMultipleOf3 = value % 3 == 0;
        final var isMultipleOf5 = value % 5 == 0;

        if(isMultipleOf3 && isMultipleOf5) {
            return "FizzBuzz";
        } else if (isMultipleOf3) {
            return "Fizz";
        } else if(isMultipleOf5) {
            return "Buzz";
        } else {
            return String.valueOf(value);
        }
    }
}
