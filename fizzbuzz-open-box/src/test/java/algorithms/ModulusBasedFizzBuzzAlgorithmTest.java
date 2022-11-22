package algorithms;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ModulusBasedFizzBuzzAlgorithmTest {
    @Nested
    @DisplayName("Basic unit testing of the computeFizzBuzz method. Good enough ?")
    class BasicUnitTesting {
        private ModulusBasedFizzBuzzAlgorithm sut;

        @BeforeEach
        void setUp() {
            this.sut = new ModulusBasedFizzBuzzAlgorithm();
        }

        @Test
        void givenAMultipleOf3ShouldReturnFizz() {
            // Arrange
            final var input = 3;
            final var expected = "Fizz";

            // Act
            final var actual = this.sut.computeFizzBuzz(input);

            // Assert
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void givenAMultipleOf5ShouldReturnBuzz() {
            // Arrange
            final var input = 5;
            final var expected = "Buzz";

            // Act
            final var actual = this.sut.computeFizzBuzz(input);

            // Assert
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void givenAMultipleOf3And5ShouldReturnFizzBuzz() {
            // Arrange
            final var input = 15;
            final var expected = "FizzBuzz";

            // Act
            final var actual = this.sut.computeFizzBuzz(input);

            // Assert
            Assertions.assertEquals(expected, actual);
        }

        @Test
        void givenAnyOtherValueShouldReturnTheValueAsString() {
            // Arrange
            final var input = 1;
            final var expected = "1";

            // Act
            final var actual = this.sut.computeFizzBuzz(input);

            // Assert
            Assertions.assertEquals(expected, actual);
        }
    }

    @Nested
    @DisplayName("Parameterized unit testing of the computeFizzBuzz method. Good enough ?")
    class ParameterizedUnitTesting {
        private ModulusBasedFizzBuzzAlgorithm sut;

        @BeforeEach
        void setUp() {
            this.sut = new ModulusBasedFizzBuzzAlgorithm();
        }

        @ParameterizedTest
        @ValueSource(ints = {3, 6, 9, 12, /*15, <- uh oh */ 18, 21})
        // givenSomeMultipleOf3ShouldReturnFizz changed to
        void givenSomeMultipleOf3ButNotOf5ShouldReturnFizz(int input) {
            // Arrange
            final var expected = "Fizz";

            // Act
            final var actual = this.sut.computeFizzBuzz(input);

            // Assert
            Assertions.assertEquals(expected, actual);
        }

        @ParameterizedTest
        @ValueSource(ints = {5, 10, /*15, <- uh oh */ 20, 25})
        // givenSomeMultipleOf5ShouldReturnBuzz changed to
        void givenSomeMultipleOf5ButNotOf3ShouldReturnBuzz(int input) {
            // Arrange
            final var expected = "Buzz";

            // Act
            final var actual = this.sut.computeFizzBuzz(input);

            // Assert
            Assertions.assertEquals(expected, actual);
        }

        @ParameterizedTest
        @ValueSource(ints = {15, 30, 45, 60})
        void givenSomeMultipleOf3And5ShouldReturnFizzBuzz(int input) {
            // Arrange
            final var expected = "FizzBuzz";

            // Act
            final var actual = this.sut.computeFizzBuzz(input);

            // Assert
            Assertions.assertEquals(expected, actual);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 4, 7})
        // givenAnyOtherValueShouldReturnTheValueAsString changed to
        void givenSomeValuesNotMultipleOf3Nor5ShouldReturnTheValueAsString(int input) {
            // Arrange
            final var expected = String.valueOf(input);

            // Act
            final var actual = this.sut.computeFizzBuzz(input);

            // Assert
            Assertions.assertEquals(expected, actual);
        }

        @Disabled
        @ParameterizedTest
        @CsvSource({"1, 1", "2, 2", "3, Fizz", "4, 4", "5, Buzz", "15, FizzBuzz"})
        // Don't fall to the dark side of the force, err, of oversimplification
        void givenSomeValueShouldReturnExpectedValue(int input, String expected) {
            // Arrange
            // via @CsvSource

            // Act
            final var actual = this.sut.computeFizzBuzz(input);

            // Assert
            Assertions.assertEquals(expected, actual);
        }
    }
}
