package ru.senla.bialevich.util;

import org.apache.log4j.Logger;
import ru.senla.bialevich.controller.ControllerHotelImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class WriteModel {
    private static final Logger log = Logger.getLogger(WriteModel.class);

    public void saveModel(Object object) {
        FileOutputStream fos;
        ObjectOutputStream oos;

        String path = ControllerHotelImpl.getInstance().getProperty("main.file");

        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public List<Object> loadModel() {
        List<Object> data = new ArrayList<>();

        String path = ControllerHotelImpl.getInstance().getProperty("main.file");

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object object;

            while ((object = ois.readObject()) != null) {
                data = (List<Object>) object;
            }
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage());
        }

        return data;
    }
}
