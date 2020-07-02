package by.epam.sedkov.day5.service.impl;

import by.epam.sedkov.day5.exception.TextException;
import by.epam.sedkov.day5.service.DeletionCharacterService;

public class CharDeletionCharacterServiceImpl implements DeletionCharacterService {

    private static final String VOWELS = "AaEeIiOoYyАаЕеЁёИиОоУуЫыЭэЮюЯя";

    @Override
    public String deletePunctuation(String text, String sub) throws TextException {
        if (text == null || sub == null) {
            throw new TextException("Wrong arguments.");
        }
        char[] textChar = text.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : textChar) {
            if (Character.isLetterOrDigit(c) || Character.isWhitespace(c) || c == '-') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String deleteDefineSizeWord(String text, int wordSize) throws TextException {
        if (text == null || wordSize < 1) {
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
            boolean flag = false;
            for (int i = 0; i < VOWELS.length(); i++) {
                if (textChar[startIndex] == VOWELS.charAt(i)) {
                    flag = true;
                    i = VOWELS.length();
                }
            }
            if (endIndex - startIndex != wordSize || flag) {
                for (int k = startIndex; k < textChar.length && k <= endIndex; k++) {
                    stringBuilder.append(textChar[k]);
                }
            }
        }
        return stringBuilder.toString();
    }

}
