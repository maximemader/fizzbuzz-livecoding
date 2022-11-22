import net.jqwik.api.*;
import net.jqwik.api.arbitraries.IntegerArbitrary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;

public class ProgramProperties {
    /*
        Beware of magic strings, as there is no C# nameof() *out of the box* equivalent in Java.
        https://stackoverflow.com/questions/40850926/nameof-equivalent-in-java

        Example with Lombok
        https://projectlombok.org/features/experimental/FieldNameConstants

        For clarity's sake, we can also use nested class, domain contexts, or
        https://jqwik.net/docs/current/user-guide.html#grouping-tests.
    */
    private static final String ARGUMENT_OUT_OF_RANGE_PROVIDER
            = "argumentOutOfRangeProvider";

    private static final String MULTIPLE_OF_3_AND_NOT_MULTIPLE_OF_5_PROVIDER
            = "multipleOf3AndNotMultipleOf5Provider";

    private static final String NOT_MULTIPLE_OF_3_AND_MULTIPLE_OF_5_PROVIDER
            = "notMultipleOf3AndMultipleOf5Provider";

    private static final String MULTIPLE_OF_3_AND_MULTIPLE_OF_5_PROVIDER
            = "multipleOf3AndMultipleOf5Provider";

    private static final String NOT_MULTIPLE_OF_3_AND_NOT_MULTIPLE_OF_5_PROVIDER
            = "notMultipleOf3AndNotMultipleOf5Provider";

    @Disabled
    @Property
    void given_out_of_range_integers_should_throw_illegal_argument_exception(
            @ForAll(ARGUMENT_OUT_OF_RANGE_PROVIDER) int input
    ) {
        // Arrange

        // Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // Act
            Program.computeFizzBuzz(input);
        });
    }

    @Provide
    private IntegerArbitrary argumentOutOfRangeProvider() {
        return Arbitraries.integers().lessOrEqual(0);
    }

    @Property
    void given_multiple_of_3_and_not_multiple_of_5_should_return_Fizz(
            @ForAll(MULTIPLE_OF_3_AND_NOT_MULTIPLE_OF_5_PROVIDER) int input) {
        // Arrange
        final var expected = "Fizz";

        // Act
        final var actual = Program.computeFizzBuzz(input);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Provide
    private Arbitrary<Integer> multipleOf3AndNotMultipleOf5Provider() {
        return Arbitraries.integers().filter(x ->
                x > 0 && x % 3 == 0 && x % 5 != 0
        );
    }

    @Property
    void given_not_multiple_of_3_and_multiple_of_5_should_return_Buzz(
            @ForAll(NOT_MULTIPLE_OF_3_AND_MULTIPLE_OF_5_PROVIDER) int input) {
        // Arrange
        final var expected = "Buzz";

        // Act
        final var actual = Program.computeFizzBuzz(input);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Provide
    private Arbitrary<Integer> notMultipleOf3AndMultipleOf5Provider() {
        return Arbitraries.integers().filter(x ->
                x > 0 && x % 3 != 0 && x % 5 == 0
        );
    }

    @Property
    void given_multiple_of_3_and_multiple_of_5_should_return_FizzBuzz(
            @ForAll(MULTIPLE_OF_3_AND_MULTIPLE_OF_5_PROVIDER) int input) {
        // Arrange
        final var expected = "FizzBuzz";

        // Act
        final var actual = Program.computeFizzBuzz(input);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Provide
    private Arbitrary<Integer> multipleOf3AndMultipleOf5Provider() {
        return Arbitraries.integers().filter(x ->
                x > 0 && x % 3 == 0 && x % 5 == 0
        );
    }

    @Property
    void given_not_multiple_of_3_and_not_multiple_of_5_should_return_input_value_as_string(
            @ForAll(NOT_MULTIPLE_OF_3_AND_NOT_MULTIPLE_OF_5_PROVIDER) int input) {
        // Arrange
        final var expected = String.valueOf(input);

        // Act
        final var actual = Program.computeFizzBuzz(input);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Provide
    private Arbitrary<Integer> notMultipleOf3AndNotMultipleOf5Provider() {
        return Arbitraries.integers().filter(x ->
                x > 0 && x % 3 != 0 && x % 5 != 0
        );
    }
}
