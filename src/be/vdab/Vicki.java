package be.vdab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Vicki {

    private static final Path PATH = Path.of("/Users/joann/data/acteurs-actrices.csv");

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(PATH)) {
            System.out.println(
                    stream
                            .map(regel -> regel.split(";")[0])
                            .anyMatch(naam -> naam.equals("Vicki"))
            );
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
