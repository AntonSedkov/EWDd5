package by.epam.sedkov.task5.service.impl;

import by.epam.sedkov.task5.exception.TextException;
import by.epam.sedkov.task5.service.DeletionCharacterService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDeletionCharacterServiceImpl implements DeletionCharacterService {

    private static final String DELETE_PUNCTUATION_WITH_RESTRICTION_EXP = "[\\p{Punct}&&[^- ]]+";
    private static final String CONSONANT_START_WORD_EXP = "\\b[^ AaEeIiOoYyАаЕеЁёИиОоУуЫыЭэЮюЯя]{1}[\\wА-Яа-я]{%d}\\b";

    @Override
    public String deletePunctuation(String text) throws TextException {
        if (text == null) {
            throw new TextException("Wrong arguments.");
        }
        Pattern pattern = Pattern.compile(DELETE_PUNCTUATION_WITH_RESTRICTION_EXP);
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll(" ");
        return result;
    }

    @Override
    public String deleteDefineSizeWordWithFirstConsonant(String text, int wordSize) throws TextException {
        if (text == null || wordSize < 1) {
            throw new TextException("Wrong arguments.");
        }
        Pattern pattern = Pattern.compile(String.format(CONSONANT_START_WORD_EXP, wordSize - 1));
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("");
        return result;
    }

}
