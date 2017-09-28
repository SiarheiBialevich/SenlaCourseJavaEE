package ru.senla.bialevich.writeAndRead;

import ru.senla.bialevich.runner.Run;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadObjectFromFile<T> {
    public void readFromFile(final String path, List<T> objects) {

        try (FileInputStream fin = new FileInputStream(path)){
            ObjectInputStream ois = new ObjectInputStream(fin);

            for (int i = 0; i < objects.size(); i++) {
                T object = (T) ois.readObject();
                System.out.println(object);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Run.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Run.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
