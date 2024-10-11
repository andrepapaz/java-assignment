package com.mobiquity.packer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static final String SPACE = " ";

    public static TestCase isValidLine(String line) {
        String pattern = "(^\\d{1,}\\s{1}):((\\s{1}\\(\\d{1,2},\\d{1,3}\\.\\d{1,2},€\\d{1,2}\\)){1,})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);

        TestCase testCase;

        if (m.find()) {
            String[] itemsArray = m.group(2).trim().split(SPACE);
            List<Item> listItems = Arrays.stream(itemsArray).map(Item::parseItem).toList();

            testCase = new TestCase(Integer.parseInt(m.group(1).trim()), listItems, line);

        } else {
            testCase = new TestCase(0, Collections.emptyList(), line);
        }
        return testCase;
    }

}
