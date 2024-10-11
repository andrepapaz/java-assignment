package com.mobiquity.packer;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneratePackagesTest {

    @Test
    public void shouldGeneratePackagesWithOneItem() {
        Set<Package> packages = new HashSet<>();
        GeneratePackages.generate(packages, List.of(
                new Item(1, 53.38, 45)
        ));

        assertEquals(1, packages.size());
    }

    @Test
    public void shouldGeneratePackagesWithTwoItems() {
        Set<Package> packages = new HashSet<>();
        GeneratePackages.generate(packages, List.of(
                new Item(1, 53.38, 45),
                new Item(2, 88.62, 98)
        ));

        assertEquals(3, packages.size());
    }

    @Test
    public void shouldGeneratePackagesWithThreeItems() {
        Set<Package> packages = new HashSet<>();
        GeneratePackages.generate(packages, List.of(
                new Item(1, 53.38, 45),
                new Item(2, 88.62, 98),
                new Item(3, 78.48, 3)
        ));

        assertEquals(7, packages.size());
    }

    @Test
    public void shouldGeneratePackagesWithFourItems() {
        Set<Package> packages = new HashSet<>();
        GeneratePackages.generate(packages, List.of(
                new Item(1, 53.38, 45),
                new Item(2, 88.62, 98),
                new Item(3, 78.48, 3),
                new Item(4, 72.30, 76)
        ));

        assertEquals(15, packages.size());
    }

    @Test
    public void shouldGeneratePackagesWithFiveItems() {
        Set<Package> packages = new HashSet<>();
        GeneratePackages.generate(packages, List.of(
                new Item(1, 53.38, 45),
                new Item(2, 88.62, 98),
                new Item(3, 78.48, 3),
                new Item(4, 72.30, 76),
                new Item(5, 30.18, 9)
        ));

        assertEquals(31, packages.size());
    }

    @Test
    public void shouldGeneratePackagesWithSixItems() {
        Set<Package> packages = new HashSet<>();
        GeneratePackages.generate(packages, List.of(
                new Item(1, 53.38, 45),
                new Item(2, 88.62, 98),
                new Item(3, 78.48, 3),
                new Item(4, 72.30, 76),
                new Item(5, 30.18, 9),
                new Item(6, 46.34, 48)

        ));

        assertEquals(63, packages.size());
    }

    @Test
    public void shouldGeneratePackagesWithSevenItems() {
        Set<Package> packages = new HashSet<>();
        GeneratePackages.generate(packages, List.of(
                new Item(1, 53.38, 45),
                new Item(2, 88.62, 98),
                new Item(3, 78.48, 3),
                new Item(4, 72.30, 76),
                new Item(5, 30.18, 9),
                new Item(6, 46.34, 48),
                new Item(7, 46.94, 9)

        ));

        assertEquals(127, packages.size());
    }

}