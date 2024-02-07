package be.vdab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArtiestenEnHunAlbums {
    private static final Path PATH = Path.of("/Users/joann/data/albumsartists.txt");

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(PATH)) {
            Map<String, List<String>> albumsPerArtist = stream.collect(
                            Collectors.groupingBy(
                                    regel -> regel.substring(regel.indexOf(",") + 1)));
            albumsPerArtist.entrySet().stream()
                    .sorted((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                    .forEach(entry -> {
                        System.out.println(entry.getKey());
                        entry.getValue().stream()
                                .map(regel -> regel.substring(0, regel.indexOf(",")))
                                .sorted()
                                .forEach(album -> System.out.println("\t" + album));
                    });
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
