package be.vdab;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Artistennamen {
    private static final Path PATH = Path.of("/Users/joann/data/albumsartists.txt");

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(PATH)) {
            stream
                    .map(regel -> regel.substring(regel.indexOf(",") + 1))
                    .distinct()
                    .sorted()
                    .forEach(artist -> System.out.println(artist));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
