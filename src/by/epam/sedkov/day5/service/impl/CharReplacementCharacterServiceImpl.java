package by.epam.sedkov.day5.service.impl;

import by.epam.sedkov.day5.exception.TextException;
import by.epam.sedkov.day5.service.ReplacementCharacterService;

public class CharReplacementCharacterServiceImpl implements ReplacementCharacterService {

    @Override
    public String replaceCharacterInWordByIndex(String text, int letterIndex, char sub) throws TextException {
        if (text == null || letterIndex < 0) {
            throw new TextException("Wrong arguments.");
        }
        char[] textChar = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < textChar.length; j++) {
            int startIndex = j;
            while (j < textChar.length && Character.isLetter(textChar[j])) {
                j++;
            }
            int endIndex = j;
            if (endIndex - startIndex > letterIndex) {
                for (int i = startIndex; i < textChar.length && i <= endIndex; i++) {
                    if (i != startIndex + letterIndex) {
                        stringBuilder.append(textChar[i]);
                    } else {
                        stringBuilder.append(sub);
                    }
                }
            } else {
                for (int i = startIndex; i < textChar.length && i <= endIndex; i++) {
                    stringBuilder.append(textChar[i]);
                }
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String replaceCharacterAfterCharacter(String text, char indicator, char toReplace, char sub) throws TextException {
        if (text == null) {
            throw new TextException("Text is null.");
        }
        char[] textChar = text.toCharArray();
        for (int j = 1; j < textChar.length; j++) {
            if (textChar[j - 1] == indicator && textChar[j] == toReplace) {
                textChar[j] = sub;
                j++;
            }
        }
        return String.valueOf(textChar);
    }

    @Override
    public String replaceWordForSubstring(String text, int wordSize, int indexStartSubstring, int indexEndSubstring) throws TextException {
        if (text == null || wordSize < 0
                || indexStartSubstring < 0 || indexStartSubstring > text.length()
                || indexEndSubstring < 0 || indexEndSubstring > text.length()
                || indexStartSubstring >= indexEndSubstring) {
            throw new TextException("Wrong arguments.");
        }
        char[] textChar = text.toCharArray();
        char[] substringChar = text.substring(indexStartSubstring, indexEndSubstring).toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < textChar.length; j++) {
            int startIndex = j;
            while (j < textChar.length && Character.isLetter(textChar[j])) {
                j++;
            }
            int endIndex = j;
            if (endIndex - startIndex == wordSize) {
                stringBuilder.append(substringChar).append(" ");
            } else {
                for (int i = startIndex; i < textChar.length && i <= endIndex; i++) {
                    stringBuilder.append(textChar[i]);
                }
            }
        }
        return stringBuilder.toString();
    }

}
