package com.mobiquity.packer;

import java.util.Objects;

/**
 * I've used a record, and overridden the equals and hashcode to improve the performance.
 * Here first I tried to receive a List<Items> as the unique parameter and generating getters for indexString, weight
 *  and cost, reading from the list, but it got very slow in my tests.
 *
 * @param indexItems
 * @param weight
 * @param cost
 */
public record Package(String indexItems, double weight, int cost) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Objects.equals(indexItems, aPackage.indexItems);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(indexItems);
    }
}
