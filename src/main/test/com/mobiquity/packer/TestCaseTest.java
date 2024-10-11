package com.mobiquity.packer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestCaseTest {

    @Test
    public void shouldReturnEmptyLineError() {

        TestCase testCase = Validate.isValidLine("");

        String outputTestCase = TestCase.generatePackagesAndFillOutputs(testCase);
        assertEquals("Line cannot be empty", outputTestCase);
    }

    @Test
    public void shouldReturnInvalidLineError() {

        String line = "81:(1,53.38,€45)(2,88.62,€98)(3,78.48,€3)(4,72.30,€76)(5,30.18,€9)(6,46.34,€48)";

        TestCase noSpacesTestCase = Validate.isValidLine(line);

        String outputTestCase = TestCase.generatePackagesAndFillOutputs(noSpacesTestCase);
        assertEquals("Line Error. Check the pattern: " + line, outputTestCase);
    }

    @Test
    public void shouldReturnInvalidPatternForEmptyPackageWeight() {

        String line = " : (1,53.38,€45)";

        TestCase noPackageWeightTestCase = Validate.isValidLine(line);

        String outputTestCase = TestCase.generatePackagesAndFillOutputs(noPackageWeightTestCase);
        assertEquals("Line Error. Check the pattern: " + line, outputTestCase);
    }

    @Test
    public void shouldReturnInvalidPatternForEmptyListItems() {

        String line = "40 : ";

        TestCase noListItemsTestCase = Validate.isValidLine(line);

        String outputTestCase = TestCase.generatePackagesAndFillOutputs(noListItemsTestCase);
        assertEquals("Line Error. Check the pattern: " + line, outputTestCase);
    }

    @Test
    public void shouldReturnInvalidPatternForInvalidListItemsParenthesis() {

        String line = "40 : 1,53.38,€45";

        TestCase noListItemsTestCase = Validate.isValidLine(line);

        String outputTestCase = TestCase.generatePackagesAndFillOutputs(noListItemsTestCase);
        assertEquals("Line Error. Check the pattern: " + line, outputTestCase);
    }

    @Test
    public void shouldReturnInvalidPatternForInvalidListItemsSeparator() {

        String line = "40 : (1 53.38 €45)";

        TestCase noListItemsTestCase = Validate.isValidLine(line);

        String outputTestCase = TestCase.generatePackagesAndFillOutputs(noListItemsTestCase);
        assertEquals("Line Error. Check the pattern: " + line, outputTestCase);
    }

    @Test
    public void shouldReturnMaxPackageWeightError() {

        String line = "101 : (1,53.38,€45)";

        TestCase overLimitWeightTestCase = Validate.isValidLine(line);

        String outputTestCase = TestCase.generatePackagesAndFillOutputs(overLimitWeightTestCase);
        assertEquals("Package Weight cannot be more than 100: " + line, outputTestCase);
    }

    @Test
    public void shouldReturnMore15ItemsError() {

        TestCase testCase = Validate.isValidLine("40 : " +
                "(1,2.05,€3) " +
                "(2,2.05,€3) " +
                "(3,2.05,€3) " +
                "(4,2.05,€3) " +
                "(5,2.05,€3) " +
                "(6,2.05,€3) " +
                "(7,2.05,€3) " +
                "(8,2.05,€3) " +
                "(9,2.05,€3) " +
                "(10,2.05,€3) " +
                "(11,2.05,€3) " +
                "(12,2.05,€3) " +
                "(13,2.05,€3) " +
                "(14,2.05,€3) " +
                "(15,2.05,€3) " +
                "(16,2.05,€3)");

        String outputTestCase = TestCase.generatePackagesAndFillOutputs(testCase);
        assertEquals("TestCase cannot have more than 15 items", outputTestCase);
    }

    @Test
    public void shouldReturnMaxItemWeightError() {

        String line = "100 : (1,5.38,€45) (2,100.38,€45) (3,44.38,€45)";

        TestCase overLimitWeightTestCase = Validate.isValidLine(line);

        String outputTestCase = TestCase.generatePackagesAndFillOutputs(overLimitWeightTestCase);
        assertEquals("Items Weight cannot be more than 100: " + line, outputTestCase);
    }

}