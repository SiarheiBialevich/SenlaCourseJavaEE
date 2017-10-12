package ru.senla.bialevich.util;

import com.danco.training.TextFileWorker;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteToFile {
    private String file;
    private String[] strings;
    private AnArrayOfStrings arrayOfStrings = new AnArrayOfStrings();
    private TextFileWorker fileWorker;
    private Logger log = Logger.getLogger(WriteToFile.class);

    public WriteToFile() {
        this.file = file;
    }

    public void write(String file, List list) {
        strings = arrayOfStrings.getStringArray(list);

        Path filePath = Paths.get(file);

        try {
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            log.error("Error deleting file", e);
        }

        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            log.error("Error creation file", e);
            e.printStackTrace();
        }

        fileWorker = new TextFileWorker(file);

        fileWorker.writeToFile(strings);

    }
}
