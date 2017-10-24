package ru.senla.bialevich.util.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.controller.ControllerHotelImpl;

import java.io.FileWriter;
import java.io.IOException;
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
}
