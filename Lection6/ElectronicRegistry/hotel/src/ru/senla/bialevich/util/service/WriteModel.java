package ru.senla.bialevich.util.service;

import org.apache.log4j.Logger;
import ru.senla.bialevich.controller.ControllerHotelImpl;

import java.io.*;
import java.util.List;


public class WriteModel {

    private static final Logger log = Logger.getLogger(WriteModel.class);
    private static final String PATH = ControllerHotelImpl.getInstance().getProperty("main.file");

    public void saveModel(Object object) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))) {
            oos.writeObject(object);
            oos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    public List<Object> loadModel() {

        List<Object> objects = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PATH))) {
            objects = (List<Object>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage());
        }

        return objects;
    }
}
