package by.epam.sedkov.task5.service;

import by.epam.sedkov.task5.exception.TextException;

public interface ReplacementCharacterService {

    String replaceCharacterInWordByIndex(String text, int index, char sub) throws TextException;

    String replaceCharacterAfterCharacter(String text, char indicator, char toReplace, char sub) throws TextException;

    String replaceWordWithSubstring(String text, int wordSize, int indexStartSubstring, int indexEndSubstring) throws TextException;

}
