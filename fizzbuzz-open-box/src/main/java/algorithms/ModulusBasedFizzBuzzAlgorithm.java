package algorithms;

public class ModulusBasedFizzBuzzAlgorithm implements FizzBuzzAlgorithm {
    public String computeFizzBuzz(int value) {
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
