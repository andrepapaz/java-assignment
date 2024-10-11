package com.mobiquity.packer;

import com.mobiquity.exception.APIException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PackerTest {

    private static String absolutePath;

    @BeforeAll
    static void beforeAll() {
        Path resourcesDirectory = Paths.get("src", "main", "test", "resources");
        absolutePath = resourcesDirectory.toFile().getAbsolutePath();
    }

    @Test
    public void shouldThrowsAPIException() throws APIException {
        String packed = Packer.pack(absolutePath + "/example_input");
        assertEquals("4\n-\n2,7\n8,9", packed);
    }


    @Test
    public void shouldReturnError() throws APIException {
        String packed = Packer.pack(absolutePath + "/invalid_input");
        assertEquals("Line Error. Check the pattern: 81:(1,53.38,€45)(2,88.62,€98)(3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)", packed);
    }

    @Test
    public void shouldReturnErrorForEmptyLine() throws APIException {
        String packed = Packer.pack(absolutePath + "/empty_line_input");
        assertEquals("Line cannot be empty", packed);
    }
}