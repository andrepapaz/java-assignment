package com.mobiquity.packer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public record TestCase(int limitWeight, List<Item> listItems, String line) {

    public static String generatePackagesAndFillOutputs(TestCase testCase) {
        if (testCase.line().isEmpty()) {
            return "Line cannot be empty";
        }

        if (testCase.listItems.isEmpty()) {
            return "Line Error. Check the pattern: " + testCase.line();
        }

        if (testCase.listItems.size() > 15) {
            return "TestCase cannot have more than 15 items";
        }

        if (testCase.limitWeight() > 100) {
            return "Package Weight cannot be more than 100: " + testCase.line();
        }

        if (testCase.listItems().stream().anyMatch(item -> item.weight() > 100.0)) {
            return "Items Weight cannot be more than 100: " + testCase.line();
        }

        Set<Package> packages = new HashSet<>();

        List<Item> itemsSmallerThanPackageLimitWeight = testCase.listItems().stream().filter(item -> item.weight() <= testCase.limitWeight()).toList();

        GeneratePackages.generate(packages, itemsSmallerThanPackageLimitWeight);

        Package aPackage = packages.stream()
                .filter(p -> p.weight() <= testCase.limitWeight())
                .sorted(Comparator.comparingDouble(Package::weight))
                .max(Comparator.comparingInt(Package::cost))
                .orElseGet(() -> new Package("-", 0.0, 0));

        return aPackage.indexItems();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestCase testCase = (TestCase) o;
        return Objects.equals(line, testCase.line);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(line);
    }
}
