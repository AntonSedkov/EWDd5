package by.epam.sedkov.task5.reader;

import java.util.Scanner;
import java.util.StringJoiner;

public class ConsoleTextReader {

    private static final String STOP_EXP = "endText";

    public String readTextFromConsole() {
        Scanner scanner = new Scanner(System.in);
        StringJoiner text = new StringJoiner("\n");
        System.out.printf("To stop - write on the next line: %s", STOP_EXP);
        while (!scanner.hasNext(STOP_EXP)) {
            text.add(scanner.nextLine());
        }
        return text.toString();
    }

}
