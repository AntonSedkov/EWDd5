package by.epam.sedkov.task5.service.impl;

import by.epam.sedkov.task5.exception.TextException;
import by.epam.sedkov.task5.service.DeletionCharacterService;

import java.util.StringJoiner;

public class StringDeletionCharacterServiceImpl implements DeletionCharacterService {

    private static final String PUNCTUATION_EXP = "[\\p{Punct}]+";
    private static final String WORD_IN_TEXT_SEPARATOR = "[\\p{Punct}\\p{Blank}]+";
    private static final String VOWELS = "[AaEeIiOoYyАаЕеЁёИиОоУуЫыЭэЮюЯя]{1}.*";

    @Override
    public String deletePunctuation(String text) throws TextException {
        if (text == null) {
            throw new TextException("Wrong arguments.");
        }
        String editedText = text.replaceAll(PUNCTUATION_EXP, " ");
        return editedText;
    }

    @Override
    public String deleteDefineSizeWordWithFirstConsonant(String text, int wordSize) throws TextException {
        if (text == null || wordSize < 1) {
            throw new TextException("Wrong arguments.");
        }
        String[] words = text.split(WORD_IN_TEXT_SEPARATOR);
        StringJoiner editedText = new StringJoiner(" ");
        for (String word : words) {
            boolean flag = word.matches(VOWELS);
            if (word.isBlank() || wordSize != word.trim().length() || word.matches(VOWELS)) {
                editedText.add(word);
            }
        }
        return editedText.toString();
    }

}
