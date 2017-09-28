package ru.senla.bialevich.writeAndRead;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteObjectToFile<T> {
    public void writeToFile(final String path, final String nameFile, List<T> objects) {
        try {
            final FileOutputStream fos = new FileOutputStream(path + nameFile);
            final ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < objects.size(); i++) {
                if (objects.get(i) != null) {
                    oos.writeObject(objects.get(i));
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteObjectToFile.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {
            Logger.getLogger(WriteObjectToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
