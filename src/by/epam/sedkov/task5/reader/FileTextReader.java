package by.epam.sedkov.task5.reader;

import by.epam.sedkov.task5.exception.TextException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileTextReader {

    public String readTextFromFile(String fileName) throws TextException {
        String text;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            text = br.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new TextException("Path is wrong", e);
        }
        return text;
    }

}
