package by.courses1.factories;

import java.util.ArrayList;
import java.util.List;

public class Factories {
    private static List<Factory> factories;
    private static boolean isStorageCreated = false;

    static {
        factories = new ArrayList<>();
        factories.add(new FranceFactory());
        factories.add(new GermanFactory());
        factories.add(new ItalianFactory());
    }

    public static List<Factory> getFactories() {
        if (!isStorageCreated) {
            for (Factory factory : factories) {
                if (factory.getStorage() == null) {
                    factory.createStorage();
                }
            }
            isStorageCreated = true;
        }
        return factories;
    }
}


