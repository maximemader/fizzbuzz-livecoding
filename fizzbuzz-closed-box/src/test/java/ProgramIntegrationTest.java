import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ProgramIntegrationTest {
    private PrintStream defaultPrintStream;
    private ByteArrayOutputStream inMemoryOutputStream;

    @BeforeEach
    void setUp() {
        this.defaultPrintStream = System.out;
        this.inMemoryOutputStream = new ByteArrayOutputStream();

        System.setOut(new PrintStream(this.inMemoryOutputStream));
    }

    @AfterEach
    void tearDown() {
        System.setOut(this.defaultPrintStream);
    }

    @Test
    void goldenMasterTesting() throws IOException, URISyntaxException {
        // Arrange
        final var fileURI = Objects.requireNonNull(
                    ProgramIntegrationTest.class
                    .getClassLoader()
                    .getResource("Program.expected"))
                .toURI();

        final var expected = Files.readString(Path.of(fileURI));

        // Act
        Program.main(null);

        final var actual = this.inMemoryOutputStream.toString();

        // Assert
        Assertions.assertEquals(expected, actual);
    }
}
