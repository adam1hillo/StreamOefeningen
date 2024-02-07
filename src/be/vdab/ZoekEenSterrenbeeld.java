package be.vdab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.stream.Stream;

public class ZoekEenSterrenbeeld {

    private static final Path PATH = Path.of("/Users/joann/data/sterrenbeelden.txt");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tik een woord");
        String woord = scanner.next().toUpperCase();

        try (Stream<String> stream = Files.lines(PATH)) {
            stream
                    .filter(regel -> regel.toUpperCase().contains(woord))
                    .forEach(regel -> System.out.println(regel));
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
