package by.epam.sedkov.task5.service.impl;

import by.epam.sedkov.task5.exception.TextException;
import by.epam.sedkov.task5.service.ReplacementCharacterService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternReplacementCharacterServiceImpl implements ReplacementCharacterService {

    private static final String CHARACTER_IN_WORD_EXP = "([\\wа-яА-Я]{%d})([\\wа-яА-Я]{1})([\\wа-яА-Я]*)";
    private static final String CHARACTER_IN_WORD_SUB = "$1%s$3";
    private static final String CHARACTER_AFTER_CHARACTER_EXP = "([%s]{1})([%s]{1})";
    private static final String CHARACTER_AFTER_CHARACTER_SUB = "$1%s";
    private static final String WORD_EXP = "\\b[\\wа-яА-Я]{%d}\\b";

    @Override
    public String replaceCharacterInWordByIndex(String text, int index, char sub) throws TextException {
        if (text == null || index < 0) {
            throw new TextException("Wrong arguments.");
        }
        Pattern pattern = Pattern.compile(String.format(CHARACTER_IN_WORD_EXP, index));
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll(String.format(CHARACTER_IN_WORD_SUB, sub));
        return result;
    }

    @Override
    public String replaceCharacterAfterCharacter(String text, char indicator, char toReplace, char sub) throws TextException {
        if (text == null) {
            throw new TextException("Text is null.");
        }
        Pattern pattern = Pattern.compile(String.format(CHARACTER_AFTER_CHARACTER_EXP, indicator, toReplace));
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll(String.format(CHARACTER_AFTER_CHARACTER_SUB, sub));
        return result;
    }

    @Override
    public String replaceWordWithSubstring(String text, int wordSize, int indexStartSubstring, int indexEndSubstring) throws TextException {
        if (text == null || wordSize < 0
                || indexStartSubstring < 0 || indexStartSubstring > text.length()
                || indexEndSubstring < 0 || indexEndSubstring > text.length()
                || indexStartSubstring >= indexEndSubstring) {
            throw new TextException("Wrong arguments.");
        }
        String substring = text.substring(indexStartSubstring, indexEndSubstring);
        Pattern pattern = Pattern.compile(String.format(WORD_EXP, wordSize));
        Matcher matcher = pattern.matcher(text);
        String result = matcher.replaceAll(substring);
        return result;
    }

}
