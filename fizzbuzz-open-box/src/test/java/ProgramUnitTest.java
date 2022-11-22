import algorithms.FizzBuzzAlgorithm;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.PrintStream;
import java.util.stream.IntStream;

@ExtendWith(MockitoExtension.class)
public class ProgramUnitTest {
    @Mock
    private FizzBuzzAlgorithm fizzBuzzAlgorithm;

    @Mock
    private PrintStream printStream;

    @Test
    void shouldPrintFizzBuzzAlgorithmOutputFor1To100() {
        // Arrange
        Mockito
                .when(this.fizzBuzzAlgorithm.computeFizzBuzz(Mockito.anyInt()))
                .thenAnswer(answer -> answer.getArgument(0).toString() + "test");

        // Act
        Program.fizzBuzzProgram(this.printStream, this.fizzBuzzAlgorithm);

        // Assert
        IntStream.range(1, 100 + 1).forEachOrdered(value -> {
            Mockito.verify(this.fizzBuzzAlgorithm, Mockito.times(1)).computeFizzBuzz(value);
            Mockito.verify(this.printStream, Mockito.times(1)).println(value + "test");
        });

        Mockito.verifyNoMoreInteractions(this.fizzBuzzAlgorithm, this.printStream);
    }
}