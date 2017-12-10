package ru.senla.bialevich.util.serialization;

import org.apache.log4j.Logger;

import java.io.*;

public class WriteModel {

    private static final Logger log = Logger.getLogger(WriteModel.class);

    public void saveModel(Object object, String path) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(object);
            oos.flush();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public Object loadModel(String path) {

        Object object;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            object = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
            return null;
        }

        return object;
    }
}
