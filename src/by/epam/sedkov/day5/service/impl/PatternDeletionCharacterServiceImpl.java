package by.epam.sedkov.day5.service.impl;

import by.epam.sedkov.day5.exception.TextException;
import by.epam.sedkov.day5.service.DeletionCharacterService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDeletionCharacterServiceImpl implements DeletionCharacterService {

    private static final String DELETE_PUNCTUATION_EXP = "[\\p{Punct}[^- \\wА-Яа-я]]+";
    private static final String CONSONANT_START_WORD_EXP = "\\b[?<=\\wА-Яа-я[^AaEeIiOoYyАаЕеЁёИиОоУуЫыЭэЮюЯя]]\\b[\\wа-яА-Я]{%d}\\b";

    @Override
    public String deletePunctuation(String text, String sub) throws TextException {
        if (text == null || sub == null) {
            throw new TextException("Wrong arguments.");
        }
        Pattern pattern = Pattern.compile(DELETE_PUNCTUATION_EXP);
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll(sub);
        return result;
    }

    @Override
    public String deleteDefineSizeWord(String text, int wordSize) throws TextException {
        if (text == null || wordSize < 1) {
            throw new TextException("Wrong arguments.");
        }
        Pattern pattern = Pattern.compile(String.format(CONSONANT_START_WORD_EXP, wordSize));
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll("");
        return result;
    }

}
