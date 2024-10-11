package com.mobiquity.packer;

import com.mobiquity.exception.APIException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Packer {


    private Packer() {
    }

    public static String pack(String filePath) throws APIException {

        Stream<String> lines = null;
        try {
            lines = Files.lines(Paths.get(filePath));
        } catch (IOException e) {
            throw new APIException("Invalid path/file.");
        }

        return lines
                .map(Validate::isValidLine)
                .map(TestCase::generatePackagesAndFillOutputs)
                .map(TestCase::getOutput)
                .collect(Collectors.joining("\n"));

    }

}
