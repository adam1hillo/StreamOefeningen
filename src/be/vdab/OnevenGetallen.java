package be.vdab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnevenGetallen {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> getallen = new ArrayList<>();
        System.out.println("Tik uw getal (0 om te stoppen):");
        for (int getal; (getal = scanner.nextInt()) != 0; ) {
            getallen.add(getal);
            System.out.println("Tik uw getal (0 om te stoppen):");
        }

        getallen.stream()
                .filter(getal -> getal % 2 != 0)
                .sorted((getal1, getal2) -> getal2-getal1)
                .forEach(getal -> System.out.println(getal));

    }
}
