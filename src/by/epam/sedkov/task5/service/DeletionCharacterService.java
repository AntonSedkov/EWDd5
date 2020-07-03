package by.epam.sedkov.task5.service;

import by.epam.sedkov.task5.exception.TextException;

public interface DeletionCharacterService {

    String deletePunctuation(String text) throws TextException;

    String deleteDefineSizeWordWithFirstConsonant(String text, int wordSize) throws TextException;

}
