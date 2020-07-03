package test.epam.sedkov.task5.reader;

import by.epam.sedkov.task5.exception.TextException;
import by.epam.sedkov.task5.reader.FileTextReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileTextReaderTest {

    FileTextReader fileTextReader;
    String text;

    @BeforeMethod
    public void setUp() {
        fileTextReader = new FileTextReader();
        text = "\tChanging words doesn't necessarily change the underlying concepts -- for example, in photography," +
                "\nwhat some companies still call a \"master\" flash still controls a \"slave\" flash." +
                "\n\tAnd sometimes people pick new words in an attempt to start fresh with neutral vocabulary," +
                "\nonly to find the new term picks up the baggage of the old." +
                "\n\"Water closet\" becomes \"toilet,\" which becomes \"bathroom,\" which becomes \"restroom.\"" +
                "\n\n\tАвторы доклада предлагают наращивать инвестиции в технологии, которые позволят уменьшить негативное" +
                "\nвоздействие производства аккумуляторов на окружающую среду, а также обеспечат надлежащую утилизацию" +
                "\nотработанных батарей." +
                "\n\n\tto to to totototo toto" +
                "\n\n\tqsize\tosize esize	psize lsize dsize" +
                "\nmsize";
    }

    @Test
    public void testReadTextFromFile() {
        try {
            String actual = fileTextReader.readTextFromFile("./data/textData.txt");
            assertEquals(actual,text);
        } catch (TextException e) {
            fail();
        }
    }

    @Test(expectedExceptions = TextException.class)
    public void testExceptionReadTextFromFile() throws TextException {
            String actual = fileTextReader.readTextFromFile("./data/text.txt");
    }

}