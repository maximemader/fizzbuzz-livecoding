import algorithms.FizzBuzzAlgorithm;
import algorithms.ModulusBasedFizzBuzzAlgorithm;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class Program {
    public static void main(String[] args) {
        final var modulusBasedFizzBuzzAlgorithm = new ModulusBasedFizzBuzzAlgorithm();

        fizzBuzzProgram(System.out, modulusBasedFizzBuzzAlgorithm);
    }

    public static void fizzBuzzProgram(PrintStream printStream, FizzBuzzAlgorithm fizzBuzzAlgorithm) {
        IntStream.range(1, 100 + 1).forEachOrdered(value ->
                printStream.println(fizzBuzzAlgorithm.computeFizzBuzz(value)));
    }
}
