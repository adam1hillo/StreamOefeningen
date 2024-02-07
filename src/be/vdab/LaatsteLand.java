package be.vdab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LaatsteLand {

    private static final Path PATH = Path.of("/Users/joann/data/landcodes.txt");

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(PATH)) {
            stream
                    .map(regel -> regel.substring(regel.indexOf(" ") + 1))
                    .max((land1, land2) -> land1.compareToIgnoreCase(land2))
                    .ifPresent(land -> System.out.println(land));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
