package be.vdab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LandnamenSorteren {
    private static final Path PATH = Path.of("/Users/joann/data/landcodes.txt");

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(PATH)) {
            stream
                    .map(regel -> regel.substring(regel.indexOf(" ") + 1))
                    .sorted()
                    .forEach(land -> System.out.println(land));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
