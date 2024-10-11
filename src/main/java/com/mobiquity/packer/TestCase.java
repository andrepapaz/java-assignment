package com.mobiquity.packer;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TestCase {

    private int limitWeight;
    private List<Item> listItems;
    private String output;
    private String line;

    public TestCase() {

    }

    public TestCase(int limitWeight, List<Item> listItems) {
        this.limitWeight = limitWeight;
        this.listItems = listItems;
    }

    public TestCase(int limitWeight, List<Item> listItems, String line) {
        this.limitWeight = limitWeight;
        this.listItems = listItems;
        this.line = line;
    }

    public int getLimitWeight() {
        return limitWeight;
    }

    public void setLimitWeight(int limitWeight) {
        this.limitWeight = limitWeight;
    }

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(List<Item> listItems) {
        this.listItems = listItems;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public static TestCase generatePackagesAndFillOutputs(TestCase testCase) {
        if (testCase.getLine().isEmpty()) {
            testCase.setOutput("Line cannot be empty");
            return testCase;
        }

        if (testCase.listItems.isEmpty()) {
            testCase.setOutput("Line Error. Check the pattern: " + testCase.getLine());
            return testCase;
        }

        if (testCase.listItems.size() > 15) {
            testCase.setOutput("TestCase cannot have more than 15 items");
            return testCase;
        }

        if (testCase.getLimitWeight() > 100) {
            testCase.setOutput("Package Weight cannot be more than 100: " + testCase.getLine());
            return testCase;
        }

        if (testCase.getListItems().stream().anyMatch(item -> item.weight() > 100.0)) {
            testCase.setOutput("Items Weight cannot be more than 100: " + testCase.getLine());
            return testCase;
        }

        Set<Package> packages = new HashSet<>();

        GeneratePackages.generate(packages, testCase.getListItems());

        Package aPackage = packages.stream()
                .filter(p -> p.weight() <= testCase.getLimitWeight())
                .sorted(Comparator.comparingDouble(Package::weight))
                .max(Comparator.comparingInt(Package::cost))
                .orElseGet(() -> new Package("-", 0.0, 0));

        testCase.setOutput(aPackage.indexItems());

        return testCase;
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
