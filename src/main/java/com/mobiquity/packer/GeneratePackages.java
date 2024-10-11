package com.mobiquity.packer;

import java.util.List;
import java.util.Set;

public class GeneratePackages {

    /**
     * I've used the recursive method and streams to improve readability, but it needs to be improved to attend
     * up to 15 items in an acceptable time.
     *
     * @param packages
     * @param items
     */
    public static void generate(Set<Package> packages, List<Item> items) {

        if (items.isEmpty()) return;

        Package aPackage = items.stream().reduce(
                new Package("", 0.0, 0),
                (acc, item) -> new Package(
                        acc.indexItems() + (acc.indexItems().isEmpty() ? "" : ",") + item.index(),
                        acc.weight() + item.weight(),
                        acc.cost() + item.cost()
                ),
                (p1, p2) -> new Package(
                        p1.indexItems() + (p1.indexItems().isEmpty() ? "" : ",") + p2.indexItems(),
                        p1.weight() + p2.weight(),
                        p1.cost() + p2.cost()
                )
        );

        packages.add(aPackage);

        items.forEach(item -> generate(packages, items.stream()
                .filter(item1 -> !item1.equals(item))
                .toList()));
    }

}
