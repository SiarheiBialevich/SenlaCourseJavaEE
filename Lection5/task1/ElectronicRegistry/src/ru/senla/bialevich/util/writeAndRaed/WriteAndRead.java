package ru.senla.bialevich.util.writeAndRaed;

import com.danco.training.TextFileWorker;
import ru.senla.bialevich.util.Printer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteAndRead {
    private String TEST_FILE;
    private String[] strings;
    private Printer printer = new Printer();
    private AnArrayOfStrings arrayOfStrings = new AnArrayOfStrings();
    private TextFileWorker fileWorker;

    public WriteAndRead(String arg1) {
        TEST_FILE = arg1;
    }

    public void writeToFile(List list) {
        strings = arrayOfStrings.getStringArray(list);

        //Create new file
        Path filePath = Paths.get(TEST_FILE);
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileWorker = new TextFileWorker(TEST_FILE);

        fileWorker.writeToFile(strings);
    }

    public void readFromFile() {
        fileWorker = new TextFileWorker(TEST_FILE);

        Object[] readedValues = fileWorker.readFromFile();

        // Check result
        for (int i = 0; i < strings.length; i++) {

            if (!readedValues[i].equals(strings[i])) {
                throw new RuntimeException("Error. Not equal values: " + readedValues[i] + " and " + strings[i]);
            }
        }

        for (Object object : readedValues) {
            printer.print(object);
        }
    }
}
