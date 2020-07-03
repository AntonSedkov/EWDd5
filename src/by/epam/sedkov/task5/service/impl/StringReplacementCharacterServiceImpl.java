package by.epam.sedkov.task5.service.impl;

import by.epam.sedkov.task5.exception.TextException;
import by.epam.sedkov.task5.service.ReplacementCharacterService;

import java.util.StringJoiner;

public class StringReplacementCharacterServiceImpl implements ReplacementCharacterService {

    private static final String WORD_IN_TEXT_SEPARATOR = "[\\p{Punct}\\p{Blank}]+";

    @Override
    public String replaceCharacterInWordByIndex(String text, int index, char sub) throws TextException {
        if (text == null || index < 0) {
            throw new TextException("Wrong arguments.");
        }
        String[] words = text.split(WORD_IN_TEXT_SEPARATOR);
        StringJoiner editedText = new StringJoiner(" ");
        for (String word : words) {
            if (!word.isBlank() && index < word.length()) {
                StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.setCharAt(index, sub);
                editedText.add(stringBuilder);
            } else {
                editedText.add(word);
            }
        }
        return editedText.toString();
    }

    @Override
    public String replaceCharacterAfterCharacter(String text, char indicator, char toReplace, char sub) throws TextException {
        if (text == null) {
            throw new TextException("Text is null.");
        }
        String editedText = text.replaceAll(indicator + String.valueOf(toReplace), indicator + String.valueOf(sub));
        return editedText;
    }

    @Override
    public String replaceWordWithSubstring(String text, int wordSize, int indexStartSubstring, int indexEndSubstring) throws TextException {
        if (text == null || wordSize < 0
                || indexStartSubstring < 0 || indexStartSubstring >= text.length()
                || indexEndSubstring < 0 || indexEndSubstring >= text.length()
                || indexStartSubstring >= indexEndSubstring) {
            throw new TextException("Wrong arguments.");
        }
        String[] words = text.split(WORD_IN_TEXT_SEPARATOR);
        String substring = text.substring(indexStartSubstring, indexEndSubstring);
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isBlank() && words[i].length() == wordSize) {
                words[i] = words[i].replace(words[i], substring);
            }
            stringJoiner.add(words[i]);
        }
        return stringJoiner.toString();
    }

}
