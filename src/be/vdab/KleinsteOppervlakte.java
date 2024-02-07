package be.vdab;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;

class Rechthoek {
    private final int lengte;
    private final int breedte;

    public Rechthoek(int lengte, int breedte) {
        this.lengte = lengte;
        this.breedte = breedte;
    }

    int getOppervlakte() {
        return lengte * breedte;
    }

    @Override
    public String toString() {
        return lengte + " op " + breedte;
    }

    public int getLengte() {
        return lengte;
    }

    public int getBreedte() {
        return breedte;
    }
}
public class KleinsteOppervlakte {

    public static void main(String[] args) {

        Random random = new Random();
        List<Rechthoek> rechthoeken = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rechthoeken.add(new Rechthoek(random.nextInt(10) + 1, random.nextInt(10) + 1));
        }


        OptionalInt min = rechthoeken.stream()
                .mapToInt(rechthoek -> rechthoek.getOppervlakte())
                .min();
        min.ifPresent(oppervlakte -> {
            System.out.println(oppervlakte);
            rechthoeken.stream()
                    .filter(rechthoek -> rechthoek.getOppervlakte() == oppervlakte)
                    .forEach(rechthoek -> System.out.println(rechthoek));
        });

    }

}
