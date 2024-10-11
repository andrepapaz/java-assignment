package com.mobiquity.packer;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ValidateTest {

    @Test
    public void shouldReturnAnInvalidTestCaseForAValidLine() {
        String line = "";
        assertEquals(new TestCase(0, Collections.emptyList(), line), Validate.isValidLine(line));
    }

}