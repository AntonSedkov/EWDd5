package by.epam.sedkov.day5.service;

import by.epam.sedkov.day5.exception.TextException;

public interface DeletionCharacterService {

    String deletePunctuation(String text, String sub) throws TextException;

    String deleteDefineSizeWord(String text, int wordSize) throws TextException;
}
