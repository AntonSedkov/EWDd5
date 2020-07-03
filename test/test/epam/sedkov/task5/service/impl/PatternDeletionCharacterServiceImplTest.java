package test.epam.sedkov.task5.service.impl;

import by.epam.sedkov.task5.exception.TextException;
import by.epam.sedkov.task5.service.impl.PatternDeletionCharacterServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class PatternDeletionCharacterServiceImplTest {

    PatternDeletionCharacterServiceImpl service;
    String input;

    @BeforeMethod
    public void setUp() {
        service = new PatternDeletionCharacterServiceImpl();
        input = "Changing words, oko necessary - change / opened. \n\tАвторы доклад предлагают, кое-как oko okokoko kok. \n";
    }

    @Test
    public void testDeletePunctuation() {
        String expected = "Changing words  oko necessary - change   opened  \n\tАвторы доклад предлагают  кое-как oko okokoko kok  \n";
        try {
            String actual = service.deletePunctuation(input);
            assertEquals(actual, expected);
        } catch (TextException e) {
            fail();
        }
    }

    @Test(expectedExceptions = TextException.class)
    public void testExceptionNullDeletePunctuation() throws TextException {
        String actual = service.deletePunctuation(null);
    }

    @Test
    public void testDeleteDefineSizeWordWithFirstConsonant() {
        String expected = "Changing words, oko necessary -  / opened. \n\tАвторы  предлагают, кое-как oko okokoko kok. \n";
        try {
            String actual = service.deleteDefineSizeWordWithFirstConsonant(input, 6);
            assertEquals(actual, expected);
        } catch (TextException e) {
            fail();
        }
    }

    @Test(expectedExceptions = TextException.class)
    public void testExceptionNullDeleteDefineSizeWordWithFirstConsonant() throws TextException {
        String actual = service.deleteDefineSizeWordWithFirstConsonant(null, 6);
    }

    @Test(expectedExceptions = TextException.class)
    public void testExceptionNegativeDeleteDefineSizeWordWithFirstConsonant() throws TextException {
        String actual = service.deleteDefineSizeWordWithFirstConsonant(input, 0);
    }

}