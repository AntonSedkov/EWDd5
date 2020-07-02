package by.epam.sedkov.day5.service;

import by.epam.sedkov.day5.exception.TextException;

public interface ReplacementCharacterService {

    String WORD_IN_TEXT_SEPARATOR = "[\\p{Punct}\\p{Blank}]+";

    String replaceCharacterInWordByIndex(String text, int index, char sub) throws TextException;

    String replaceCharacterAfterCharacter(String text, char indicator, char toReplace, char sub) throws TextException;

    String replaceWordForSubstring(String text, int wordSize, int indexStartSubstring, int indexEndSubstring) throws TextException;
}
