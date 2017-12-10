package ru.senla.bialevich.util.serialization;

import org.apache.log4j.Logger;
import ru.senla.bialevich.controller.ControllerHotelImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteObject {
    private static final Logger LOG = Logger.getLogger(WriteObject.class);

    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String path = ControllerHotelImpl.getInstance().getProperty("path.to.entity.file");
    private FileWriter fileWriter;

    public WriteObject() {
    }

    public void writeObject(String[] values) {
        try {
            fileWriter = new FileWriter(path);
            for (String line : values) {
                fileWriter.append(line);
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    public List<String> readFile(String path) {
        List<String> result = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }
}
