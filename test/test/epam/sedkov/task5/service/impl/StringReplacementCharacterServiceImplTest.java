package test.epam.sedkov.task5.service.impl;

import by.epam.sedkov.task5.exception.TextException;
import by.epam.sedkov.task5.service.impl.StringReplacementCharacterServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class StringReplacementCharacterServiceImplTest {

    StringReplacementCharacterServiceImpl service;
    String input;

    @BeforeMethod
    public void setUp() {
        service = new StringReplacementCharacterServiceImpl();
        input = "Changing words, oko necessary - change / opened. \n\tАвторы доклад предлагают, кое-как oko okokoko kok. \n";
    }

    @Test
    public void testReplaceCharacterInWordByIndex() {
        String expected = "Changi@g words oko necess@ry change opened \n Авторы доклад предла@ают кое как oko okokok@ kok \n";
        try {
            String actual = service.replaceCharacterInWordByIndex(input, 6, '@');
            assertEquals(actual, expected);
        } catch (TextException e) {
            fail();
        }
    }

    @Test(expectedExceptions = TextException.class)
    public void testExceptionNullReplaceCharacterInWordByIndex() throws TextException {
        String actual = service.replaceCharacterInWordByIndex(null, 5, '@');
    }

    @Test(expectedExceptions = TextException.class)
    public void testExceptionNegativeReplaceCharacterInWordByIndex() throws TextException {
        String actual = service.replaceCharacterInWordByIndex(input, -66, '@');
    }

    @Test
    public void testReplaceCharacterAfterCharacter() {
        String expected = "Changing words, okA necessary - change / opened. \n\tАвторы доклад предлагают, кое-как okA okAkAkA kAk. \n";
        try {
            String actual = service.replaceCharacterAfterCharacter(input, 'k', 'o', 'A');
            assertEquals(actual, expected);
        } catch (TextException e) {
            fail();
        }
    }

    @Test(expectedExceptions = TextException.class)
    public void testExceptionReplaceCharacterAfterCharacter() throws TextException {
        String actual = service.replaceCharacterAfterCharacter(null, 'k', 'o', 'A');
    }

    @Test
    public void testReplaceWordWithSubstring() {
        String expected = "Changing words oko necessary word word \n word word предлагают кое как oko okokoko kok \n";
        try {
            String actual = service.replaceWordWithSubstring(input, 6, 9, 13);
            assertEquals(actual, expected);
        } catch (TextException e) {
            fail();
        }
    }

    @Test(dataProvider = "dataDifferentException", expectedExceptions = TextException.class)
    public void testExceptionReplaceWordWithSubstring(String text, int wordSize, int indexStart, int indexEnd) throws TextException {
        String actual = service.replaceWordWithSubstring(text, wordSize, indexStart, indexEnd);
    }

    @DataProvider(name = "dataDifferentException")
    public Object[][] dataDifferentException() {
        return new Object[][]{
                {null, 6, 9, 13}, {input, -2, 9, 13}, {input, 6, -1, 13}, {input, 6, 9999, 13},
                {input, 6, 9, -3}, {input, 6, 9, 113133}, {input, 6, 15, 10}
        };
    }

}