package by.epam.sedkov.day5.service.impl;

import by.epam.sedkov.day5.exception.TextException;
import by.epam.sedkov.day5.service.DeletionCharacterService;

import java.util.StringJoiner;

public class StringDeletionCharacterServiceImpl implements DeletionCharacterService {

    private static final String PUNCTUATION_WITH_RESTRICTION = "[\\p{Punct}]+";
    private static final String WORD_IN_TEXT_SEPARATOR = "[\\p{Punct}\\p{Blank}]+";
    private static final String VOWELS = "[AaEeIiOoYyАаЕеЁёИиОоУуЫыЭэЮюЯя]{1}.*";

    @Override
    public String deletePunctuation(String text, String sub) throws TextException {
        if (text == null || sub == null) {
            throw new TextException("Wrong arguments.");
        }
        String editedText = text.replaceAll(PUNCTUATION_WITH_RESTRICTION, " ");
        return editedText;
    }

    @Override
    public String deleteDefineSizeWord(String text, int wordSize) throws TextException {
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
