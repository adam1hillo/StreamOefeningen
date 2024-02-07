package be.vdab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Sterrenbeelden {
    private static final Path PATH = Path.of("/Users/joann/data/sterrenbeelden.txt");

    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(PATH)) {
            stream.forEach(regel -> System.out.println(regel.toUpperCase()));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
