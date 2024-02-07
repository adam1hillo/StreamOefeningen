package be.vdab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Sterrenbeelden2 {
    private static final Path PATH = Path.of("/Users/joann/data/sterrenbeelden.txt");

    public static void main(String[] args) {


        try (Stream<String> stream = Files.lines(PATH)) {
            stream
                    .map(String::toUpperCase)
                    .forEach(System.out::println);
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
