package be.vdab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ActriesTellen {

    private static final Path PATH = Path.of("/Users/joann/data/acteurs-actrices.csv");

    public static void main(String[] args) {


        try (var stream = Files.lines(PATH)) {
            System.out.println(
                    stream
                            .map(regel -> regel.substring(regel.lastIndexOf(";") + 1))
                            .filter(regel -> regel.equalsIgnoreCase("F"))
                            .count()
            );
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
        try (var stream = Files.lines(PATH)) {
            System.out.println(
                    stream
                            .map(regel -> regel.split(";")[2])
                            .filter(regel -> regel.equalsIgnoreCase("F"))
                            .count()
            );
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
