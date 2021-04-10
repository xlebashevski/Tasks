package by.courses1.factories;

import java.util.ArrayList;
import java.util.List;

public class Factories {
    private static List<Factory> factories;

    private Factories() {
    }

    public static synchronized List<Factory> getInstance() {
        if (factories == null) {
            factories = new ArrayList<>();
            factories.add(new FranceFactory());
            factories.add(new GermanFactory());
            factories.add(new ItalianFactory());
        }
        return factories;
    }
}


